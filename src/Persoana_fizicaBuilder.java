/**
 * design pattern-ul builder
 */
public class Persoana_fizicaBuilder {
    /**
     * id-ul unui client
     */
    private int id;
    /**
     * numele unui client
     */
    private String nume;
    /**
     * adresa unui client
     */
    private String adresa;
    /**
     * nr de participari la licitatii al unui client
     */
    private int nrParticipari;
    /**
     * nr de licitatii castigate al unui client
     */
    private int nrLicitatiiCastigate;
    /**
     * data nasterii unui client
     */
    private String dataNastere;

    /**
     * @param id id-ul clientului
     * @return clientul cu id-ul respectiv
     */
    public Persoana_fizicaBuilder setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * @param nume -le clientului
     * @return persoana cu numele respectiv
     */
    public Persoana_fizicaBuilder setNume(String nume) {
        this.nume = nume;
        return this;
    }

    /**
     * @param adresa unde locuieste clientul
     * @return clientul
     */
    public Persoana_fizicaBuilder setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    /**
     * @param nrParticipari seteaza nr de participari al unui client
     * @return clientul
     */
    public Persoana_fizicaBuilder setNrParticipari(int nrParticipari) {
        this.nrParticipari = nrParticipari;
        return this;
    }

    /**
     * @param nrLicitatiiCastigate seteaza nr de licitatii castigate al unui client
     * @return clientul
     */
    public Persoana_fizicaBuilder setNrLicitatiiCastigate(int nrLicitatiiCastigate) {
        this.nrLicitatiiCastigate = nrLicitatiiCastigate;
        return this;
    }

    /**
     * @param dataNastere seteaza data de nastere
     * @return clientul
     */
    public Persoana_fizicaBuilder setDataNastere(String dataNastere) {
        this.dataNastere = dataNastere;
        return this;
    }

    /**
     * @param st string in care imi iau valorile
     * @return clientul creat cu ajutorul string-ului dat ca parametru
     */
    public Persoana_fizica createPersoana_fizica(String[] st) {
        return new Persoana_fizica(Integer.parseInt(st[0]), st[1], st[2], st[4]);
    }
}