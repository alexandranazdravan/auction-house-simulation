/**
 * este un tip de produs, definit prin tipul mobilei si materialul din care e facuta
 */
public class Mobila extends Produs{
    /**
     * tipul mobilei
     */
    private String tip;
    /**
     * materialul din care e fabricata mobila
     */
    private String material;


    /**
     * Constructor cu parametri
     * @param id - ul produsului
     * @param nume -le produsului
     * @param pretMinim cu care se va vinde produsul
     * @param an -ul fabricatiei
     * @param tip -ul mobilei
     * @param material -ul din care e confectionata
     */
    public Mobila(int id, String nume, double pretMinim, int an, String tip, String material) {
        super(id, nume, pretMinim, an);
        this.tip = tip;
        this.material = material;
    }

    /**
     * getter pentru tipul mobilei
     * @return tipul mobilei
     */
    public String getTip() {
        return tip;
    }

    /**
     * getter pentru materialul din care e facuta mobila
     * @return materialul din care e facuta mobila
     */
    public String getMaterial() {
        return material;
    }

}
