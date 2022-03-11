import java.util.*;
/**
 * Casa de licitatii, care este unica
 */
public class Casa_de_Licitatii {
    /**
     * variabila folosita pentru Observer
     */
    private int state;

    /**
     * lista produselor
     */
    ArrayList<Produs> deVanzare;

    /**
     * lista clientilor
     */
    ArrayList<Client> clienti;

    /**
     * lista licitatiilor active, in care se afla id-ul licitatiei si pretul maxim oferit
     */
    HashMap<Integer, Double> licitatiiActive;

    /**
     * lista cu toate licitatiile, fara sa fie active
     */
    ArrayList<Licitatie> licitatii;

    /**
     * lista tuturor broker-ilor angajati
     */
    ArrayList<Broker> brokeri;

    /**
     * administratorul unic
     */
    private Administrator ad;

    /**
     * casa de licitatii unica, pe care implementez Singleton
     */
    private static Casa_de_Licitatii c;

    /**
     * Constructor fara parametri
     */
    private Casa_de_Licitatii() {
        this.deVanzare = new ArrayList<>();
        this.clienti = new ArrayList<>();
        this.licitatiiActive = new HashMap<>();
        this.brokeri = new ArrayList<>();
        this.licitatii = new ArrayList<>();
    }

    /**
     * metoda utilizata pentru Sigleton
     * @return returneaza instanta unica a casei de licitatii
     */
    public static Casa_de_Licitatii getInstance() {
        if (c == null) {
            c = new Casa_de_Licitatii();
        }
        return c;
    }

    /**
     * getter pentru lista produselor
     * @return lista produselor disponibile pt vanzare
     */
    public ArrayList<Produs> getDeVanzare() {
        return deVanzare;
    }


    /**
     * getter pentru lista clientilor
     * @return returneaza clientii inscrisi
     */
    public ArrayList<Client> getClienti() {
        return clienti;
    }


    /**
     * getter pentru licitatiile active
     * @return returneaza lista licitatiilor incepute
     */
    public HashMap<Integer, Double> getLicitatiiActive() {
        return licitatiiActive;
    }

    /**
     * getter pentru lista de brokeri
     * @return returneaza lista broker-ilor angajatu la casa de licitatii
     */
    public ArrayList<Broker> getBrokeri() {
        return brokeri;
    }

    /**
     * getter pentru obtinerea admin-ului
     * @return returneaza admin-ul casei de licitatii
     */
    public Administrator getAd() {
        return ad;
    }

    /**
     * @param ad setter pentru setarea adminului
     */
    public void setAd(Administrator ad) {
        this.ad = ad;
    }

    /**
     * @param state - va deveni 1 atunci cand licitatia va fi pornita
     *              si toti brokerii vor fi anuntati
     */
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    /**
     * Fiecare broker in parte va fi anuntat de inceperea licitatiei,
     *          deoarece toti brokerii participa la licitatii
     */
    public void notifyAllObservers(){
        for (Broker broker : brokeri) {
            broker.update();
        }
    }


    /**
     * metoda care imi printeaza lista clientilor, verificand la fiecare pas daca
     * acestia sunt persoane fizice sau juridice
     */
    public void printClienti() {
        for (Client client : clienti) {
            if (client instanceof Persoana_fizica) {
                System.out.println(client.getId() +
                        " " +
                        client.getNume() +
                        " " +
                        client.getAdresa() +
                        " " +
                        client.getNrParticipari() +
                        " " +
                        client.getNrLicitatiiCastigate() +
                        " " +
                        Persoana_fizica.down(client)
                );
        }
            if(client instanceof Persoana_Juridica) {
                System.out.println(client.getId() +
                        " " +
                        client.getNume() +
                        " " +
                        client.getAdresa() +
                        " " +
                        client.getNrParticipari() +
                        " " +
                        client.getNrLicitatiiCastigate() +
                        " " +
                        Persoana_Juridica.down(client)
                );
            }
        }
    }

