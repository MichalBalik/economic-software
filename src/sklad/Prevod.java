package sklad;

import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

/**
 * Trieda služiaca na prevod cisiel
 * @author Michal
 */
public class Prevod {
    
    
    /**
     * Metoda na parsovanie cisiel
     * @param input zadany string ktory sa ma preparsovat
     * @return preparsovane cislo
     * @throws ParseException
     */
    public static double parseDouble(String input) throws ParseException {
        try {
            DecimalFormat decimal = new DecimalFormat();
            DecimalFormatSymbols symbol = new DecimalFormatSymbols();

            symbol.setDecimalSeparator(',');
            decimal.setDecimalFormatSymbols(symbol);
           
            return decimal.parse(input).doubleValue();
        } catch (ParseException e) {
            try {
                return NumberFormat.getInstance().parse(input).doubleValue();
                
            } catch (ParseException ex) {
                throw ex;
            }
        }
    }
}
