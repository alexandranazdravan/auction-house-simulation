import java.util.ArrayList;

/**
 * O licitatie la care s-a atins nr de participanti inseamna un thread pornit
 */
public class Licitatie implements Runnable {

    /**
     * id-ul licitatiei
     */
    private int id;
    /**
     * nr de participanti necesari
     */
    private int nrParticipanti;
    /**
     * id-ul produsului pt care are loc licitatia
     */
    private int idProdus;
    /**
     * se opreste licitatia dupa acest nr de pasi
     */
    private int nrPasiMaxim;

    /**
     * Identifica lista de clienti care au oferit pretul maxim
     */
    private ArrayList<Client> clientiPretMax;

    /**
     * Constructor cu parametri
     * @param id - ul licitatiei
     * @param nrParticipanti - necesar pt inceperea licitatiei
     * @param idProdus -ului pt care se liciteaza
     * @param nrPasiMaxim - dupa acest nr de pasi, se opreste licitatia
     */
    public Licitatie(int id,int nrParticipanti,int idProdus, int nrPasiMaxim) {
        this.id = id;
        this.nrParticipanti = nrParticipanti;
        this.idProdus = idProdus;
        this.nrPasiMaxim = nrPasiMaxim;
        this.clientiPretMax = new ArrayList<>();
    }

    /**
     * @return getter pentru id-ul licitatiei
     */
    public int getId() {
        return id;
    }

    /**
     * setter pt id-ul licitatiei
     * @param id - ul licitatiei
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter pentru nr de participanti
     * @return nr de participanti necesari
     */
    public int getNrParticipanti() {
        return nrParticipanti;
    }

    /**
     * getter pentru id-ul produsului
     * @return id-ul produsului din licitatie
     */
    public int getIdProdus() {
        return idProdus;
    }

    /**
     * getter nr pasi maxim
     * @return nr de pasi maxim al unei licitatii
     */
    public int getNrPasiMaxim() {
        return nrPasiMaxim;
    }

    /**
     * Returneaza lista cu clientii care au oferit pretul maxim
     * @return lista clientilor care au oferit toti pretul maxim
     */
    public ArrayList<Client> getClientiPretMax() {
        return clientiPretMax;
    }

    /**
     * Adauga clientul care a adaugat pretul maxim
     * @param c adauga clientul c, un posibil castigator, in lista
     */
    public void addClientiPretMax(Client c) {
        clientiPretMax.add(c);
    }

    /**
     * metoda care printeaza informatii generale despre o licitatie
     */
    public void printLicitatie() {
        System.out.println("id-ul clientului: " +
                id +
                " ,id-ul produsului: " +
                idProdus +
                " ,numar de participanti necesar:  " +
                nrParticipanti +
                " ,numar pasi maxim: " +
                nrPasiMaxim
        );
    }

    /**
     * metoda de run a unui fir de executie
     * De la metoda turnOn, incepe restul procesului de licitatie. Dupa
     *              ce se termina acest proces, inchid licitatia in mod
     *              "oficial"
     */
    @Override
    public void run() {
        try {
            Casa_de_Licitatii cL = Casa_de_Licitatii.getInstance();
            cL.turnOn(this.getId());
            Thread.sleep(1000);
            cL.inchidelicitatie(this);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
