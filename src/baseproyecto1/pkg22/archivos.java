/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseproyecto1.pkg22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Locky
 */
public class archivos {
    
       public int nextId(String archivo)
        {
            File fAntiguo= new File(archivo);
            // Declaro un nuevo buffer de lectura
            BufferedReader br;
            try
                {
                    if(fAntiguo.exists())
                      {
                        br = new BufferedReader(new FileReader(fAntiguo));
                        String linea, lineaAnterior= "";
                        while((linea=br.readLine()) != null)
                          {   
                              if(linea != null)
                                lineaAnterior= linea;
                              
                             
                           } // fin while
                        // Cierro el buffer de lectura
                             br.close();
                             String[] arrOfStr = lineaAnterior.split(",");   
                             return Integer.parseInt(arrOfStr[0])+1;

                    }
                    else
                    {
                        System.out.println("Fichero no Existe");
                    }
                } // fin try
                catch(Exception e)
                    {
                        System.out.println(e);
                    }

            return 1;
        } // fin metodo BUSCAR
    
    public void GuardarDatos (String... args) throws IOException
	{   //Primer parámetro Args[0] es el nombre del archivo, a partir de ahí son los campos que se
            // quieren guardar en el archivo.
            String linea = "";
            try
            {
		FileWriter F1=new FileWriter(args[0], true);
		PrintWriter pw=new PrintWriter(F1);
                
                for (int i = 0; i < args.length; i++) {
                    if(i>0){
                        linea += args[i];
                    if(i<args.length-1)
                         linea+= ",";
                    }
                }                
                System.out.println(linea);
                pw.println(linea);
		pw.close();
            } catch  (IOException ex) {
		  JOptionPane.showMessageDialog(null,"Error al grabar Archivo " + ex);
                }
	    
        } // fin metodo GuardarDatos
     //public void Modificar(String codigo,String nombre, String edad)
    
    
   public void Modificar(String archivo, String LineaAntigua,String nuevalinea)
        {
   
            File fNuevo= new File(archivo+"1.txt"); 
            File fAntiguo= new File(archivo+".txt");
            String aCadena=LineaAntigua;
            String nCadena=nuevalinea;
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
                            // if (!linea.isEmpty())   
                            if(arrOfStr[0].equals(aCadena))
                               {
                                  Escribir(fNuevo,nCadena);

                               }
                            else
                               {
                                  Escribir(fNuevo,linea);
                                }
                           } // fin while

                        // Cierro el buffer de lectura
                        br.close();

                        // Capturo el nombre del fichero antiguo
                        String nAntiguo = fAntiguo.getName();
                        // Borro el fichero antiguo
                        borrar(fAntiguo);
                        //Renombro el fichero auxiliar con el nombre del fichero antiguo
                        fNuevo.renameTo(fAntiguo);
                    }
                    else
                    {
                        System.out.println("Fichero no Existe");
                    }

                } // fin try
                catch(IOException ex)
                    {
                        System.out.println(ex);
                    }
        } // fin metodo Modificar


    void Escribir(File fFichero,String cadena)
        {
           // Declaramos un buffer de escritura
           BufferedWriter bw;

           try
            {
               if(!fFichero.exists())
                 {
                    fFichero.createNewFile();
                 }

               // Luego de haber creado el archivo procedemos a escribir dentro de el.
               bw = new BufferedWriter(new FileWriter(fFichero,true));
               bw.write(cadena+"\r\n");
               bw.close();

            }// fin try
            catch(Exception e)
             {
               System.out.println(e);
             }

        } // fin metodo Escribir


    void borrar (File Ffichero)
        {
           try
            {
               // Comprovamos si el fichero existe  de ser así procedemos a borrar el archivo
               if(Ffichero.exists())
                 {
                    Ffichero.delete();
                    System.out.println("Fichero Borrado");
                 }

            } // fin try
            catch(Exception e)
             {
                System.out.println(e);
             }
        } // fin metodo Borrar   
}