import java.util.ArrayList;
import java.util.List;

/**
 * Broker-ul este cel care intermediaza toate actiunile dintre casa de licitatii si clienti;
 * De aceea, l-am facut sub forma design pattern-ului Mediator.
 */
public class Broker extends Angajat implements Mediator, Observer {
    /**
     * lista clientilor pe care ii are un anumit broker
     */
     List<Client> clienti;


    /**
     * Constructor cu parametru
     * @param cnp -ul angajatului de tip broker
     */
    public Broker(String cnp) {
        super(cnp);
        this.clienti = new ArrayList<>();
    }

    /**
     * getter pentru cnp-ul unui broker
     * @return cnp-ul broker-ului
     */
    public String getCNP(){
        return super.getCnp();
    }


    /**
     * getter pentru lista de clienti
     * @return lista de clienti pt care lucreaza un broker
     */
    public List<Client> getClienti() {
        return clienti;
    }

    /**
     * Metoda de uodate pentru Observer
     */
    public void update() {
        System.out.println("Incepe licitatia");
    }

    /**
     * metoda care afiseaza toti clientii pe care ii are un broker
     */
    public void printClienti() {
        if (this.clienti == null){
            System.out.println("Nu exista clienti momentan");
            return;
        }
        for (Client client : clienti) {
            System.out.println(client.getId() +
                    " " +
                    client.getNume() +
                    " " +
                    client.getAdresa() +
                    " " +
                    client.getNrParticipari() +
                    " " +
                    client.getNrLicitatiiCastigate()
            );
        }
    }

    /**
     * @param client - clientul care a castigat licitatia
     * @param idProdus -ul produsul care a fost cumparat
     *  Metoda prin care broker-ul isi opreste un comision, pe anumite criterii
     *                 si returneaza pretul care ramane
     * @return returneaza suma ramasa dupa ce broker-ul si-a aplicat comisionul
     */
    public double addComision(Client client, int idProdus) {
        return (1 - client.getComisionProcent())
                * client.pretAnterior.get(idProdus);
    }


    /**
     * @param p - produsul care a fost licitat si cumparat
     *  Prin intermediul acestei metode, broker-ul sterge un produs din lista de produse
     */
    public synchronized void removeProdus(Produs p) {
        Casa_de_Licitatii licitatii = Casa_de_Licitatii.getInstance();
        if(licitatii.getDeVanzare().isEmpty())
            System.out.println("Nu avem produse, e mare saracie");
        else
            licitatii.deVanzare.remove(p);
    }

    /**
     * @param id -ul produsului licitat
     * @param pret - pretul pe care clientul il trimite catre casa de licitatii si viceversa
     * @param casa - boolean ajutator
     *  In functie de valoarea boolean-ului, stiu daca broker-ul urmeaza sa trimita informatia
     *             catre casa de licitatii sau catre client
     *  Catre casa de licitatii, trimite id-ul unui produs si pretul maxim pe care il ofera
     *             un client
     *  Catre client, trimite id-ul produsului si pretul maxim stabilit la pasul anterior
     */
    @Override
    public void sendMessage(int id, double pret, boolean casa) {
        Casa_de_Licitatii casa_licitatii = Casa_de_Licitatii.getInstance();
        if(casa) {
            casa_licitatii.receive(id, pret);
        } else {
            for (Client client : clienti) {
                if (client.licitatii.containsKey(id)) {
                    client.receive(id, pret);
                }
            }
        }
    }

    /**
     * @param id - ul produsului
     * @param nrPasi - pentru o anumita licitatie
     *  La fiecare pas trimte catre toti clientii cererea de oferta
     *  Primeste de la fiecare si trimite catre casa de licitatie
     *  Dupa ce trimis toate ofertele, cere maxim prete oferit si trimitem catre clienti
     */
    public void start(int id, int nrPasi) {
        for (int i = 0; i < nrPasi; i++) {
            for (Client client : clienti) {
                if (client.licitatii.containsKey(id)) {
                    client.send(id);// apelam send din client
                }
            }
            Casa_de_Licitatii.getInstance().send(id, this);
        }
    }


    /**
     * metoda care imi afiseaza informatii despre un broker
     */
    public void printBroker() {
        System.out.println("CNP ul broker-ului este: " +
                this.getCnp() +
                " si are " + clienti.size() +
                " clienti");
    }
}
