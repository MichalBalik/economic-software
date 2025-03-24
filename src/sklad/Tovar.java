package sklad;

/**
 * Trieda reprezentujuca tovar
 * @author Michal
 */
public class Tovar {
    private Datum datumSpotreby;
    private Datum datumPridania;
    private String nazovTovaru;
    private double cenaTovaru;
    private int pocetTovaru;

    /**
     * Konštruktor
     * @param datumSpotreby
     * @param datumPridania
     * @param nazovTovaru
     * @param cenaTovaru
     * @param pocetKusov
     */
    public Tovar(Datum datumSpotreby, Datum datumPridania, String nazovTovaru, double cenaTovaru, int pocetKusov) {
        this.datumSpotreby = datumSpotreby;
        this.datumPridania = datumPridania;
        this.nazovTovaru = nazovTovaru;
        this.cenaTovaru = cenaTovaru;
        this.pocetTovaru = pocetKusov;
    }

    /**
     * Metoda na vratenie nazvu tovaru
     * @return
     */
    public String nazovTovaru() {
        return this.nazovTovaru;
    }

    /**
     * Metoda na vratenie ceny tovaru
     * @return vrati cenu tovaru
     */
    public double cenaTovaru() {
        return this.cenaTovaru;
    }

    /**
     * Metoda na vratenie datumu pridania
     * @return datum pridania
     */
    public Datum datumPridania() {
        return this.datumPridania;
    }

    /**
     * Metoda na porovnanie tovarov
     * @param tovar tovar ktory sa bude porovnavat
     * @return porovnanie tovarov
     */
    public int porovnajMena(Tovar tovar) {
         
        return this.nazovTovaru.compareTo(tovar.nazovTovaru);
    
    
    }
    
    /**
     * Metoda na vratenie datumu spotreby
     * @return datum spotreby
     */
    public Datum datumSpotreby() {
        return this.datumSpotreby;
    }

    /**
     * Metoda na vratenie poctu kusov
     * @return pocet kusov tovaru
     */
    public int pocetKusov() {
        return this.pocetTovaru;
    }

    /**
     * Metoda na odobratie tovaru
     * @param pomPocetKusov pocet o ktory sa ma tovar znizit
     */
    public void odoberTovar(int pomPocetKusov) {
        this.pocetTovaru -= pomPocetKusov;
    }

    /**
     * Metoda na pridatie tovaru do skladu
     * @param pomPocetKusov  pocet o ktory sa ma tovar zvysit
     */
    public void prijemTovar(int pomPocetKusov) {
        this.pocetTovaru += pomPocetKusov;
    }

    /**
     * Metoda to string
     * @return vraci string metodu tovaru
     */
    @Override
    public String toString() {
        String pomocny = "Nazov tovaru : " + this.nazovTovaru + "\n" +
                     "Datum pridania tovaru : " + this.datumPridania + "\n" +
                     "Cena Tovaru : " + this.cenaTovaru + "\n" +
                     "Pocet Kusov : " + this.pocetTovaru + "\n" +
                     "Datum spotreby tovaru : " + this.datumSpotreby + "\n\n";
        return pomocny;
    }
}


