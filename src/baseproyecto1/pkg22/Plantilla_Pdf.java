/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseproyecto1.pkg22;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
/**
 *
 * @author olive
 */
public class Plantilla_Pdf {
    archivos a = new archivos();
    File archivo1 = new File("nomina.pdf");

    public void Aplantillao(){
    
        try {
            PDDocument documento = new PDDocument();
            PDPage pag = new PDPage(PDRectangle.LETTER);
            documento.addPage(pag);
            PDPageContentStream content = new PDPageContentStream(documento, pag);
            
            content.beginText();
            content.setFont(PDType1Font.TIMES_BOLD, 14);
            content.newLineAtOffset(20, pag.getMediaBox().getHeight()-52);
            content.showText("KLKKKK");
            content.endText();
            
            
            content.close();
            if(archivo1.exists()){
                      archivo1.delete();
                     
            }
            documento.save(archivo1);
            
        } catch (IOException e) {
        }
    
    }
}