    /**
     * metoda care imi afiseaza toate licitatiile
     */
    public void printLicitatiiTotale() {
        if(licitatii.isEmpty()) {
            System.out.println("Inca nu s-au adaugat licitatii");
        }
        else {
            for (Licitatie licitatie : licitatii) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                licitatie.printLicitatie();
            }
        }
    }

    /**
     * metoda care imi afiseaza doar licitatiile active
     */

    public void printLicitatiiActive() {
        if(licitatiiActive.isEmpty()) {
            System.out.println("Inca nu a inceput nicio licitatie " +
                    "sau deja s-au incheiat toate");
        }
        else {
            for(Integer i: licitatiiActive.keySet()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Licitatia cu id-ul " + i
                        + " este activa");
            }
        }
    }

    /**
     * Metoda care imi afiseaza un broker pe o linie, iar apoi, imediat sub el,
     *          imi afiseaza clientii asociati lui
     */
    public void printBrokersAndClients()  {
        if(brokeri.isEmpty() || clienti.isEmpty()) {
            System.out.println("Nu exista clienti sau brokeri");
        }
        else {
            for (Broker broker : brokeri) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                broker.printBroker();
                broker.printClienti();
            }
        }
    }

    /**
     * metoda care imi printeaza toate produsele, verificand de ce tip este produsul respectiv
     */
    public void printProduse() {
        if(deVanzare.isEmpty()) {
            System.out.println("Nu exista inca produse");
            return;
        }
        for (Produs p : deVanzare) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(p instanceof Mobila){
                System.out.println(p.getId() +
                        " " +
                        p.getNume() +
                        " " +
                        p.getPretMinim() +
                        " " +
                        p.getAn() +
                        " " +
                        ((Mobila) p).getTip() +
                        " " +
                        ((Mobila) p).getMaterial()
                );
            }
            if(p instanceof Tablou) {
                System.out.println(p.getId() +
                        " " +
                        p.getNume() +
                        " " +
                        p.getPretMinim() +
                        " " +
                        p.getAn() +
                        " " +
                        ((Tablou) p).getNumePictor() +
                        " " +
                        ((Tablou) p).getCulori()
                );
            }
            if(p instanceof Bijuterie) {
                System.out.println(p.getId() +
                        " " +
                        p.getNume() +
                        " " +
                        p.getPretMinim() +
                        " " +
                        p.getAn() +
                        " " +
                        ((Bijuterie) p).getMaterial() +
                        " " +
                        ((Bijuterie) p).isPiatraPretioasa()
                );
            }
        }
    }

    /**
     * Metoda care imi afiseaza brokerii
     */
    public void printBrokers() {
        if(brokeri.isEmpty()) {
            System.out.println("Inca nu s-au adaugat brokeri");
        }
        else {
            for (Broker broker : brokeri) {
                broker.printBroker();
            }
        }
    }

    /**
     * @param client -ul caruia ii trebuie asociat un broker
     * metoda care ii asociaza clientului un broker in mod aleator
     * @return broker-ul pentru clientuul primit ca parametru
     */
    public Broker getRandomBroker(Client client) {
        Random rand = new Random();
        int randBroker = rand.nextInt(brokeri.size());
        Broker broker = brokeri.get(randBroker);
        broker.getClienti().add(client);
        return broker;
    }

    /**
     * @param id-ul produsului licitat
     *  Metoda prin care se anunta de inceperea unei licitatii toti brokerii
     *  In licitatii active, se salveaza id-ul unui produs si pretul maxim la fiecare pas
     *  In lista de brokeri, se cauta sa vada daca exista vreunul al carui client sa-si
     *          doreasca sa liciteze pentru produsul respectiv. Daca da, se incepe licitatia
     */
    public void turnOn(int id) {
        Optional<Licitatie> licitatie = licitatii.
                        stream().
                        filter(l -> l.getId() == id).
                        findFirst();
        if (licitatie.isPresent()) {
            Licitatie l = licitatie.get();
            licitatiiActive.put(l.getId(), 0.0);
            for (Broker broker : brokeri) {
                for (Client client : broker.getClienti()) {
                    if (client.licitatii.containsKey(l.getId())) {
                        broker.start(l.getId(), l.getNrPasiMaxim());
                        break;
                    }
                }
            }
        }
        else{
            System.out.println("Nu exista produsul solicitat");
        }
    }

    /**
     * @param licitatie licitatia pe care dorim s-o inchidem
     * Din licitatia activa, salvez pretul maxim si-l compar sa vad daca e mai mare
     *                  decat pretul minim obligatoriu atribuit produsului; daca e mai mic,
     *                  produsul nu se vinde
     * Daca e mai mare, folosesc TreeSet pentru a-mi face o lista sortata cu toti clientii
     *                  care au licitat pentru profudul pr si care au oferit, la final, aceeasi
     *                  suma. Criteriul dupa care ii ordonez este nr de licitatii castigate.
     *                  De aceea, datorita acestei ordonari, primul din lista este ales.
     * La final, broker-ul isi aplica comisionul, se sterge licitatia din lista licitatiilor
     *                  active, se incrementeaza nr de licitatii castigate pentru clientul
     *                  castigator, se sterge produsul din lista de produse si se afiseaza
     *                  un mesaj.
     */
    public synchronized void inchidelicitatie(final Licitatie licitatie) {
        final double pretMax = this.licitatiiActive.get(licitatie.getId());
        Produs pr = deVanzare.
                stream().
                filter(p -> p.getId() == licitatie.getIdProdus()).
                findFirst().
                get();

            if (pretMax < pr.getPretMinim()) {
                System.out.println("Produsul nu e vandut");
            } else {
                TreeSet<Client> sort = new TreeSet<>((o1, o2) -> {
                    if (o1.getNrLicitatiiCastigate()
                            == o2.getNrLicitatiiCastigate()) {
                        return o1.getId() - o2.getId();
                    }
                    return o2.getNrLicitatiiCastigate()
                            - o1.getNrLicitatiiCastigate();
                });
                sort.addAll(licitatie.getClientiPretMax());
                Client castigator = sort.first();

                Broker br = castigator.licitatii.
                        get(licitatie.getId());

                pr.setPretVanzare(br.addComision(castigator,
                        licitatie.getId()));

                castigator.increaseNrLicitatiiCastigate();
                System.out.println("Clientul "
                        + sort.first().getNume()
                        + " a castigat licitatia pentru produsul "
                        + pr.getNume()
                        + " si s-a dat pe produs suma de "
                        + licitatiiActive.remove(licitatie.getId())
                );
                br.removeProdus(pr);
            }
    }

    /**
     * @param idLic -ul licitatiei
     * @param pret-ul unui produs
     * Metoda prin care se schimba pretul unui produs, in functie de oferta
     */
    public void receive(int idLic, double pret) {
        double pretVechi = licitatiiActive.get(idLic);
        if (pretVechi < pret) {
            licitatii.
                    stream().
                    filter(l->l.getId()==idLic).
                    findFirst().
                    get().
                    getClientiPretMax().
                    clear();
            licitatiiActive.put(idLic, pret);
        }
    }

    /**
     * @param idLic - id-ul licitatiei
     * @param broker-ul asociat clientului care liciteaza in aceasta licitatie
     * Se anunta broker-ul ca trebuie sa sa comunice cu clientul
     */
    public void send(int idLic, Broker broker) {
        broker.sendMessage(idLic,
                licitatiiActive.get(idLic),
                false);
    }

    /**
     * @param id-ul unui produs
     * Folosesc un stream pentru a-mi gasi mai usor licitatia care are id-ul produsului
     *          egal cu id-ul dat ca parametru si o returnez daca nu e nula
     * @return licitatia pe care o cautam
     */
    public Licitatie getLicByProdId(int id) {
        Optional<Licitatie> lc =  licitatii.
                stream().
                filter(l->l.getIdProdus()==id).
                findFirst();
        return lc.orElse(null);
    }

    /**
     * @param idLicitatie - id-ul unei licitatii
     * Daca numarul de participanti necesari pentru o anumita licitatie e egal cu
     *                    cel real, cu nr celor inscrisi pe parcurs, atunci se incepe
     *                    licitatia
     */
    public void verificaParticipanti(int idLicitatie) {
        int participanti = (int) clienti.stream()
                .filter(c->c.licitatii.containsKey(idLicitatie))
                .count();
        Licitatie licitatie = licitatii.stream()
                .filter(l->l.getId()==idLicitatie)
                .findFirst()
                .get();
        if (participanti == licitatie.getNrParticipanti()) {
            c.setState(1);
            licitatie.run();
        }
    }

    /**
     * Metoda prin care afisez informatie despre administrator
     */
    public void printAdmin() {
        System.out.println("Admin-ul unic are CNP-ul " + ad.getCnp());
    }
}

