/**
 * Angajatii, indiferent daca sunt brokers sau admin, sunt unici prin cnp
 */
public class Angajat{
    /**
     * anagajtii se diferentiaza prin CNP
     */
   private String cnp;

    /**
     * @param cnp = cnp-ul angajatului creat
     * constructor cu parametru
     */
    public Angajat(String cnp) {
        this.cnp = cnp;
    }

    /**
     * getter pentru cnp-ul angajatului
     * @return cnp-ul angajatului
     */
    public String getCnp() {
        return cnp;
    }
}
