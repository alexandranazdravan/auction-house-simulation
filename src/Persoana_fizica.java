/**
 * un tip de client, caracterizat prin data de nastere
 */
public class Persoana_fizica extends Client{
    /**
     * data de nastere e specifica unei persoane fizice
     */
    private String dataNastere;


    /**
     * Constructor cu parametri
     * @param id - ul clientului
     * @param nume -le clientului
     * @param adresa la care locuieste clientul
     * @param dataNastere - data cadn s-a nascut clientul
     */
    public Persoana_fizica(int id, String nume, String adresa, String dataNastere) {
        super(id, nume, adresa);
        this.dataNastere = dataNastere;
    }

    /**
     * getter pentru data de nastere
     * @return data nasterii a unui client
     */
    public String getDataNastere() {
        return dataNastere;
    }


    /**
     * metoda care face downcasting(necesara la metode de afisare)
     * @param client -ul pentru care vreau downcasting
     * @return data de nasterii a clientului pt care s-a facut downcasting
     */
    public static String down(Client client) {
        Persoana_fizica p = (Persoana_fizica) client;
        return p.dataNastere;
    }

    /**
     * Metoda prin care returnez comisionul in functie de nr de participari
     * @return procentul luat de broker
     */
    @Override
    public synchronized double getComisionProcent() {
        if (getNrParticipari() < 5) {
            return 0.2;
        }
        return 0.15;
    }
}
