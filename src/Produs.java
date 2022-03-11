/**
 * produsul, care poate fi de 3 tipuri
 */
abstract class Produs {
    /**
     * id-ul produsului
     */
    int id;
    /**
     * numele produsului
     */
    String nume;
    /**
     * pretul cu care s-a vandut
     */
    double pretVanzare;
    /**
     * pretul minim cu care trebuie sa se vanda
     */
    double pretMinim;
    /**
     * anul fabricatiei
     */
    int an;


    /**
     * Constructor cu parametri
     * @param id - ul produsului
     * @param nume -le produsului
     * @param pretMinim cu care trebuie vandut produsul
     * @param an - anul in care s-a fabricat
     */
    public Produs(int id, String nume, double pretMinim, int an) {
        this.id = id;
        this.nume = nume;
        this.pretMinim = pretMinim;
        this.an = an;
    }

    /**
     * getter pentru id
     * @return returneaza id-ul produsului
     */
    public int getId() {
        return id;
    }

    /**
     * @param id - seteaza id-ul produsului cu id-ul primti ca parametru
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter pentru nume
     * @return returneaza numele produsului
     */
    public String getNume() {
        return nume;
    }

    /**
     * getter pentru pretul cu care s-a vandut
     * @return returneaza pretul cu care s-a vandut produsul
     */
    public double getPretVanzare() {
        return pretVanzare;
    }

    /**
     * setter pentru pretul cu care s-a vandut un produs
     * @param pretVanzare - pretul cu care s-a vandut un produs in urma unei licitatii
     */
    public void setPretVanzare(double pretVanzare) {
        this.pretVanzare = pretVanzare;
    }

    /**
     * getter pentru pretul minim cu care urmeaza sa se vanda, eventual
     * @return pretul minim al produsului
     */
    public double getPretMinim() {
        return pretMinim;
    }


    /**
     * getter pentru anul fabricatiei
     * @return anul fabricatiei pt un anumit produs
     */
    public int getAn() {
        return an;
    }

}
