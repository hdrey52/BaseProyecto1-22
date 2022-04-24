
package baseproyecto1.pkg22;

import static baseproyecto1.pkg22.NominaRev.Nominas;
import static baseproyecto1.pkg22.NominaRev.cargarUsers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NominaRevr extends javax.swing.JFrame {
    int entrada = 2;
    static DecimalFormat decimalFormat = new DecimalFormat("#.##");
    archivos a = new archivos();

    public NominaRevr() {
        initComponents();
        cargarUsers();
        btn1.setSelected(true);
        revertir.setEnabled(false);
        options();
    }
    
    public NominaRevr(int y){
        initComponents();
        
        cargarUsers();
        btn1.setSelected(true);
        options();
        entrada = y;
    }
    
void options(){
    cargarUsers();
     limpiar();
     
      if(btn1.isSelected())
               idfiltro.setEnabled(true);
           else
               idfiltro.setEnabled(false);
      if(btn2.isSelected())
               fecha.setEnabled(true);
               //revertir.setEnabled(true);
           else
               fecha.setEnabled(false);
               //revertir.setEnabled(false);
      if(btn2.isSelected())
               revertir.setEnabled(true);
           else
               revertir.setEnabled(false);
}
void limpiar(){

       idfiltro.setText("");
       fecha.setText("");
    
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
  
        void deleteDir(File file) {
          File[] contents = file.listFiles();
          if (contents != null) {
              for (File f : contents) {
                  deleteDir(f);
              }
          }
          file.delete();
      }
 
        public void cargarUsers(){
    //TABLA
           DefaultTableModel modelo = (DefaultTableModel) nominas.getModel();
            modelo.getDataVector().clear();
            
            String []reg = new String [10];
            //TABLA
            
            File fAntiguo = new File("nomina.txt");
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
                                   reg[4] = decimalFormat.format(Double.valueOf(arrOfStr[4]));
                                   reg[5] = decimalFormat.format(Double.valueOf(arrOfStr[5]));
                                   reg[6] = decimalFormat.format(Double.valueOf(arrOfStr[6]));
                                   reg[7] = decimalFormat.format(Double.valueOf(arrOfStr[7]));
                                   reg[8] = decimalFormat.format(Double.valueOf(arrOfStr[8]));
                                   reg[9] = arrOfStr[9];
                                   
                                   modelo.addRow(reg);
                                  nominas.setModel(modelo);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        nominas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        idfiltro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn1 = new javax.swing.JRadioButton();
        btn2 = new javax.swing.JRadioButton();
        fecha = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        revertir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nominas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID Empleado", "Fecha Nomina", "Sueldo Bruto", "AFP", "ARS", "Cooperativa", "ISR", "Sueldo Neto", "Estado"
            }
        ));
        nominas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nominasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(nominas);

        jLabel1.setText("Id Empleado");

        idfiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idfiltroActionPerformed(evt);
            }
        });
        idfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idfiltroKeyReleased(evt);
            }
        });

        jLabel2.setText("Fecha");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones del Filtro"));

        buttonGroup1.add(btn1);
        btn1.setText("ID Empleado");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(btn2);
        btn2.setText("Fecha Nomina");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn2)
                    .addComponent(btn1))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btn1)
                .addGap(18, 18, 18)
                .addComponent(btn2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        try {
            fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("30/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fechaKeyReleased(evt);
            }
        });

        jButton1.setText("Cambiar Estado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        revertir.setText("Revertir");
        revertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revertirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idfiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(fecha))
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(revertir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton1)
                        .addGap(23, 23, 23)
                        .addComponent(revertir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nominasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nominasMouseClicked

    }//GEN-LAST:event_nominasMouseClicked

    private void idfiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idfiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idfiltroActionPerformed

    private void idfiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idfiltroKeyReleased
        Buscar(idfiltro.getText(),"idemp");
        if(idfiltro.getText().isEmpty())
        cargarUsers();
    }//GEN-LAST:event_idfiltroKeyReleased

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        options();
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        options();
    }//GEN-LAST:event_btn2ActionPerformed

    private void fechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaKeyReleased
     Buscar(fecha.getText(),"fec");
        if(fecha.getText().isEmpty())
        cargarUsers();
    }//GEN-LAST:event_fechaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            
             
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void revertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revertirActionPerformed
            String ant = "0";
            String fechas= "";
        try {
            // TODO add your handling code here:
            String fecharevertir = fecha.getText();
 
            
            File fAntiguo = new File("nomina.txt");
            BufferedReader brt;
            
            brt = new BufferedReader(new FileReader(fAntiguo));
            String [] arrOfStr;
            
            String linea;
            while ((linea = brt.readLine()) != null) {
                arrOfStr = linea.split(",");
                
                if (arrOfStr[2].equals(fecharevertir)) {
                    
                      
                        ant = arrOfStr[0];
                        fechas = arrOfStr[2];
                }
                
            }
            

            
            brt.close();
        } catch (IOException ex) {
            Logger.getLogger(NominaRevr.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(ant.equals("0")){
        JOptionPane.showMessageDialog(fecha, "Fecha inexistente!", "Advertencia",
                JOptionPane.WARNING_MESSAGE);
        }else{
            String [] fecha_limpia;
            
                fecha_limpia = fechas.split("/");
                String mesyano = null;
                switch (fecha_limpia[1]) {

                    case "01":
                      mesyano = "Enero";
                      break;

                    case "02":
                      mesyano = "Febrero";
                      break;
                
                    case "03":
                      mesyano = "Marzo";
                      break;
                
                    case "04":
                      mesyano = "Abril";
                      break;
                
                    case "05":
                      mesyano = "Mayo";// code
                      break;
                
                    case "06":
                      mesyano = "Junio";// code
                      break;
                
                    case "07":
                      mesyano = "Julio";// code
                      break;
                
                    case "08":
                      mesyano = "Agosto";
                      break;
                
                    case "09":
                      mesyano = "Septiembre";
                      break;
                
                    case "10":
                      mesyano = "Octubre";
                      break;
                
                    case "11":
                      mesyano = "Noviembre";
                      break;
                
                    case "12":
                      mesyano = "Diciembre";
                      break;
                }
                      
                      mesyano= mesyano+"_"+fecha_limpia[2];
                      
            String filepath = "Nominas_"+mesyano+"";
            File file = new File(filepath);
            deleteDir(file);
            a.Borracho("nomina", ant, "");
            
            JOptionPane.showMessageDialog(rootPane, "Nomina reversada exitosamente!");
            
        }
            cargarUsers();

    }//GEN-LAST:event_revertirActionPerformed

    
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
            java.util.logging.Logger.getLogger(NominaRevr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NominaRevr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NominaRevr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NominaRevr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NominaRevr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btn1;
    private javax.swing.JRadioButton btn2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField fecha;
    private javax.swing.JTextField idfiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable nominas;
    private javax.swing.JButton revertir;
    // End of variables declaration//GEN-END:variables
}
