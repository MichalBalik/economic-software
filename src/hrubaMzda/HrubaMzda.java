package hrubaMzda;


import java.math.BigDecimal;



/**
 * Predkova trieda hruba mzda
 * @author Michal
 */
public class HrubaMzda {
    
    
    protected BigDecimal zakladnaMzda;
    protected int odpracovaneDni;
    protected BigDecimal priznanePremie;
    protected BigDecimal nahradyMzdy;
    protected BigDecimal hrubaMzda;
    
    /**
     * Kostruktor triedy hruba mzda
     * @param zakladnaMzda vyska zakladnej mzdy
     * @param odpracovaneDni pocet odpracovanych dni
     * @param priznanePremie vyska priznanich premii
     * @param nahradyMzdy vyska nahrady miezd
     */
    public HrubaMzda(BigDecimal zakladnaMzda, int odpracovaneDni, BigDecimal priznanePremie, BigDecimal nahradyMzdy) {
        this.zakladnaMzda = zakladnaMzda;
        this.odpracovaneDni = odpracovaneDni;
        this.priznanePremie = priznanePremie;
        this.nahradyMzdy = nahradyMzdy;
    }

    /**
     * Metoda na nastavenie zakladnej mzdy
     * @param zakladnaMzda
     */
    public void setZakladnaMzda(BigDecimal zakladnaMzda) {
        this.zakladnaMzda = zakladnaMzda;
    }

    /**
     * Metoda na nastavenie odpracovaných dni
     * @param odpracovaneDni
     */
    public void setOdpracovaneDni(int odpracovaneDni) {
        this.odpracovaneDni = odpracovaneDni;
    }

    /**
     * Metoda na nastavenie priznaných premii
     * @param priznanePremie
     */
    public void setPriznanePremie(BigDecimal priznanePremie) {
        this.priznanePremie = priznanePremie;
    }

    /**
     * Metoda na nastavenie nahdrady mzdy
     * @param nahradyMzdy
     */
    public void setNahradyMzdy(BigDecimal nahradyMzdy) {
        this.nahradyMzdy = nahradyMzdy;
    }
    
    /**
     * Metoda na ziskanie zakladnej mzdy
     * 
     * @return BigDecimal zakladnaMzda
     */
    public BigDecimal getZakladnaMzda() {
        return this.zakladnaMzda;
    }

    /**
     * Metoda na ziskanie odpracovaních dni
     * @return int odpracovanDni
     */
    public int getOdpracovaneDni() {
        return this.odpracovaneDni;
    }

    /**
     * Metoda na ziskanie priznanich premii
     * @return BigDecimal priznanePremie
     */
    public BigDecimal getPriznanePremie() {
        return this.priznanePremie;
    }

    /**
     * Metoda na ziskanie nahrady mzdy
     * @return BigDecimal nahradyMzdy
     */
    public BigDecimal getNahradyMzdy() {
        return this.nahradyMzdy;
    }
    
    
}
    
    
    
    
    
    
    
