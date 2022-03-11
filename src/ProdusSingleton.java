/**
 * Design Pattern-ul Singleton aplicat pe Produs, cu ajutorul lui Factory
 */
public class ProdusSingleton {
    /**
     * produsul pe care aplic singleton
     */
    private static ProdusFactory prod;

    /**
     * constructor
     */
    private ProdusSingleton() {
    }

    /**
     * @return instanta unica a unui anumit produs
     */
    public static ProdusFactory Instanta() {
        if (prod == null)
            prod = new ProdusFactory();
        return prod;
    }
}
