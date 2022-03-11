import java.util.HashMap;
import java.util.Random;

/**
 * clasa clientilor, indiferent de tip
 */
public abstract class Client {
    /**
     * id-ul unic al unui client
     */
    private int id;

    /**
     * numele clientuli
     */
    private String nume;

    /**
     * adresa clientului
     */
    private String adresa;

    /**
     * numarul de participari la licitatii
     */
    private int nrParticipari;

    /**
     * numarul de licitatii castigate
     */
    private int nrLicitatiiCastigate;

    /**
     * mapa pt salvarea tuturor licitatiilor la care particip si brokerul asociat
     * id produs + broker
     */
    HashMap<Integer,Broker> licitatii;

    /**
     * salveaza pretul maxim oferit pt un produs
     * id produs + pret
     */
    HashMap<Integer, Double> maxPret;

    /**
     * salveaza pretul oferit ultima runda pt un produs
     * id produs + pret
     */
    HashMap<Integer, Double> pretAnterior;

    /**
     * salveaza pretul maxim oferit pt un produs dintre toti clientii participanti
     * id-ul produs + pret
     */
    HashMap<Integer, Double> pretMaxAnterior;


    /**
     * Constructor cuoarametri
     * @param id - ul unic al clientului
     * @param nume -le clientului
     * @param adresa clientului
     */
    public Client(int id, String nume, String adresa) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.maxPret = new HashMap<>();
        this.licitatii = new HashMap<>();
        this.pretAnterior = new HashMap<>();
        this.pretMaxAnterior = new HashMap<>();
    }

    /**
     * metoda ce este implementata in persoana fizica si persoana juridica
     * @return se va returna procentul comisionului pe care si-l opreste broker-ul
     */
    public abstract double getComisionProcent();


    /**
     * getter pentru id
     * @return id-ul clientului
     */
    public int getId() {
        return id;
    }

    /**
     * setter pentru id
     * @param id - ul unic al clientului
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter pentru nume
     * @return numele clientului
     */
    public String getNume() {
        return nume;
    }

    /**
     * getter pentru adresa
     * @return adresa clientului
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * getter pentru nr de participari
     * @return returneaza nr de participari la lictatii al unui client
     */
    public synchronized int getNrParticipari() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return nrParticipari;
    }

    /**
     * metoda prin care se incrementeaza nr de participari al unui client la licitatii
     */
    public synchronized void incrementNrParticipari() {
        this.nrParticipari++;
    }

    /**
     * getter pentru licitatiile castigate
     * @return nr de licitatii castigate
     */
    public int getNrLicitatiiCastigate() {
        return nrLicitatiiCastigate;
    }


    /**
     //* @param idProd - id-ul produsul pt care se liciteaza
     * @param idLic - id-ul licitatiei
     * @param pret - ul minim
     *  metoda se apeleaza cand se citesc comenziile din fisier
     *  si se va apela imediat inaintea metodei verificaParticipati care porneste Licitatia
     */
    public void liciteazaProdus(int idLic, double pret) {
        Casa_de_Licitatii c = Casa_de_Licitatii.getInstance();
        this.licitatii.put(idLic, c.getRandomBroker(this));
        this.maxPret.put(idLic, pret);
    }

    /**
     * @param idLic - id-ul licitatiei
     *  Se calculeaza un pret pentru pasul urmator de licitatie, iar acest pret
     *              este trimis catre casa de licitatii prin intermediul broker-ului
     *   Algoritmul pentru pret:
     *              Daca nu s-a facut nicio oferta, pretul oferit in prima runda va fi
     *              o anumita cantitate din pretul maxim al acelui produs.
     *              Daca s-a facut deja oferta, se tot adauga un max de 20%, atata timp
     *              cat nu depaseste bugetul clientului
     *   Apelez sendMessage pentru a se face legatura cu casa, prin intermediul broker-ului
     */
    public void send(int idLic) {
        double max = maxPret.get(idLic);
        double pret = 0;

        if (!pretMaxAnterior.containsKey(idLic)) {
                pret = max / 2.5;
                incrementNrParticipari();
        } else {
            double pretMaxAnt = pretMaxAnterior.get(idLic);
            if (max > pretMaxAnt) {
                Random rand = new Random();
                pret = pretMaxAnt + rand.nextInt((int)max/20);
                if (pret > max) {
                    pret = max;
                }
            } else {
                pret = max;
            }
        }
        pretAnterior.put(idLic, pret);
        licitatii.get(idLic).sendMessage(idLic, pret, true);
    }

    /**
     * @param id -ul produsului
     * @param pret -ul produsului
     * se pune in mapa de pretMaxAnterior id-ul produsul si pretul maxim oferit
     *             la pasul anterior, pentru a putea tine evidenta
     */
    public void receive(int id, double pret) {
        pretMaxAnterior.put(id, pret);
        if (pret == pretAnterior.get(id)) {
            Casa_de_Licitatii.getInstance().licitatii
                    .stream()
                    .filter(l->l.getId()==id)
                    .findFirst()
                    .get()
                    .addClientiPretMax(this);
        }
    }

    /**
     * metoda care creste nr licitatiilor castigate pentru o persoana
     */
    public void increaseNrLicitatiiCastigate() {
        this.nrLicitatiiCastigate++;
    }
}
