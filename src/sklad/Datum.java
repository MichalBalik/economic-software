package sklad;

import java.time.YearMonth;

/**
 * Trieda zastupujuca datum 
 * @author Michal
 */

public class Datum {
    private int den;
    private int mesiac;
    private int rok;

    /**
     * Konstruktor
     * 
     * @param den getDen v roku
     * @param mesiac getMesiac v roku 
     * @param rok dany getRok
     */
    public Datum(int den, int mesiac, int rok) {
        this.den = den;
        this.mesiac = mesiac;
        this.rok = rok;
    }

 
    
    
    /**
     * Metoda sluziaca na overenie datumu
     * @param den
     * @param mesiac
     * @param rok
     * @return ak datum vyhovuje podmienkam true, ak nevyhovuje false
     */
    public boolean overitDatum (int den, int mesiac, int rok) {
       

        return (mesiac >= 1 && mesiac <= 12) && (den >= 1 && den <= maxPocetDniVMesiaci(mesiac, rok));
        

    }

    /**
     * Metoda na vratenie dna
     * @return getDen
     */
    public int getDen() {
        return this.den;
    }

    /**
     * Metoda na vratenie mesiaca
     * @return zadany mesiac
     */
    public int getMesiac() {
        return this.mesiac;
    }

    /**
     * Metoda na vratenie roku
     * @return zadany rok
     */
    public int getRok() {
        return this.rok;
    }

    /**
     * Metoda toString na vratenie datumu vo formate stringu
     * @return
     */
    @Override
    public String toString() {
        return this.den + "." + this.mesiac + "." + this.rok;
    }

    /**
     * Metoda na zistenie priestupneho roka
     * @param rok
     * @return vrati true ak je rok priestupny
     */
    public static boolean jePriestupny(int rok) {
        if (rok % 4 != 0) { 
            return false;
        }
        if ((rok % 100 == 0) && (rok % 400 != 0)) {
            return false;
        }
        return true;
    }

    /**
     * Meotoda na ziskanie poctu dni v roku
     * @param rok overovany rok
     * @return pocet dni v roku
     */
    public static int maxPocetDniVRoku(int rok) {
        if (jePriestupny(rok)) {
            return 366;
            
        
        } else { 
            return 365;
        }
    }

    /**
     * Meotoda na ziskanie poctu dni v mesiaci
     * @param mesiac
     * @param rok
     * @return
     */
    public static int maxPocetDniVMesiaci(int mesiac, int rok) {
        
        YearMonth pocetDniVMesiaci = YearMonth.of(rok, mesiac);
             
        
        return pocetDniVMesiaci.lengthOfMonth();  
      
      
      
    }

   

   
}





