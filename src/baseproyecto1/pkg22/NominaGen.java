package baseproyecto1.pkg22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class NominaGen extends javax.swing.JFrame {

    archivos metodos = new archivos();
    boolean skip = false;
    static DecimalFormat decimalFormat = new DecimalFormat("###,###.##");

    public NominaGen() {

        initComponents();
        idnomina.setText(metodos.nextId("nomina.txt") + "");
        idnomina.setEnabled(false);

    }

    void limpiar() {

        fecnomina.setText("");
        status.setSelectedItem("True");

    }

    public String Generador() {
        File fAntiguo = new File("empleados.txt");
        File fAntiguoCoop = new File("cooperativa.txt");
        File fAntiguoPuesto = new File("Puestos.txt");
        File fAntiguoDepto = new File("departamentos.txt");
        String numnomina = idnomina.getText();
        String fechanom = fecnomina.getText();
        boolean EstadoCoop = false;
        double desc_perc = 0;
        // Declaro un nuevo buffer de lectura

        BufferedReader br;
        BufferedReader brcoop;
        BufferedReader brpuesto;
        BufferedReader brdepto;

        try {
            if (fAntiguo.exists()) {
                br = new BufferedReader(new FileReader(fAntiguo));

                String linea;

                while ((linea = br.readLine()) != null) {
                    String[] arrOfStr = linea.split(",");
                    String[] arrOfStrCoop = {"0"};
                    String lnueva;
                    String lantigua;

                    double sbruto = (Double.parseDouble(arrOfStr[10]));
                    double vars = 0, vafp = 0, visr = 0, valcoop = 0, sueldonetus = 0, excedente;
                    double acum_coop = 0;
                    EstadoCoop = "Posee".equals(arrOfStr[9]);
                    //para obtener el valor descuento de la cooperativa
                    if (EstadoCoop == true) {
                        brcoop = new BufferedReader(new FileReader(fAntiguoCoop));
                        try {

                            String lineacoop;
                            while ((lineacoop = brcoop.readLine()) != null) {
                                arrOfStrCoop = lineacoop.split(",");

                                if (arrOfStrCoop[0].equals(arrOfStr[0])) {
                                    desc_perc = Double.parseDouble(arrOfStrCoop[1]);
                                    valcoop = sbruto * (desc_perc * 0.01);
                                    acum_coop = Double.valueOf(arrOfStrCoop[2]) + valcoop;
                                }
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        brcoop.close();
                    } else {

                        desc_perc = 0;
                    }

                    lnueva = arrOfStr[0] + "," + desc_perc + "," + acum_coop + "";
                    metodos.Modificar("cooperativa", arrOfStr[0], lnueva);
//                                

                    vars = 0.0304 * sbruto;
                    vafp = 0.0287 * sbruto;

                    //valor cooperativa ==
                    if (EstadoCoop == true) {

                    }

                    //PARA OBTENER EL VALOR DE ISR
                    sueldonetus = sbruto - vars - vafp;

                    if (sueldonetus <= 34685) {
                        visr = 0;
                    } else if (sueldonetus <= 52027.42) {
                        excedente = sueldonetus - 34685;
                        visr = excedente * 0.15;

                    } else if (sueldonetus <= 72260.25) {
                        excedente = sueldonetus - 52027.42;
                        visr = excedente * 0.20;
                        visr = visr + 2601.33;

                    } else if (sueldonetus > 72260.25) {
                        excedente = sueldonetus - 72260.25;
                        visr = excedente * 0.25;
                        visr = visr + 6648;
                    }
                    //FIN ISR

                    sueldonetus = sbruto - vars - vafp - visr - valcoop;

                    //Determinar puesto por ID
                    brpuesto = new BufferedReader(new FileReader(fAntiguoPuesto));
                    String[] arrOfStrPuesto;
                    String Puestostr = null;

                    String lineapuesto;
                    while ((lineapuesto = brpuesto.readLine()) != null) {
                        arrOfStrPuesto = lineapuesto.split(",");

                        if (arrOfStrPuesto[0].equals(arrOfStr[8])) {

                            Puestostr = arrOfStrPuesto[1];
                        }
                    }

                    brpuesto.close();

                    //Determinar departamento por ID
                    brdepto = new BufferedReader(new FileReader(fAntiguoDepto));
                    String[] arrOfStrDepto;
                    String Departamentostr = null;

                    String lineadepto;
                    while ((lineadepto = brdepto.readLine()) != null) {
                        arrOfStrDepto = lineadepto.split(",");

                        if (arrOfStrDepto[0].equals(arrOfStr[6])) {

                            Departamentostr = arrOfStrDepto[1];
                        }
                    }

                    brpuesto.close();

                    try {
                        //Crear archivo

                        metodos.GuardarDatos("nomina.txt", numnomina, arrOfStr[0], fechanom, sbruto
                                + "", vafp + "", vars + "", valcoop + "", visr + "", sueldonetus + "", "true");

                        Plantilla_Pdf pdf = new Plantilla_Pdf();
                        pdf.Aplantillao("Panamasin Gas", arrOfStr[0], arrOfStr[1], arrOfStr[2], fechanom,
                                decimalFormat.format(sbruto), decimalFormat.format(vafp), decimalFormat.format(vars), decimalFormat.format(valcoop),
                                 decimalFormat.format(visr), decimalFormat.format(sueldonetus), Departamentostr, Puestostr, desc_perc + "");
                        // salario_bruto ,String AFP ,String ARS ,String Cooperativa, String ISR ,String Sueldo_neto, 
//            String Departamento, String Puesto

                    } catch (IOException ex) {
                        Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } // fin while
                // Cierro el buffer de lectura
                br.close();
                limpiar();
                JOptionPane.showMessageDialog(this, "Nomina registrada!", "Información",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                System.out.println("Fichero no Existe");
            }
        } // fin try
        catch (IOException e) {
            System.out.println(e);
        }
        return "";
    } // fin metodo BUSCAR

    public String fecharep() {
        String ant = "0";

        try {
            // TODO add your handling code here:
            String fecha = fecnomina.getText();

            File fAntiguo = new File("nomina.txt");
            BufferedReader brt;

            brt = new BufferedReader(new FileReader(fAntiguo));
            String[] arrOfStr;

            String linea;
            while ((linea = brt.readLine()) != null) {
                arrOfStr = linea.split(",");

                if (arrOfStr[2].equals(fecha)) {

                    return "found";

                }

            }

            brt.close();
        } catch (IOException ex) {
            Logger.getLogger(NominaRevr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Not found";

    }

    void validar() {
        String [] fecha_partes;
        
        
                
        if (fecnomina.getText().equals("")) {
            JOptionPane.showMessageDialog(fecnomina, "Por favor introduzca la fecha de la nomina", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            fecnomina.requestFocus();
            skip = true;
        }else{
        skip = false;
        }
        fecha_partes = fecnomina.getText().split("/");
        if (Integer.parseInt(fecha_partes[1]) > 12 || Integer.parseInt(fecha_partes[1]) < 0){
            JOptionPane.showMessageDialog(fecnomina, "No hay un mes mayor a 12 ni menor a 01, digitelo de nuevo", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            fecnomina.requestFocus();
            skip = true;
        }else if (Integer.parseInt(fecha_partes[2]) > 3000 || Integer.parseInt(fecha_partes[2]) < 1800){
            JOptionPane.showMessageDialog(fecnomina, "Parece que hay un error con el año, por favor digíte una fecha real.", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            fecnomina.requestFocus();
            
            skip = true;
        }else if ((fecha_partes[2]).length() < 4 || (fecha_partes[1]).length() < 2){
            JOptionPane.showMessageDialog(fecnomina, "Parece que falta un digito, favor escribir de la forma DD/MM/AAAA. Ej: 30/01/2022", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            fecnomina.requestFocus();
            skip = true;
            
            
        }else if (fecharep().equals("found")) {
            JOptionPane.showMessageDialog(fecnomina, "Esta fecha ya esta en uso, intente de nuevo!", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            
            skip = true;
        }else{
            skip = false;
        
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idnomina = new javax.swing.JTextField();
        registrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        insertaNuevo = new javax.swing.JButton();
        fecnomina = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nominas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        jLabel1.setText("ID Nomina");

        jLabel4.setText("Fecha Nomina");

        idnomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idnominaActionPerformed(evt);
            }
        });
        idnomina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idnominaKeyTyped(evt);
            }
        });

        registrar.setText("Generar");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Estado Nomina");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "True" }));

        insertaNuevo.setText("Nuevo");
        insertaNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertaNuevoActionPerformed(evt);
            }
        });

        try {
            fecnomina.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("30/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("Mes/Año");

        estado.setText("Estado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(estado)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 20, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idnomina, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fecnomina, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                    .addComponent(registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(insertaNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(estado)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idnomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fecnomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insertaNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idnominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idnominaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idnominaActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed

        validar();
        
        if(skip == false){
            Generador();
            /*VALIDACIONES*/

            limpiar();
            idnomina.setText(metodos.nextId("nomina.txt") + "");

        
        estado.setText("Creando...");
        // TODO add your handling code here:
        }
    }//GEN-LAST:event_registrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Seguro desea cancelar?", "Informacion", dialogButton);
        if (dialogResult == 0) {
            this.dispose();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void idnominaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idnominaKeyTyped
        if (Character.isAlphabetic(evt.getKeyChar())) {
            evt.consume();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_idnominaKeyTyped

    private void insertaNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertaNuevoActionPerformed

    }//GEN-LAST:event_insertaNuevoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated


    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(NominaGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NominaGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NominaGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NominaGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NominaGen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel estado;
    private javax.swing.JFormattedTextField fecnomina;
    private javax.swing.JTextField idnomina;
    private javax.swing.JButton insertaNuevo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton registrar;
    public static javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}
