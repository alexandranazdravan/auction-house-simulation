/**
 * unul din cele 3 tipuri de produse
 */
public class Bijuterie extends Produs {
    /**
     * bijuteriile sunt caracterizate de material
     */
    private String material;

    /**
     * si de asemenea, sunt caracterizate si de pietrele pretioase
     */
    private boolean piatraPretioasa;

    /**
     * Constructor cu parametri
     * @param id              -ul produsului
     * @param nume            - cum este prezentat produsul
     * @param pretMinim       - produsul se va vinde sub acest pret
     * @param an              -anul in care a fost fabricat
     * @param material        - aur, argint, perle, etc
     * @param piatraPretioasa - e true sau false(depinde daca contine pietre pretioase sau nu)
     */
    public Bijuterie(int id, String nume, double pretMinim, int an, String material, boolean piatraPretioasa) {
        super(id, nume, pretMinim, an);
        this.material = material;
        this.piatraPretioasa = piatraPretioasa;
    }

    /**
     * getter pentru material
     * @return materialul din care e facuta bijuteria
     */
    public String getMaterial() {
        return material;
    }

    /**
     * getter pentru pietrele pretioase
     * @return true sau false
     */
    public boolean isPiatraPretioasa() {
        return piatraPretioasa;
    }

}
