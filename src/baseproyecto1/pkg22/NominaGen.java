 
package baseproyecto1.pkg22;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class NominaGen extends javax.swing.JFrame {
 
    static boolean EstadoCoop = false;
    static int desc_perc = 1;
    
    archivos metodos = new archivos();
    public NominaGen() {
        
        initComponents();
        idnomina.setText(metodos.nextId("nomina.txt")+"");
        mod.setEnabled(false);
        idnomina.setEnabled(false);
        idemp.setEnabled(false);
        Salario_Bruto.setEnabled(false);
        AFP.setEnabled(false);
        ARS.setEnabled(false);
        valor_coop.setEnabled(false);
        ISR.setEnabled(false);
        Sueldo_neto.setEnabled(false); 
    }
    
       public NominaGen(String id){
        initComponents();
        idnomina.setEnabled(false);
        idemp.setEnabled(false);
        Buscar(id);
        idnomina.setEnabled(false);
              

    }
    
        
void limpiar(){
    
        ARS.setText("");
        idemp.setText("");     
        valor_coop.setText("");
        ISR.setText("");
        Sueldo_neto.setText("");
        fecnomina.setText("");
        status.setSelectedItem("True");
       
} 

  public static void calculos(){
      
     double sbruto=0, vars=0, vafp=0, visr=0, valcoop=0, sueldonetus=0, excedente;
             
     sbruto = Double.parseDouble(Salario_Bruto.getText());
     
     vars = 0.0304 * sbruto;
     vafp = 0.0287 * sbruto;
     
     //valor cooperativa ==
     if(EstadoCoop == true) valcoop = sbruto * (desc_perc * 0.01);


    //PARA OBTENER EL VALOR DE ISR
     sueldonetus = sbruto-vars-vafp;
     
     if(sueldonetus <= 34685){
         visr = 0;
     }else if(sueldonetus <= 52027.42){
         excedente = sueldonetus - 34685;
         visr = excedente * 0.15;
         
     }else if(sueldonetus <= 72260.25){
         excedente = sueldonetus - 52027.42;
         visr = excedente * 0.20;
         visr = visr + 2601.33;
         
     }else if(sueldonetus > 72260.25){
         excedente = sueldonetus - 72260.25;
         visr = excedente * 0.25;
         visr = visr + 6648;
     }
     //FIN ISR
     
     
     sueldonetus = sbruto-(vars+vafp+visr+valcoop);
     
       AFP.setText(String.valueOf(vafp));
       ARS.setText(String.valueOf(vars));
       ISR.setText(String.valueOf(visr));
       valor_coop.setText(String.valueOf(valcoop));
       Sueldo_neto.setText(String.valueOf(sueldonetus));
       AFP.setText(String.valueOf(vafp));
      
  }
  public String Buscar(String filtro)
        {
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
                                   idnomina.setText(arrOfStr[0]);
                                   ARS.setText(arrOfStr[1]);
                                   idemp.setText(arrOfStr[2]);
                                   valor_coop.setText(arrOfStr[3]);
                                   ISR.setText(arrOfStr[4]);
                                   Sueldo_neto.setText(arrOfStr[5]);
                                   fecnomina.setText(arrOfStr[6]);
                                   status.setSelectedItem(arrOfStr[7]);
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
        } // fin metodo BUSCAR
    

void validar(){ 
       if(idnomina.getText().equals("")){
             JOptionPane.showMessageDialog(idnomina, "Por favor introduzca el numero de nomina", "Advertencia", 
                                            JOptionPane.WARNING_MESSAGE);
             
             idnomina.requestFocus();
        }
          else if(idemp.getText().equals("")){
             JOptionPane.showMessageDialog(idemp, "Por favor introduzca el id del empleado", "Advertencia", 
                                            JOptionPane.WARNING_MESSAGE);
             idemp.requestFocus();
        }
          else if(fecnomina.getText().equals("")){
             JOptionPane.showMessageDialog(fecnomina, "Por favor introduzca la fecha de la nomina", "Advertencia", 
                                            JOptionPane.WARNING_MESSAGE);
             fecnomina.requestFocus();
        }  
          
          else if(ARS.getText().equals("")){
             JOptionPane.showMessageDialog(ARS, "Por favor introduzca el monto de pago a la ARS", "Advertencia", 
                                            JOptionPane.WARNING_MESSAGE);
             ARS.requestFocus();
        }  
          
    
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ARS = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idnomina = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        idemp = new javax.swing.JTextField();
        registrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        valor_coop = new javax.swing.JTextField();
        ISR = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Sueldo_neto = new javax.swing.JTextField();
        status = new javax.swing.JComboBox<>();
        mod = new javax.swing.JButton();
        insertaNuevo = new javax.swing.JButton();
        fecnomina = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        AFP = new javax.swing.JTextField();
        Salario_Bruto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
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

        ARS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ARSActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Nomina");

        jLabel2.setText("ID Empleado");

        jLabel4.setText("Fecha Nomina");

        jLabel5.setText("Salario Bruto");

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

        jLabel6.setText("Valor ARS");

        idemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idempActionPerformed(evt);
            }
        });
        idemp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idempKeyTyped(evt);
            }
        });

        registrar.setText("Registrar");
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

        jLabel7.setText("Valor Cooperativa");

        jLabel8.setText("Valor ISR");

        valor_coop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valor_coopActionPerformed(evt);
            }
        });
        valor_coop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                valor_coopKeyTyped(evt);
            }
        });

        ISR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISRActionPerformed(evt);
            }
        });
        ISR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ISRKeyTyped(evt);
            }
        });

        jLabel9.setText("Sueldo Neto");

        jLabel10.setText("Estado Nomina");

        Sueldo_neto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sueldo_netoActionPerformed(evt);
            }
        });
        Sueldo_neto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Sueldo_netoKeyTyped(evt);
            }
        });

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "True", "False" }));

        mod.setText("Modificar");
        mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modActionPerformed(evt);
            }
        });

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

        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Mes/Año");

        AFP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AFPActionPerformed(evt);
            }
        });

        Salario_Bruto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salario_BrutoActionPerformed(evt);
            }
        });

        jLabel12.setText("Valor AFP");

        estado.setText("Estado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(mod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registrar)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(insertaNuevo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(estado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(fecnomina, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(idemp, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(idnomina, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(AFP, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Salario_Bruto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel11))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Sueldo_neto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(ISR, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(valor_coop, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ARS, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(estado)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idnomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(ARS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fecnomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(Salario_Bruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AFP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valor_coop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ISR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Sueldo_neto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrar)
                    .addComponent(jButton2)
                    .addComponent(mod)
                    .addComponent(insertaNuevo))
                .addGap(18, 18, 18))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ARSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ARSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ARSActionPerformed

    private void idnominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idnominaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idnominaActionPerformed

    private void idempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idempActionPerformed

    private void valor_coopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valor_coopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valor_coopActionPerformed

    private void ISRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISRActionPerformed

    private void Sueldo_netoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sueldo_netoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Sueldo_netoActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        
    

            int numnomina, idempleado;
        double valorcooperativa, valorISR, valorSueldoneto, valorARS, valorSalariobruto, valorAFP;
        String fechanom;
        boolean estado;
        /*VALIDACIONES*/
        validar();
         /*VALIDACIONES*/
         
         //Asignacion de valores
         numnomina = Integer.parseInt(idnomina.getText());
         idempleado = Integer.parseInt(idemp.getText());
         
         valorcooperativa = Double.parseDouble(valor_coop.getText());
         valorISR = Double.parseDouble(ISR.getText());
         valorARS = Double.parseDouble(ARS.getText());
         valorAFP = Double.parseDouble(AFP.getText());
         valorSueldoneto = Double.parseDouble(Sueldo_neto.getText());
         valorSalariobruto = Double.parseDouble(Salario_Bruto.getText());
         
         fechanom = fecnomina.getText();
         
         if(status.getSelectedItem().equals("True"))
             estado = true;
         else
             estado = false;
         //Asignacion de valores
         
         //Crear archivo
         
            try {
            //Crear archivo
            metodos.GuardarDatos("nomina.txt", numnomina+"", idempleado+"", fechanom, valorSalariobruto+"", valorAFP+"", valorARS+"", 
                    valorcooperativa+"", valorISR+"", valorSueldoneto+"", estado+"");
            
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

         
        limpiar();
         JOptionPane.showMessageDialog(this, "Nomina registrada!", "Información", 
                                            JOptionPane.INFORMATION_MESSAGE);
         idnomina.setText(metodos.nextId("nomina.txt")+"");
         
        
         
         
    }//GEN-LAST:event_registrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
            
    int dialogButton = JOptionPane.YES_NO_OPTION;
    int dialogResult = JOptionPane.showConfirmDialog(this, "Seguro desea cancelar?", "Informacion", dialogButton);
    if(dialogResult == 0) {
       this.dispose();
    } 
            
            
                   
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void idnominaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idnominaKeyTyped
 if(Character.isAlphabetic(evt.getKeyChar())){
                   evt.consume(); 
            }          // TODO add your handling code here:
    }//GEN-LAST:event_idnominaKeyTyped

    private void idempKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idempKeyTyped
 if(Character.isAlphabetic(evt.getKeyChar())){
                   evt.consume(); 
            }          // TODO add your handling code here:
    }//GEN-LAST:event_idempKeyTyped

    private void valor_coopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valor_coopKeyTyped
 if(Character.isAlphabetic(evt.getKeyChar())){
                   evt.consume(); 
            }          // TODO add your handling code here:
    }//GEN-LAST:event_valor_coopKeyTyped

    private void ISRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ISRKeyTyped
 if(Character.isAlphabetic(evt.getKeyChar())){
                   evt.consume(); 
            }          // TODO add your handling code here:
    }//GEN-LAST:event_ISRKeyTyped

    private void Sueldo_netoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Sueldo_netoKeyTyped
 if(Character.isAlphabetic(evt.getKeyChar())){
                   evt.consume(); 
            }          // TODO add your handling code here:
    }//GEN-LAST:event_Sueldo_netoKeyTyped

    private void modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modActionPerformed

        String lineaNueva = idnomina.getText()+","+ARS.getText()+","+idemp.getText()+","+","+valor_coop.getText()+","+ISR.getText()+","+Sueldo_neto.getText()
        +","+fecnomina.getText()+","+status.getSelectedItem();

        if(Buscar(idemp.getText()).equals("not found")){
            JOptionPane.showMessageDialog(this, "Nomina inexistente!", "Advertencia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        metodos.Modificar("nomina", idemp.getText(), lineaNueva);

        limpiar();
        idnomina.setText(metodos.nextId("nomina.txt")+"");
        JOptionPane.showMessageDialog(this, "Nomina modificada!", "Información",
            JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_modActionPerformed

    private void insertaNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertaNuevoActionPerformed
        limpiar();
        idnomina.setText(metodos.nextId("nomina.txt")+"");
        
         estado.setText("Creando...");
        // TODO add your handling code here:
    }//GEN-LAST:event_insertaNuevoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    
         
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        estado.setText("Creando...");
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new conEmpleado(0).setVisible(true);
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void AFPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AFPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AFPActionPerformed

    private void Salario_BrutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salario_BrutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Salario_BrutoActionPerformed

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
    public static javax.swing.JTextField AFP;
    private static javax.swing.JTextField ARS;
    private static javax.swing.JTextField ISR;
    public static javax.swing.JTextField Salario_Bruto;
    public static javax.swing.JTextField Sueldo_neto;
    private javax.swing.JLabel estado;
    private javax.swing.JFormattedTextField fecnomina;
    public static javax.swing.JTextField idemp;
    private javax.swing.JTextField idnomina;
    private javax.swing.JButton insertaNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JButton mod;
    private javax.swing.JButton registrar;
    public static javax.swing.JComboBox<String> status;
    public static javax.swing.JTextField valor_coop;
    // End of variables declaration//GEN-END:variables
}
