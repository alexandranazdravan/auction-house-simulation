/**
 * un tip de client
 */
public class Persoana_Juridica extends Client {
    /**
     * SRL sau SA
     */
    Comp companie;
    /**
     * capitalul pe care il are compania
     */
    private double capitalSocial;


    /**
     * Constructor cu oarametri
     * @param id -ul clientului
     * @param nume -le companiei
     * @param adresa - unde se afla compania
     * @param companie - SRL sau SA
     * @param capit - capitalul social al companiei
     */
    public Persoana_Juridica(int id, String nume, String adresa, Comp companie, double capit) {
        super(id, nume, adresa);
        this.companie = companie;
        this.capitalSocial = capit;
    }


    /**
     * getter pentru tipul de companie
     * @return tipul companiei
     */
    public Comp getCompanie() {
        return companie;
    }

    /**
     * @param companie SA sau SRL
     */
    public void setCompanie(Comp companie) {
        this.companie = companie;
    }

    /**
     * getter pentru capitalul social
     * @return capitalul social al companiei
     */
    public double getCapitalSocial() {
        return capitalSocial;
    }

    /**
     * @param capitalSocial pe care il are compania
     */
    public void setCapitalSocial(double capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    /**
     *metoda care face downcasting
     * @param client -ul pentru care se face downcasting
     * @return returnez capitalul social si tipul comapniei
     */
    public static String down(Client client) {
        Persoana_Juridica p = (Persoana_Juridica) client;
        return p.capitalSocial + " " + p.companie;
    }

    /**
     * Metoda prin care returnez comisionul in functie de nr de participari
     * @return procentul pe care si-l ia broker-ul
     */
    @Override
    public synchronized double getComisionProcent() {
        if (getNrParticipari() < 25) {
            return 0.25;
        }
        return 0.10;
    }
}
