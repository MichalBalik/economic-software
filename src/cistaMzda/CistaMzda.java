package cistaMzda;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Trieda na vypocet cistej mzdy
 * @author Michal
 */
public class CistaMzda {
    
    
    private BigDecimal hrubaMzda;
    private  BigDecimal zp ;
    private BigDecimal nP;
    private BigDecimal sP;
    private BigDecimal iP;
    private BigDecimal pvN;
    private BigDecimal predavokDan;
    private BigDecimal kVyplate;
    private BigDecimal neuplatnenyDB;
    private boolean nezdanitelnaCast; 
    private int dB;
    private double predavok;
    private double dpn;
    private double ostatneZrazky;
    
    
    /**
     * Konstruktor
     * @param pomHrubaMzda
     * @param nezdanitelnaCast
     * @param dB
     * @param dpn
     * @param ostatneZrazky
     * @param predavok
     * 
     */
    public CistaMzda(double pomHrubaMzda, boolean nezdanitelnaCast, int dB, double dpn, double ostatneZrazky, double predavok) {
        this.hrubaMzda = BigDecimal.valueOf(pomHrubaMzda);
        this.nezdanitelnaCast = nezdanitelnaCast; 
       
        this.dB = dB;   
        this.predavok = predavok;
        this.dpn = dpn;
        this.ostatneZrazky = ostatneZrazky;
    }
    
    /**
     * Metoda na vypocet cisteje mzdy
     * @return hodnota cistej mzdy
     */
    public BigDecimal vypocetCistejMzdy () {
            
        this.zp = this.hrubaMzda.multiply(BigDecimal.valueOf(0.04)).setScale(2, RoundingMode.DOWN);
        this.nP = this.hrubaMzda.multiply(BigDecimal.valueOf(0.014)).setScale(2, RoundingMode.DOWN);
        this.sP = this.hrubaMzda.multiply(BigDecimal.valueOf(0.04)).setScale(2, RoundingMode.DOWN);
        this.iP = this.hrubaMzda.multiply(BigDecimal.valueOf(0.03)).setScale(2, RoundingMode.DOWN);
        this.pvN = this.hrubaMzda.multiply(BigDecimal.valueOf(0.01)).setScale(2, RoundingMode.DOWN);
       
       
       
       
        BigDecimal czd = this.hrubaMzda.subtract(this.zp).subtract(this.nP).subtract(this.sP).subtract(this.iP).subtract(this.pvN).setScale(2, RoundingMode.DOWN);
        BigDecimal zakladDane = czd;
       
        
        
        if (this.nezdanitelnaCast ) {
            zakladDane = czd.subtract(BigDecimal.valueOf(316.94));
        }
        
        this.predavokDan = zakladDane.multiply(BigDecimal.valueOf(0.19)).setScale(2, RoundingMode.DOWN);
        
        
        
        if (this.dB > 0  ) {
            this.predavokDan = this.predavokDan.subtract(BigDecimal.valueOf(this.dB * 21.41));
        } 
   
    
        
        
         
        
        this.kVyplate = this.hrubaMzda.subtract(this.zp).subtract(this.nP).subtract(this.sP).subtract(this.iP).subtract(this.pvN).subtract(this.predavokDan).add(BigDecimal.valueOf(this.dpn))
                            .subtract(BigDecimal.valueOf(this.ostatneZrazky)).subtract(BigDecimal.valueOf(this.predavok));
        System.out.println(this.kVyplate);
         
                     

        return this.kVyplate;
        
        
        
        
   
                

        
    }

    @Override
    public String toString() {
        return   "hrubaMzda=" + this.hrubaMzda +  "\n" 
                + "--------------------------" +  "\n" 
                + "zp=" + this.zp +  "\n" +
                "nP=" + this.nP +  "\n" +
                
                 "sP=" + this.sP + "\n" + 
                "iP=" + this.iP + "\n" +
                "pvN=" + this.pvN + "\n" + 
                 "--------------------------" +  "\n" +
                "predavok za dan = " + this.predavokDan + "\n" +
                
                
                
                "danovy bonus na = " + this.dB + " deti" + "\n" + 
                "predavok na mzdu=" + this.predavok + "\n" + 
                "dpn=" + this.dpn + "\n" +
                "ostatneZrazky=" + this.ostatneZrazky + "\n" + 
                 "--------------------------" +  "\n" 
                + "kVyplate=" + this.kVyplate + "\n" + 
                 "--------------------------" +  "\n" ;
    }
    
    
    
    



}
