package sklad;


import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Trieda na ukladanie 
 * @author Michal
 */
public class UkladanieDatabazy extends javax.swing.JFrame {
    private Sklad sklad ;
        
    /**
     * skladonstruktor
     * @param sklad
     */
    public UkladanieDatabazy(Sklad sklad) {
        
        this.initComponents();
        this.jFileChooser1.setDialogType(JFileChooser.SAVE_DIALOG);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.sklad = sklad;
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        this.ulozDoSuboruTxt(this.jFileChooser1.getSelectedFile().getAbsolutePath(), this.sklad);  
             
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.dispose();    
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    /**
     * Metoda ktora uklada tovar do suboru
     * @param nazovSuboru nazov pod ktorym bude subor ulozeny
     * @param sklad
     */
    public void ulozDoSuboruTxt(String nazovSuboru, Sklad sklad) {
       
        
       
        
        DataOutputStream zapisovac = null ;

        try {
            
            File subor = new File(nazovSuboru);
            FileOutputStream stream = new FileOutputStream(subor);
            zapisovac = new DataOutputStream(stream);
             

            for (int j = 0; j < sklad.getPocetTovarov(); j++) {
                
                zapisovac.writeUTF(sklad.vratTovar(j).nazovTovaru());
                zapisovac.writeDouble(sklad.vratTovar(j).cenaTovaru());
                zapisovac.writeInt(sklad.vratTovar(j).pocetKusov());
                zapisovac.writeInt(sklad.vratTovar(j).datumPridania().getDen());
                zapisovac.writeInt(sklad.vratTovar(j).datumPridania().getMesiac());
                zapisovac.writeInt(sklad.vratTovar(j).datumPridania().getRok());
                zapisovac.writeInt(sklad.vratTovar(j).datumSpotreby().getDen());
                zapisovac.writeInt(sklad.vratTovar(j).datumSpotreby().getMesiac());
                zapisovac.writeInt(sklad.vratTovar(j).datumSpotreby().getRok());   
                
                
                
                
            }
            zapisovac.close();
            
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Subor sa nenasiel ", "Chyba", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Chyba ", "Chyba", JOptionPane.ERROR_MESSAGE);
        }
  
        
       
 
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables

}
