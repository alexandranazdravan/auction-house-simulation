import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

/**
 * clasa in care citesc din fisier
 */
public class ReadInput {
    /**
     * cu ajutorul lui citesc din fisier
     */
    Scanner s;
    {
        try {
            s = new Scanner(new File("licitatie0.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * creez adminul pe baza CNP-ului
     * @return administratorul creat
     */
    public  Administrator returnAd() {
        String data = s.nextLine();
        Administrator ad = new Administrator(data);
        return ad;
    }


    /**
     * creez lista de clienti si o returnez
     * @return lista clientilor creata
     */
    public ArrayList<Client> returnClientiList() {
        int nrClienti = Integer.parseInt(s.nextLine());
        ArrayList<Client> clienti = new ArrayList<>();
        for(int i = 0;i<nrClienti;i++) {
            String[] splited = s.nextLine().split("\\+");
            if (splited[3].equals("Persoana_fizica")) {
                Persoana_fizicaBuilder persf = new Persoana_fizicaBuilder();
                Client c = persf.createPersoana_fizica(splited);
                clienti.add(c);
            } else if (splited[3].equals("Persoana_Juridica")) {
                Persoana_JuridicaBuilder persj = new Persoana_JuridicaBuilder();
                Client c = persj.createPersoana_Juridica(splited);
                clienti.add(c);
            }
        }
        return clienti;
    }

    /**
     * creez lista de brokeri
     * @return lista broker-ilor creata in urma citirii din fisier
     */
    public ArrayList<Broker> returnBrokers() {
        int nrBrokeri = Integer.parseInt(s.nextLine());
        ArrayList<Broker> bk = new ArrayList<>();
        for(int i = 0; i < nrBrokeri; i++) {
            String st = s.nextLine();
            Broker b = new Broker(st);
            bk.add(b);
        }
        return bk;
    }


    /**
     * creez lista de produse
     * @return lista de produse creata in urma citirii din fisier
     */
    public ArrayList<Produs> returnProduse() {
        ArrayList<Produs> temporarProd = new ArrayList<>();
        int nrProduse = Integer.parseInt(s.nextLine());
        for (int i = 0; i < nrProduse; i++) {
            ProdusFactory prod = ProdusSingleton.Instanta();
            String[] st = s.nextLine().split("\\+");
            Produs p = prod.getProdus(st[4], st);
            temporarProd.add(p);
        }
        return temporarProd;
    }


    /**
     * creez lista licitatiilor
     * @return lista licitatiilor posibile
     */
    public ArrayList<Licitatie> returnLicitatii() {
        ArrayList<Licitatie> lic = new ArrayList<>();

        int nrLicitatii = Integer.parseInt(s.nextLine());
        for (int i = 0; i < nrLicitatii; i++) {
            String[] st = s.nextLine().split("\\+");
            lic.add(new Licitatie(
                    Integer.parseInt(st[0]),
                    Integer.parseInt(st[1]),
                    Integer.parseInt(st[2]),
                    Integer.parseInt(st[3]))
            );
        }
        return lic;
    }
}
