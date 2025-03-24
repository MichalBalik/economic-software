package hrubaMzda;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Potomkova trieda hrubej mzdy
 * @author Michal
 */
public class HodinovaHrubaMzda extends HrubaMzda {
    
    private int pracovnyCas;

    /**
     * Konstruktor triedi hodinovaHrubaMzda
     * @param zakladnaMzda vyska zakl mzdy
     * @param odpracovaneDni pocet odpracovanich
     * @param priznanePremie vyska priznanych premii
     * @param nahradyMzdy vyska nahrady mzdy
     * @param pracovnyCas hodinovy fond dna
     */
    public HodinovaHrubaMzda(BigDecimal zakladnaMzda, int odpracovaneDni, BigDecimal priznanePremie, BigDecimal nahradyMzdy, int pracovnyCas) {
        super(zakladnaMzda, odpracovaneDni, priznanePremie, nahradyMzdy);
        this.pracovnyCas = pracovnyCas;
    }
    
    /**
     * Metoda na vypocet hodinovej hrubej mzdy
     * @return vrati hodnotu hodinovej hrubej mzdy
     */
    public BigDecimal vypocetHodHrubejMzdy () {

        this.hrubaMzda = this.zakladnaMzda.multiply(BigDecimal.valueOf(this.odpracovaneDni), MathContext.DECIMAL64).multiply(BigDecimal.valueOf(this.pracovnyCas), MathContext.DECIMAL64).add(this.priznanePremie).add(this.nahradyMzdy, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_DOWN);
      
        return this.hrubaMzda; 
        
        
        
        
    
    
    
    
    }
}
