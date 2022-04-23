/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseproyecto1.pkg22;

import static baseproyecto1.pkg22.conNominas.decimalFormat;
import static baseproyecto1.pkg22.conNominas.nominas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NominaRev extends javax.swing.JFrame {
    archivos a = new archivos();
    archivos metodos = new archivos();
    static DecimalFormat decimalFormat = new DecimalFormat("#.##");

    /**
     * Creates new form NominaRev
     */
    public NominaRev() {
        initComponents();
        cargarUsers();
    }
    
    
     public void Buscar(String filtro, String id){
      //TABLA
           DefaultTableModel modelo = (DefaultTableModel) nominas.getModel();
            modelo.getDataVector().clear();
            
            String []reg = new String [10];
            //TABLA
            
            File fAntiguo= new File("nomina.txt");
            String aCadena=filtro;
            // Declaro un nuevo buffer de lectura
            BufferedReader br;
            
            int i = 0;
            if(id.equals("idemp"))
                i = 1;
            else if(id.equals("fec"))
                i = 2;
            try
                {
                    if(fAntiguo.exists())
                      {
                        br = new BufferedReader(new FileReader(fAntiguo));

                        String linea;

                        while((linea=br.readLine()) != null)
                          {                            
                              String[] arrOfStr = linea.split(","); 
                           
                            if(arrOfStr[i].contains(aCadena))
                               {           
                                   reg[0] = arrOfStr[0];
                                   reg[1] = arrOfStr[1];
                                   reg[2] = arrOfStr[2];
                                   reg[3] = arrOfStr[3];
                                   reg[4] = decimalFormat.format(Double.valueOf(arrOfStr[4]));
                                   reg[5] = decimalFormat.format(Double.valueOf(arrOfStr[5]));
                                   reg[6] = decimalFormat.format(Double.valueOf(arrOfStr[6]));
                                   reg[7] = decimalFormat.format(Double.valueOf(arrOfStr[7]));
                                   reg[8] = decimalFormat.format(Double.valueOf(arrOfStr[8]));
                                   reg[9] = arrOfStr[9];
                                   
                                   modelo.addRow(reg);
                                  nominas.setModel(modelo);
                                   //br.close(); 
                                    //return;

                               }
                            
                           } // fin while
                        // Cierro el buffer de lectura
                        br.close();
                           // modelo.addRow(reg);
                              //    productos.setModel(modelo);
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
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idfiltro = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Nominas = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reversar Nomina", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        jLabel1.setText("Fecha");

        try {
            idfiltro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("30/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        idfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idfiltroKeyReleased(evt);
            }
        });

        jButton1.setText("Revertir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Nominas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NominasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Nominas);

        jButton2.setText("Cambiar Estado");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idfiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idfiltroKeyReleased
     Buscar(idfiltro.getText(), "fec"); 
        if(idfiltro.getText().isEmpty())
            cargarUsers();
    }//GEN-LAST:event_idfiltroKeyReleased

    private void NominasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NominasMouseClicked
    }//GEN-LAST:event_NominasMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            
             
        int fila=Nominas.getSelectedRow();
        if(fila>=0 && fila <=Nominas.getRowCount()){
            
        String Idnom =Nominas.getValueAt(fila,0).toString();
        String Idemp =Nominas.getValueAt(fila,1).toString();
        String fecn =Nominas.getValueAt(fila,2).toString();
        String sueldobruto =Nominas.getValueAt(fila,3).toString();
        String afp =Nominas.getValueAt(fila,4).toString();
        String ars =Nominas.getValueAt(fila,5).toString();
        String coop =Nominas.getValueAt(fila,6).toString();
        String isr =Nominas.getValueAt(fila,7).toString();
        String sueldon =Nominas.getValueAt(fila,8).toString();
        String Estado =Nominas.getValueAt(fila,9).toString();
        
        Estado = "false".equals(Estado) ? "true" : "true".equals(Estado) ? "false" : "true";
        
        String lineaNueva = Idnom+","+Idemp+","+fecn+","+sueldobruto+","+afp+","
                +ars+","+coop+","+isr+","+sueldon+","+Estado;

        a.Modificar("nomina", Idnom, lineaNueva);

        cargarUsers();
        JOptionPane.showMessageDialog(this, "Estado modificado!", "Información",
            JOptionPane.INFORMATION_MESSAGE);
        }
    else{
        JOptionPane.showMessageDialog(null,"Por favor, seleccione una fila");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(NominaRev.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NominaRev.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NominaRev.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NominaRev.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NominaRev().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable Nominas;
    private javax.swing.JFormattedTextField idfiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
