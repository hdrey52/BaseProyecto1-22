/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseproyecto1.pkg22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ramon Dominguez
 */
public class conPuestos extends javax.swing.JFrame {
int entrada = 2;
    /**
     * Creates new form conPuestos
     */
    public conPuestos() {
        initComponents();
        cargarPtos();
    }
    
     public conPuestos(int y){
        initComponents(); 
        cargarPtos(); 
        entrada = y;
    }
void enviardatospto(){
        int fila=Puestos.getSelectedRow();
        if(fila>=0){
         if(entrada == 0){
                    Empleado.idpto.setText(Puestos.getValueAt(fila,0).toString());
                    
                   this.dispose();
            }
         else if ( entrada == 2) {
             new Puesto(Puestos.getValueAt(fila,0).toString()).setVisible(true);
                   this.dispose();
                   Puesto.btn_Guardar.setEnabled(false);
             }
    }
    else{
        JOptionPane.showMessageDialog(null,"Por favor, seleccione una fila");
    }
        
    }
        public void Buscar(String filtro)
        {
            //TABLA
           DefaultTableModel modelo = (DefaultTableModel) Puestos.getModel();
            modelo.getDataVector().clear();
            
            String []reg = new String [7];
            //TABLA
            
            File fAntiguo= new File("puestos.txt");
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
                                   modelo.addRow(reg);
                                  Puestos.setModel(modelo);
                                   br.close(); 
                                    return;

                               }
                            
                           } // fin while
                        // Cierro el buffer de lectura
                        br.close();
                            modelo.addRow(reg);
                                  Puestos.setModel(modelo);
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
        
        public void cargarPtos()
        {
            //TABLA
           DefaultTableModel modelo = (DefaultTableModel) Puestos.getModel();
            modelo.getDataVector().clear();
            
            String []reg = new String [7];
            //TABLA
            
            File fAntiguo= new File("puestos.txt");
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
                                   modelo.addRow(reg);
                                   Puestos.setModel(modelo);
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
        jLabel2 = new javax.swing.JLabel();
        idfiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Puestos = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Puestos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta de Puestos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        jLabel2.setText("ID");

        idfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idfiltroKeyReleased(evt);
            }
        });

        Puestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripcion"
            }
        ));
        Puestos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PuestosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Puestos);

        jToggleButton1.setText("Salir");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(idfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idfiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idfiltroKeyReleased
        Buscar(idfiltro.getText());
        if(idfiltro.getText().isEmpty())
        cargarPtos();
    }//GEN-LAST:event_idfiltroKeyReleased

    private void PuestosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PuestosMouseClicked
        enviardatospto();
    }//GEN-LAST:event_PuestosMouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
          this.dispose();

    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(conPuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(conPuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(conPuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(conPuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new conPuestos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Puestos;
    private javax.swing.JTextField idfiltro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
