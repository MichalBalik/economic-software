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
public class MesacnaHrubaMzda extends HrubaMzda {
    
    private int kalendarnyFond;
    
    /**
     * Konstruktor MesacnaHrubaMzda
     * @param zakladnaMzda
     * @param odpracovaneDni
     * @param priznanePremie
     * @param nahradyMzdy
     * @param kalendarnyFond
     */
    public MesacnaHrubaMzda(BigDecimal zakladnaMzda, int odpracovaneDni, BigDecimal priznanePremie, BigDecimal nahradyMzdy, int kalendarnyFond) {
        super(zakladnaMzda, odpracovaneDni, priznanePremie, nahradyMzdy);
        this.kalendarnyFond = kalendarnyFond;
        
    }
    
    /**
     * Metoda na vypocet mesacnej hrubej mzdy
     * @return  vysku mesacnej hrubej mzdy
     */
    public BigDecimal vypocetMesHrubejMzdy () {
       
        
        this.hrubaMzda = zakladnaMzda.divide(BigDecimal.valueOf(this.kalendarnyFond), MathContext.DECIMAL64).multiply(BigDecimal.valueOf(odpracovaneDni), MathContext.DECIMAL64).add(priznanePremie).add(nahradyMzdy, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_DOWN) ;
        return this.hrubaMzda; 
        
        
        
        
    
    
    
    
    }
    

    
    
    
}
