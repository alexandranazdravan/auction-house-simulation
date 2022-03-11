/**
 * Design Pattern-ul Factory aplicat pe Produs
 */
public class ProdusFactory {
    /**
     * @param type daca este Mobila, Tablou sau Bijuterie
     * @param st string-ul din care imi iau valorile ca se creez produsul
     * @return produsul creat, indiferent de ce tip e
     */
    public Produs getProdus(String type, String[] st) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("Mobila")) {
            return new Mobila(Integer.parseInt(st[0]),
                    st[1],
                    Double.parseDouble(st[2]),
                    Integer.parseInt(st[3]),
                    st[5],
                    st[6]
            );

        } else if (type.equalsIgnoreCase("Tablou")) {
            if (st[6].equals("tempera")) {
                return new Tablou(Integer.parseInt(st[0]),
                        st[1],
                        Double.parseDouble(st[2]),
                        Integer.parseInt(st[3]),
                        st[5],
                        Culori.tempera
                );
            }
            if (st[6].equals("acrilic")) {
                return new Tablou(Integer.parseInt(st[0]),
                        st[1],
                        Double.parseDouble(st[2]),
                        Integer.parseInt(st[3]),
                        st[5], Culori.acrilic
                );
            }
            if (st[6].equals("ulei")) {
                return new Tablou(Integer.parseInt(st[0]),
                        st[1],
                        Double.parseDouble(st[2]),
                        Integer.parseInt(st[3]),
                        st[5],
                        Culori.ulei
                );
            }

        } else if (type.equalsIgnoreCase("Bijuterie")) {
            if (st[6].equals("da")) {
                return new Bijuterie(Integer.parseInt(st[0]),
                        st[1],
                        Double.parseDouble(st[2]),
                        Integer.parseInt(st[3]),
                        st[5],
                        true
                );
            }
            if (st[6].equals("nu")) {
                return new Bijuterie(Integer.parseInt(st[0]),
                        st[1],
                        Double.parseDouble(st[2]),
                        Integer.parseInt(st[3]),
                        st[5],
                        false);
            }
        }
        return null;
    }
}
