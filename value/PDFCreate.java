import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFCreate {
  public static void main(String args[]){
    try {
 Rectangle pageSize = new Rectangle(PageSize.A4);
pageSize.setBackgroundColor(new BaseColor(181, 213, 197));


Document document = new Document( pageSize );

	OutputStream outputStream = 
		new FileOutputStream(new File("D:\\DemoPDF.pdf"));
 
		//Create PDFWriter instance.
	PdfWriter.getInstance(document, outputStream);
 
        //Open the document.
	document.open();

        //Add content to the document.
	document.add(new Paragraph("PDF Created Succesfully"));
	document.add(new Paragraph("Para 2"));
	String para3 = "Paragraph 3";
	while (para3.length() < 50) {

              para3 = " " + para3;

            }
			Paragraph paragraph1 = new Paragraph(para3);
			document.add(paragraph1);
        //Close document and outputStream.

	document.close();
	outputStream.close();
 
        System.out.println("Success");
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
}