/**
 * interfata pentru design pattern-ul Mediator
 */
public interface Mediator {

    /**
     * @param id - ul produsului
     * @param pret - ul unui produs pana intr-un punct
     * @param mediator - true sau false, ca sa stiu daca ma duc spre casa
     *                 de licitatii sau spre client
     */
    public void sendMessage(int id, double pret, boolean mediator);
}
