package sklad;


import java.util.ArrayList;

/**
 * Trieda ukladajúca databazu tovarov
 * @author Michal
 */
public class Sklad {
    private ArrayList<Tovar> zoznamTovarov;

    /**
     * Konštruktor
     */
    public Sklad() {
        this.zoznamTovarov = new ArrayList<Tovar>();
        
    }

    /**
     * Metoda na pridanie tovaru do skladu
     * @param tovar tovar ktory sa ma pridat do skladu
     */
    public void pridatTovar(Tovar tovar) {
        this.zoznamTovarov.add(tovar);

    }
    
    
    
    private void vymenPrvky (int indexA, int indexB) {
        Tovar tovar = this.zoznamTovarov.get(indexA);
        this.zoznamTovarov.set(indexA, this.zoznamTovarov.get(indexB));
        this.zoznamTovarov.set(indexB, tovar);
    
    }
    
    public void zoradenieMenoVzostupne() {
        Tovar min ;
        int minIndex;
        
        for (int i = 0; i < this.zoznamTovarov.size(); i++) {
            min = this.zoznamTovarov.get(i);
            minIndex = i;
        
            for (int j = i + 1; j < this.zoznamTovarov.size(); j++) {
                if ( min.porovnajMena(this.zoznamTovarov.get(j)) > 00) {
                    min = this.zoznamTovarov.get(j);
                    minIndex = j; 
                }
            }
            this.vymenPrvky(i, minIndex) ;
        } 
    
    }

    /**
     * Metoda na zistenie poctu druhov tovaru
     * @return pocet druhov tovaru
     */
    public int getPocetTovarov() {
        return this.zoznamTovarov.size();
        
    }

    /**
     * Metoda na vycistenie zoznamu tovarov
     */
    public void vycistenieZoznamu() {
        this.zoznamTovarov.removeAll(this.zoznamTovarov); 
        
    }

    /**
     * Metoda na vymenu tovarov v arrayliste
     * @param pomTovar tovar ktory sa ma presunut
     * @param index index miesta kde sa to ma posunut
     */
    public void vymenaTovarov(Tovar pomTovar, int index) {
        this.zoznamTovarov.set(index, pomTovar);
          
    }

    /**
     * Metoda na vymazanie tovaru podla poradia
     * @param index index predstavujuci poradie v zozname
     */
    public void vymazanieTovaru(int index) {
        this.zoznamTovarov.remove(index);
    }
    
    /**
     * Metoda na vypocet celkovej hodnoty za jeden tovar
     * @param index pozicia na ktorej je tovar
     * @return celkova hodnota za tovar
     */
    public double celkovaHodnotaTovaru(int index) {
        
        return   this.zoznamTovarov.get(index).pocetKusov() * this.zoznamTovarov.get(index).cenaTovaru();
    }
 
    /**
     * Metoda na vratenie tovaru podla indexu
     * @param index index na ktorom sa nachadza tovar
     * @return vrati tovar podla indexu
     */
    public Tovar vratTovar(int index) {
        return this.zoznamTovarov.get(index);
    }
     
    /**
     * Metoda na zistenie ci je zoznam prazdny
     * @return vrati true ak je zoznam prazdny
     */
    public boolean jeZoznamPrazdny () {
       
        return this.zoznamTovarov.isEmpty();
     
    }
     
    /**
     * Metoda na vyhladanie tovaru podla nazvu
     * @param nazovTovaru nazov tovaru podla ktoreho sa bude tovar vyhladavat
     * @return vrati index tovaru ak sa tovar najde
     */
    public int vyhladajTovar(String nazovTovaru) {
        if (this.jeZoznamPrazdny()) {
            return -1;
        }
        
        for (int j = 0; j < this.getPocetTovarov(); j++) {
            String prehladavany = this.zoznamTovarov.get(j).nazovTovaru();
            if (prehladavany.equalsIgnoreCase(nazovTovaru)) {
                return j;
            }
        }
        
        return -1;
    }

    /**
     * Metoda na vyhladanie tovarov podla datumu
     * @param pomDen den 
     * @param pomMesiac mesiac
     * @param pomRok rok
     * @return vrati zoznam tovarov vyhovujucich datumu
     */
    public ArrayList<Tovar> vyhladajTovar(int pomDen, int pomMesiac, int pomRok) {
        ArrayList<Tovar> zoznamHladanych = new ArrayList<Tovar>();
        
        for (int i = 0; i < this.getPocetTovarov(); i++) {
            Datum datum = this.zoznamTovarov.get(i).datumPridania();
            if ((datum.getDen() == pomDen) && (datum.getMesiac() == pomMesiac) && (datum.getRok() == pomRok)) {
                zoznamHladanych.add(this.zoznamTovarov.get(i));
                    
            }
        }
            
        return zoznamHladanych;
    }

    /**
     * Metoda na vyhladanie tovaru medzi dvomi cenami
     * @param minimalnaCena  minimalna cena
     * @param maximalnaCena  maximalna cena
     * @return vrati zoznam tovarov ktore su v rozmedzi dvoch cien
     */
    public ArrayList<Tovar> vyhladajTovar(double minimalnaCena, double maximalnaCena) {
        
        ArrayList<Tovar> tovary = new ArrayList<Tovar>();
        
        for (Tovar tovar : this.zoznamTovarov) {
            if (tovar.cenaTovaru() >= minimalnaCena && maximalnaCena >= tovar.cenaTovaru()) {
                tovary.add(tovar);
            }
        }
        return tovary;
        
        
   
    }

    /**
     * Metoda na vratenie celkoveho poctu tovarov na sklade
     * @return pocet vsetkych tovarov dokopi
     */
    public int celkovyPocetTovarov() {
        int pocet = 0;
        for (Tovar tovar : this.zoznamTovarov) {
            pocet += tovar.pocetKusov();
        }
        return pocet;
        
       
    }

    /**
     * Metoda na vratenie celkovej hodnoty majetku
     * @return celkovu hodnotu majetku
     */
    public double celkovaHodnotaObeznehoMajetku() {
        double obeznyMajetok = 0;
        for (int l = 0; l < this.getPocetTovarov();l++) {
            obeznyMajetok += this.celkovaHodnotaTovaru(l);
        }
        return obeznyMajetok;
    }

   
    
    
   

  
    

    /**
     * Metoda toString
     * @return  vracia string s udajmi
     */
    @Override
    public String toString() {
   
        
        String pom = "Pocet tovarov v sklade : " + this.zoznamTovarov.size() + "\n";

        int kusy = 0;
        for (int j = 0; j < this.zoznamTovarov.size(); j++) {
            kusy = kusy + this.zoznamTovarov.get(j).pocetKusov();
        }
        pom += "Pocet vsetkych kusov tovarov v sklade : " + kusy + "\n";

        double vysledok = 0;
        for (int i = 0; i < this.zoznamTovarov.size(); i++) {
            vysledok += this.celkovaHodnotaTovaru(i);
        }
        pom += "Cena vsetkych kusov tovarov v sklade : " + vysledok + "\n\n";

        if (this.zoznamTovarov.isEmpty()) {  
            return pom;
        }
        for (int i = 0; i < this.zoznamTovarov.size() ; i++) {
            pom += (i + 1) + ". \n" + this.zoznamTovarov.get(i);
        }
        return pom;
    }
}





























