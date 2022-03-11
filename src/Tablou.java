/**
 * tip de produs, caracterizat prin numele artistului care l-a pictat si tipul de
 * culori utilizat
 */
public class Tablou extends Produs {
    /**
     * numele pictorului care a creat tabloul
     */
    private String numePictor;
    /**
     * ulei tempera sau acrilic
     */
    private Culori culori;


    /**
     * Constructor cu parametri
     * @param id -ul produsului
     * @param nume -le produsului
     * @param pretMinim cu care va fi vandut produsul
     * @param an -ul fabricatiei produsului
     * @param numePictor - ului care a pictat tabloul
     * @param culori - tipul de culori pe care l-a folosit
     */
    public Tablou(int id, String nume, double pretMinim, int an, String numePictor, Culori culori) {
        super(id, nume, pretMinim, an);
        this.numePictor = numePictor;
        this.culori = culori;
    }

    /**
     * getter pentru numele pictorului
     * @return numele pictorului
     */
    public String getNumePictor() {
        return numePictor;
    }

    /**
     * getter pentru culorile folosite
     * @return culorile folosite
     */
    public Culori getCulori() {
        return culori;
    }
}
