/**
 * Administratorul este unic
 */
public class Administrator extends Angajat{

    /**
     * @param cnp fiecare angajat are propriul lui cnp
     */
    public Administrator(String cnp) {
        super(cnp);
    }

    /**
     * @param p - produsul ce trebuie adaugat in lista
     */
    public synchronized void addProdus(Produs p) {
        Casa_de_Licitatii licitatii = Casa_de_Licitatii.getInstance();
        licitatii.getDeVanzare().add(p);
    }
}
