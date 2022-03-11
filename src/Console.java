import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

/**
 *  Consola in care verific comenzile citite din fisier si apelez metodele necesare
 */
public class Console {
    /**
     * @throws FileNotFoundException - daca nu se gaseste fisierul
     * @throws InterruptedException - daca nu se executa sleep
     * metoda in care citesc comenzile din fisier
     */
    public void doStuff() throws FileNotFoundException, InterruptedException {
        Scanner s = new Scanner(new File("comenzi0.txt"));
        Casa_de_Licitatii casa_de_licitatii = Casa_de_Licitatii.getInstance();
        int com = Integer.parseInt(s.nextLine());
        for (int i = 0; i < com; i++) {
            String[] comanda = s.nextLine().split(" ");
            if (comanda[0].equals("liciteaza")) {
                Optional<Client> optionalClient = casa_de_licitatii
                        .getClienti()
                        .stream()
                        .filter(c -> c.getId() == Integer.parseInt(comanda[2]))
                        .findFirst();

                if(optionalClient.isPresent()){
                Licitatie lic = casa_de_licitatii.
                        getLicByProdId(Integer.parseInt(comanda[1]));

                optionalClient.get().liciteazaProdus(
                        lic.getId(),
                        Double.parseDouble(comanda[3])
                );
                casa_de_licitatii.verificaParticipanti(lic.getId());

            } else {
                System.out.println("Clientul cu id-ul " + comanda[2] + " nu exista in sistem");
            }
            System.out.println("===================================================");

        } else if (comanda[0].equals("listproducts")) {
            casa_de_licitatii.printProduse();
            System.out.println("===================================================");

        } else if (comanda[0].equals("listclienti")) {
            casa_de_licitatii.printClienti();
            System.out.println("===================================================");

        } else if (comanda[0].equals("listlicitatii")) {
            casa_de_licitatii.printLicitatiiTotale();
            System.out.println("===================================================");

        } else if (comanda[0].equals("listlicitatiiactive")) {
            casa_de_licitatii.printLicitatiiActive();
            System.out.println("===================================================");

        } else if (comanda[0].equals("listbrokeri")) {
            casa_de_licitatii.printBrokers();
            System.out.println("===================================================");

        } else if (comanda[0].equals("listbrokerisiclienti")) {
            casa_de_licitatii.printBrokersAndClients();
            System.out.println("===================================================");

        } else if (comanda[0].equals("listadmin")) {
            casa_de_licitatii.printAdmin();
            System.out.println("===================================================");

        }
        }
    }
    }
