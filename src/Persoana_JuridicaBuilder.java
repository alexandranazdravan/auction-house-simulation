/**
 * design pattern-ul Builder aplicat pe persoana juridica
 */
public class Persoana_JuridicaBuilder {
    /**
     * id-ul clientului
     */
    private int id;
    /**
     * numele companiei
     */
    private String nume;
    /**
     * adresa companiei
     */
    private String adresa;
    /**
     * nr de participari al clientului
     */
    private int nrParticipari;
    /**
     * nr de licitatii castigate de client
     */
    private int nrLicitatiiCastigate;
    /**
     * SA sau SRL
     */
    private Comp companie;
    /**
     * capitalul social al comapniei
     */
    private double capit;

    /**
     * @param id -ul unic al clientului
     * @return persoana juridica, adica clientul
     */
    public Persoana_JuridicaBuilder setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * @param nume -le companiei
     * @return clientul
     */
    public Persoana_JuridicaBuilder setNume(String nume) {
        this.nume = nume;
        return this;
    }

    /**
     * @param adresa la care se afla compania
     * @return compania, adica clientul
     */
    public Persoana_JuridicaBuilder setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    /**
     * @param nrParticipari - seteaza nr de participari
     * @return clientul
     */
    public Persoana_JuridicaBuilder setNrParticipari(int nrParticipari) {
        this.nrParticipari = nrParticipari;
        return this;
    }

    /**
     * @param nrLicitatiiCastigate -seteaza nr de licitatii castigate
     * @return clientul
     */
    public Persoana_JuridicaBuilder setNrLicitatiiCastigate(int nrLicitatiiCastigate) {
        this.nrLicitatiiCastigate = nrLicitatiiCastigate;
        return this;
    }

    /**
     * @param companie SA sau SRL
     * @return clientul
     */
    public Persoana_JuridicaBuilder setCompanie(Comp companie) {
        this.companie = companie;
        return this;
    }

    /**
     * @param capit - capitalul social al unei companii
     * @return clientul
     */
    public Persoana_JuridicaBuilder setCapit(double capit) {
        this.capit = capit;
        return this;
    }

    /**
     * @param st - string-ul din care imi iau valorile pt care creez persoana juridica
     * @return persoana juridica creata
     */
    public Persoana_Juridica createPersoana_Juridica(String[] st) {
        if(st[4].equals("SRL")) {
            return new Persoana_Juridica(Integer.parseInt(st[0]),st[1],st[2]
                    ,Comp.SRL,Double.parseDouble(st[5]));
        }
        if(st[4].equals("SA")){
            return new Persoana_Juridica(Integer.parseInt(st[0]),st[1],st[2]
                    ,Comp.SA,Double.parseDouble(st[5]));
        }
        return null;
    }
}