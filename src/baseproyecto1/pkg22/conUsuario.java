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

public class conUsuario extends javax.swing.JFrame {

        int entrada = Menu.entrada;

    /**
     * Creates new form conUsuario
     */
    public conUsuario() {
        initComponents();
        cargarUsers();
        
    }  
 
    
void enviardatosuser(){
        int fila=usuarios.getSelectedRow();
        if(fila>=0){
            if(entrada == 2){
                   new Usuario(usuarios.getValueAt(fila,0).toString()).setVisible(true);
                   Usuario.registrar.setEnabled(false);
                }
            }
    else{
        JOptionPane.showMessageDialog(null,"Por favor, seleccione una fila");
    }
    }
    public void Buscar(String filtro)
        {
            //TABLA
           DefaultTableModel modelo = (DefaultTableModel) usuarios.getModel();
            modelo.getDataVector().clear();
            
            String []reg = new String [6];
            //TABLA
            
            File fAntiguo= new File("usuarios.txt");
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
                                    
                                   
                                   
                                   modelo.addRow(reg);
                                  usuarios.setModel(modelo);
                                   br.close(); 
                                    return;

                               }
                            
                           } // fin while
                        // Cierro el buffer de lectura
                        br.close();
                            modelo.addRow(reg);
                                  usuarios.setModel(modelo);
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
        } // fin metodo BUSCAR
    
    public static void cargarUsers()
        {
            //TABLA
           DefaultTableModel modelo = (DefaultTableModel) usuarios.getModel();
            modelo.getDataVector().clear();
            
            String []reg = new String [6];
            //TABLA
            
            File fAntiguo= new File("usuarios.txt");
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
                                    
                                   modelo.addRow(reg);
                                   usuarios.setModel(modelo);
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
        } // fin metodo BUSCAR
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usuarios = new javax.swing.JTable();
        idfiltro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Login", "Contraseña", "Nombre", "Apellido", "Correo", "Nivel de acceso"
            }
        ));
        usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(usuarios);

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

        jLabel1.setText("User ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idfiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idfiltroKeyReleased
        Buscar(idfiltro.getText()); 
        if(idfiltro.getText().isEmpty())
            cargarUsers();
    }//GEN-LAST:event_idfiltroKeyReleased

    private void idfiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idfiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idfiltroActionPerformed

    private void usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariosMouseClicked
    enviardatosuser();
    }//GEN-LAST:event_usuariosMouseClicked

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
            java.util.logging.Logger.getLogger(conUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(conUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(conUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(conUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new conUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idfiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable usuarios;
    // End of variables declaration//GEN-END:variables
}
