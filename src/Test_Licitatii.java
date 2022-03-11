import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Clasa care contine main-ul si unde se testeaza functionalitatea programului
 */
public class Test_Licitatii {
    /**
     * @param args vector de obiecte de tip String
     * @throws FileNotFoundException - in caz ca nu se gaseste fisierul din care vreau sa citesc
     */
    public static void main(String[] args) throws FileNotFoundException {
        ReadInput r = new ReadInput();
        Administrator ad = r.returnAd();
        Casa_de_Licitatii casa_de_licitatii = Casa_de_Licitatii.getInstance();
        casa_de_licitatii.setAd(ad);
        casa_de_licitatii.clienti = r.returnClientiList();
        casa_de_licitatii.brokeri = r.returnBrokers();
       // !!!! admin ul trb sa adauge
        ArrayList<Produs> prod = r.returnProduse();
        for (Produs produs : prod) {
            ad.addProdus(produs);
        }
        casa_de_licitatii.licitatii = r.returnLicitatii();
        Console c = new Console();
        try {
            c.doStuff();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
