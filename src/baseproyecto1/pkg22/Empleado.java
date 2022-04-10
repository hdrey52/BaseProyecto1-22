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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Empleado extends javax.swing.JFrame {

    archivos metodos = new archivos();

    public Empleado() {
        initComponents();
        idemp.setText(metodos.nextId("empleados.txt")+"");
        idemp.setEnabled(false);
       // iddpto.setEnabled(false);
       // idpto.setEnabled(false);
    }
           public Empleado (String id){
        initComponents();
        idemp.setEnabled(false);
       // idpto.setEnabled(false);
       // idpto.setEnabled(false);
        Buscar(id);
    }
           
    void limpiar(){
    
        nom.setText("");
        ape.setText("");   
        dir.setText("");
        tef.setText("");
        sex.setSelectedItem("True");
        coop.setSelectedItem("True");
        idpto.setText("");
        iddpto.setText("");
        fecha.setText("");
        slrio.setText("");     
    }
    
    public String Buscar(String filtro)
        {
            File fAntiguo= new File("empleados.txt");
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
                                   idemp.setText(arrOfStr[0]);
                                   nom.setText(arrOfStr[1]);
                                   ape.setText(arrOfStr[2]);
                                   dir.setText(arrOfStr[3]);
                                   tef.setText(arrOfStr[4]);
                                   sex.setSelectedItem(arrOfStr[5]);
                                   iddpto.setText(arrOfStr[6]);
                                   fecha.setText(arrOfStr[7]);
                                   idpto.setText(arrOfStr[8]);
                                   coop.setSelectedItem(arrOfStr[9]);
                                   slrio.setText(arrOfStr[10]); 
                                   br.close();
                                   return "found";
                               }
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
            return "not found";
        }
    
    void validar(){ 
       if(idemp.getText().equals("")){
             JOptionPane.showMessageDialog(idemp, "Por favor introduzca el id del empleado", "Advertencia", 
                                            JOptionPane.WARNING_MESSAGE);
             
             idemp.requestFocus();
        }
          else if(nom.getText().equals("")){
             JOptionPane.showMessageDialog(nom, "Por favor introduzca el nombre del empleado", "Advertencia", 
                                            JOptionPane.WARNING_MESSAGE);
             nom.requestFocus();
        }
        else if(ape.getText().equals("")){
             JOptionPane.showMessageDialog(ape, "Por favor introduzca el apellido del empleado", "Advertencia", 
                                            JOptionPane.WARNING_MESSAGE);
             ape.requestFocus();
        }
       
      
          else if(dir.getText().equals("")){
             JOptionPane.showMessageDialog(dir, "Por favor introduzca la direccion del empleado", "Advertencia", 
                                            JOptionPane.WARNING_MESSAGE);
             dir.requestFocus();
        }  
          
          else if(tef.getText().equals("")){
             JOptionPane.showMessageDialog(tef, "Por favor introduzca el telefono del empleado", "Advertencia", 
                                            JOptionPane.WARNING_MESSAGE);
             tef.requestFocus();
          }
             
        else if(iddpto.getText().equals("")){
             JOptionPane.showMessageDialog(iddpto, "Por favor introduzca el departamento al que pertenece el empleado", "Advertencia", 
                                            JOptionPane.WARNING_MESSAGE);
             iddpto.requestFocus();
        }
        
       else if(idpto.getText().equals("")){
             JOptionPane.showMessageDialog(idpto, "Por favor introduzca el puesto al que pertenece el empleado", "Advertencia", 
                                            JOptionPane.WARNING_MESSAGE);
             idpto.requestFocus();
        }
       
        else if(slrio.getText().equals("")){
             JOptionPane.showMessageDialog(slrio, "Por favor introduzca el salario del empleado", "Advertencia", 
                                            JOptionPane.WARNING_MESSAGE);
             slrio.requestFocus();
        }
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        idemp = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        ape = new javax.swing.JTextField();
        dir = new javax.swing.JTextField();
        iddpto = new javax.swing.JTextField();
        idpto = new javax.swing.JTextField();
        slrio = new javax.swing.JTextField();
        sex = new javax.swing.JComboBox<>();
        coop = new javax.swing.JComboBox<>();
        btn_consultar = new javax.swing.JButton();
        btn_bdepto = new javax.swing.JButton();
        btn_bpto = new javax.swing.JButton();
        fecha = new javax.swing.JFormattedTextField();
        tef = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        jLabel1.setText("ID");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Direccion");

        jLabel5.setText("Telefono");

        jLabel6.setText("Sexo");

        jLabel7.setText("Departamento");

        jLabel8.setText("Fecha Ingreso");

        jLabel9.setText("Puesto");

        jLabel10.setText("Cooperativa");

        jLabel11.setText("Salario");

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");

        dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirActionPerformed(evt);
            }
        });

        iddpto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iddptoActionPerformed(evt);
            }
        });

        idpto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idptoActionPerformed(evt);
            }
        });

        slrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slrioActionPerformed(evt);
            }
        });
        slrio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                slrioKeyTyped(evt);
            }
        });

        sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        sex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexActionPerformed(evt);
            }
        });

        coop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Posee", "Posee", " " }));

        btn_consultar.setText("Consultar");

        btn_bdepto.setText("buscar");
        btn_bdepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bdeptoActionPerformed(evt);
            }
        });

        btn_bpto.setText("buscar");
        btn_bpto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bptoActionPerformed(evt);
            }
        });

        try {
            fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fechaKeyTyped(evt);
            }
        });

        try {
            tef.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tefKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idemp)
                            .addComponent(nom, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(ape, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(dir, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(iddpto, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(idpto, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(slrio, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(sex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(coop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fecha)
                            .addComponent(tef))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_consultar)
                            .addComponent(btn_bdepto)
                            .addComponent(btn_bpto)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_nuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_eliminar)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_consultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(iddpto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_bdepto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(idpto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_bpto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(coop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(slrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_guardar)
                            .addComponent(btn_nuevo)
                            .addComponent(btn_modificar)
                            .addComponent(btn_eliminar))
                        .addContainerGap())))
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

    private void dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dirActionPerformed

    private void iddptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iddptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iddptoActionPerformed

    private void idptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idptoActionPerformed

    private void slrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slrioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_slrioActionPerformed

    private void sexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
    
        int ide, iddptos, idptos;
        double salario;
        String nomb, apell, dire, fechaing, telef;
        boolean sexo, coope;
        /*VALIDACIONES*/
        validar();
         /*VALIDACIONES*/
         
         //Asignacion de valores
         ide = Integer.parseInt(idemp.getText());
         nomb = nom.getText();
         apell = ape.getText();
         dire = dir.getText();
         telef = tef.getText();
         
         if(sex.getSelectedItem().equals("True"))
             sexo = true;
         else
             sexo = false;
         
         iddptos = Integer.parseInt(iddpto.getText());
         fechaing = fecha.getText();
         idptos = Integer.parseInt(idpto.getText());
         
         if(coop.getSelectedItem().equals("True"))
             coope = true;
         else
             coope = false;
         
         salario = Double.parseDouble(slrio.getText());
         //Asignacion de valores
         
         //Crear archivo
         
            try {
            //Crear archivo
            metodos.GuardarDatos("empleados.txt", ide+"",nomb, apell+"", dire+"", telef+"", sexo+"", 
                                                    iddptos+"", fechaing+"", idptos+"", coope+"", salario+"");
            
        } catch (IOException ex) {
            Logger.getLogger(Departamento.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         
        limpiar();
         JOptionPane.showMessageDialog(this, "Empleado registrado!", "Información", 
                                            JOptionPane.INFORMATION_MESSAGE);
         idemp.setText(metodos.nextId("empleados.txt")+"");
       
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void tefKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tefKeyTyped
      if(Character.isAlphabetic(evt.getKeyChar())){
                   evt.consume(); 
            } 
    }//GEN-LAST:event_tefKeyTyped

    private void fechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaKeyTyped
      if(Character.isAlphabetic(evt.getKeyChar())){
                   evt.consume(); 
            } 
    }//GEN-LAST:event_fechaKeyTyped

    private void slrioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_slrioKeyTyped
      if(Character.isAlphabetic(evt.getKeyChar())){
                   evt.consume(); 
            } 
    }//GEN-LAST:event_slrioKeyTyped

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
    
        String lineaNueva = idemp.getText()+","+nom.getText()+","+ape.getText()+","+dir.getText()+","+tef.getText()+","+sex.getSelectedItem()+","+iddpto.getText()+","+fecha.getText()
        +","+idpto.getText()+","+coop.getSelectedItem()+","+slrio.getText();

        if(Buscar(iddpto.getText()).equals("not found")){
            JOptionPane.showMessageDialog(this, "Factura inexistente!", "Advertencia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        metodos.Modificar("empleados", iddpto.getText(), lineaNueva);

        limpiar();
        idemp.setText(metodos.nextId("empleados.txt")+"");
        JOptionPane.showMessageDialog(this, "Empleado modificada!", "Información",
            JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
    limpiar();
        idemp.setText(metodos.nextId("empleados.txt")+"");
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_bdeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bdeptoActionPerformed
     new conDepartamento(0).setVisible(true);
    }//GEN-LAST:event_btn_bdeptoActionPerformed

    private void btn_bptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bptoActionPerformed
    new conPuestos(0).setVisible(true);
    }//GEN-LAST:event_btn_bptoActionPerformed

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
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ape;
    private javax.swing.JButton btn_bdepto;
    private javax.swing.JButton btn_bpto;
    private javax.swing.JButton btn_consultar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> coop;
    private javax.swing.JTextField dir;
    private javax.swing.JFormattedTextField fecha;
    private javax.swing.JTextField iddpto;
    private javax.swing.JTextField idemp;
    private javax.swing.JTextField idpto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nom;
    private javax.swing.JComboBox<String> sex;
    private javax.swing.JTextField slrio;
    private javax.swing.JFormattedTextField tef;
    // End of variables declaration//GEN-END:variables
}
