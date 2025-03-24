package sklad;


import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Trieda sluziaca na otvaranie databazy
 * @author Michal
 */
public class OtvaranieDatabazy extends javax.swing.JFrame implements IVypis {
    private IVypis program  ;

    /**
     * Konštruktor
     * @param program
     */
    public OtvaranieDatabazy(IVypis program) {
        this.program = program;
        this.initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metod na nacitanie databazy zo subora 
     * @param nazovSuboru zadany nazov subora ktorý sa ma otvorit
     * @return vrati načitaný sklad
     */
    public Sklad citajZoSuboruTxt(String nazovSuboru) {
        Sklad pomocny = new Sklad();
        Tovar tovar;
        DataInputStream citac = null;
        boolean koniec = false;
        
        try {
            File subor = new File(nazovSuboru);    
            FileInputStream strm = new FileInputStream(subor);     
            citac = new DataInputStream(strm);
            while (!koniec) {
                String nazov =   citac.readUTF();
                double cena = citac.readDouble();
                int pocetKusov = citac.readInt();

                int denPridania = citac.readInt();
                int mesiacPridania = citac.readInt();
                int rokPridania = citac.readInt();
                int denSpotreby = citac.readInt();
                int mesiacSpotreby = citac.readInt();
                int rokSpotreby = citac.readInt();

                Datum datumPridania = new Datum(denPridania, mesiacPridania, rokPridania);
                Datum datumSpotreby = new Datum(denSpotreby, mesiacSpotreby, rokSpotreby);


                tovar = new Tovar(datumSpotreby, datumPridania, nazov, cena, pocetKusov);
                pomocny.pridatTovar(tovar);
          
          
            }
     
        
        
        
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Subor sa nenasiel ", "Chyba", JOptionPane.ERROR_MESSAGE);

        } catch (EOFException ex) {
            koniec = true;
        } catch (IOException ex) {
            Logger.getLogger(OtvaranieDatabazy.class.getName()).log(Level.SEVERE, null, ex);
        } finally {   
            try {
                citac.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "chyba zatvarania ", "Chyba", JOptionPane.ERROR_MESSAGE);

            }
        }
        
        return pomocny;
    
    
    
    }
    
     
    

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        ((Program2)this.program).nastavSklad(this.citajZoSuboruTxt(this.jFileChooser1.getSelectedFile().getAbsolutePath()));
        this.dispose();                           
                                  
        
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables

  
    @Override
    public void vypis() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
