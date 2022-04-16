/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseproyecto1.pkg22;

import static baseproyecto1.pkg22.NominaRev.Nominas;
import static baseproyecto1.pkg22.NominaRev.cargarUsers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class conNomina extends javax.swing.JFrame {
archivos a = new archivos();

    public conNomina() {
        initComponents();
         cargarUsers();
    }
    void enviardatosuser(){
        int fila=Nominas.getSelectedRow();
        if(fila>=0){
            
                   new NominaGen(Nominas.getValueAt(fila,0).toString()).setVisible(true);
                   NominaGen.mod.setEnabled(true);
        }
    else{
        JOptionPane.showMessageDialog(null,"Por favor, seleccione una fila");
    }
    }
    
     public void Buscar(String filtro)
        {
            //TABLA
           DefaultTableModel modelo = (DefaultTableModel) Nominas.getModel();
            modelo.getDataVector().clear();
            
            String []reg = new String [10];
            //TABLA
            
            File fAntiguo= new File("nomina.txt");
            String aCadena=filtro;
            // Declaro un nuevo buffer de lectura
            BufferedReader br;
            try
                {
                    if(fAntiguo.exists())
                      {
                        br = new BufferedReader(new FileReader(fAntiguo));

                        String linea;

                        while((linea=br.readLine()) != null)
                          {                            
                              String[] arrOfStr = linea.split(","); 
                                
                            if(arrOfStr[0].equals(aCadena))
                               {                        
                                   reg[0] = arrOfStr[0];
                                   reg[1] = arrOfStr[1];
                                   reg[2] = arrOfStr[2];
                                   reg[3] = arrOfStr[3];
                                   reg[4] = arrOfStr[4];
                                   reg[5] = arrOfStr[5];
                                   reg[6] = arrOfStr[6];
                                   reg[7] = arrOfStr[7];
                                   reg[8] = arrOfStr[8];
                                   reg[9] = arrOfStr[9];
                                   
                                   modelo.addRow(reg);
                                  Nominas.setModel(modelo);
                                   br.close(); 
                                    return;

                               }
                            
                           } // fin while
                        // Cierro el buffer de lectura
                        br.close();
                            modelo.addRow(reg);
                                  Nominas.setModel(modelo);
                    }
                    else
                    {
                        System.out.println("Fichero no Existe");
                    }
                } // fin try
                catch(IOException e)
                    {
                        System.out.println(e);
                    }
        }
     
     public static void cargarUsers()
        {
            //TABLA
           DefaultTableModel modelo = (DefaultTableModel) Nominas.getModel();
            modelo.getDataVector().clear();
            
            String []reg = new String [10];
            //TABLA
            
            File fAntiguo= new File("nomina.txt");
            // Declaro un nuevo buffer de lectura
            BufferedReader br;
            try
                {
                    if(fAntiguo.exists())
                      {
                        br = new BufferedReader(new FileReader(fAntiguo));

                        String linea;

                        while((linea=br.readLine()) != null)
                          {                            
                              String[] arrOfStr = linea.split(","); 
                                
                                   reg[0] = arrOfStr[0];
                                   reg[1] = arrOfStr[1];
                                   reg[2] = arrOfStr[2];  
                                   reg[3] = arrOfStr[3];
                                   reg[4] = arrOfStr[4];
                                   reg[5] = arrOfStr[5];
                                   reg[6] = arrOfStr[6];
                                   reg[7] = arrOfStr[7];
                                   reg[8] = arrOfStr[8];
                                   reg[9] = arrOfStr[9];
                                   modelo.addRow(reg);
                                   Nominas.setModel(modelo);
                           } // fin while
                        // Cierro el buffer de lectura
                        br.close();
                    }
                    else
                    {
                        System.out.println("Fichero no Existe");
                    }
                } // fin try
                catch(IOException e)
                    {
                        System.out.println(e);
                    }
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idfiltrofec = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Nominas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta de Nomina", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        jLabel1.setText("Fecha");

        try {
            idfiltrofec.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("30/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        idfiltrofec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idfiltrofecActionPerformed(evt);
            }
        });
        idfiltrofec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idfiltrofecKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idfiltrofec, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idfiltrofec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Nominas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Nomina", "ID Empleado", "Fecha Nomina", "Sueldo bruto", "AFP", "ARS", "Cooperativa", "ISR", "Sueldo Neto", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Nominas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NominasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Nominas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idfiltrofecKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idfiltrofecKeyReleased
        Buscar(idfiltrofec.getText());
        if(idfiltrofec.getText().isEmpty())
        cargarUsers();
    }//GEN-LAST:event_idfiltrofecKeyReleased

    private void NominasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NominasMouseClicked

    }//GEN-LAST:event_NominasMouseClicked

    private void idfiltrofecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idfiltrofecActionPerformed
         Buscar(idfiltrofec.getText()); 
        if(idfiltrofec.getText().isEmpty())
            cargarUsers();
    }//GEN-LAST:event_idfiltrofecActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(conNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(conNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(conNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(conNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new conNomina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable Nominas;
    private javax.swing.JFormattedTextField idfiltrofec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
