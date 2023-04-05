import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*; 
import javax.imageio.ImageIO;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import javax.swing.JFrame;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;



import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.util.ImageUtils;

public class ClickImage {

    public static void main(String[] args) throws IOException, Exception {
       captureWithPanel();
    }

    public static void captureWithPanel() throws IOException, Exception{
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());

        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setImageSizeDisplayed(true);
        JFrame window = new JFrame("Webcam");
		JButton button=new JButton("Click Here");  
		button.setBounds(20,20,20,20);
		JButton button1=new JButton("size");  
		button1.setBounds(100,120,120,120);

		  button.addActionListener(new ActionListener(){  
		  public void actionPerformed(ActionEvent e) { 
			try{
			BufferedImage image = webcam.getImage();	
			ImageIO.write(image, ImageUtils.FORMAT_JPG, new File("C://javacode//images//ClickImage.jpg"));
					button.setText("CLICK");
			//for(int i =0; i<5; i++) {				
			//	for (int j=0; j <i ; j++)
			//	{
			//		ImageIO.write(image, ImageUtils.FORMAT_JPG, new File("C://javacode//images//ClickImage"+i+".jpg"));
			//		button.setText("CLICK");
			//	}

			//}

	//	int imageCount=1;
	//	do {
	//		
	//		ImageIO.write(image, ImageUtils.FORMAT_JPG, new File("C://javacode//images//ClickImage"+imageCount+".jpg"));
	//		button.setText("CLICK");
	//		imageCount++;
	//	} while(imageCount <0 );

			//for(int imageCount=0;imageCount<5;imageCount++) {
			//ImageIO.write(image, ImageUtils.FORMAT_JPG, new File("C://javacode//images//ClickImage"+imageCount+".jpg"));
			//button.setText("CLICK");
			//}
			button.setText("Captured");	
			ClickImage.pdfCreate();
			} catch(IOException ex){}
			 finally{
				System.out.println("PICTURE IS CLICKED");
			}
    }
	});
		panel.add(button);
		panel.add(button1);
        window.add(panel);
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }
	public static void pdfCreate() {
	try {

	//	String name = args[0];
	//	String roll = args[1];
	//	String course = args[2];
	//	String sem = args[3];
	//	String year = args[4];
	java.util.Scanner sc = new java.util.Scanner(System.in);
	System.out.println("Enter Your Name:");
	String name = sc.next();
	System.out.println("Enter Your Roll Number:");
	String roll = sc.next();
	System.out.println("Enter Your Course:");
	String course = sc.next();
	System.out.println("Enter Your Semester:");
	String sem = sc.next();
	System.out.println("Enter Your Year of study:");
	String year = sc.next();

		Rectangle one = new Rectangle(500,320);
		one.setBackgroundColor(new BaseColor(181, 213, 197));

		Document document = new Document(one);

		PdfWriter.getInstance(document, new FileOutputStream("D:\\IDCard.pdf"));

		//Rectangle two = new Rectangle(700,400);
		document.setPageSize(one);
		document.setMargins(2, 2, 2, 2);

		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 21,Font.UNDERLINE);
		Font font2 = new Font(Font.FontFamily.COURIER , 18,Font.ITALIC);

		OutputStream outputStream = new FileOutputStream(new File("D:\\ResultPdf.pdf"));
 
		PdfWriter.getInstance(document, outputStream);

			document.open();
	
				Paragraph parax = new Paragraph("RAJA RALWANT SINGH",font);
				parax.setAlignment(Element.ALIGN_CENTER);
				document.add(parax);

				Paragraph paray = new Paragraph("ID Card",font2);
				paray.setAlignment(Element.ALIGN_CENTER);
				document.add(paray);

				Image logo = Image.getInstance("C://javacode//images//ClickImage.jpg");
				logo.scaleAbsolute(80.f,80.f);
				logo.setAbsolutePosition(400f,150f);
			//	float[]float1={50,50,50,50,50,50};
				PdfPTable pdfPTable = new PdfPTable(2);
				pdfPTable.setHorizontalAlignment(Element.ALIGN_LEFT);
				pdfPTable.setWidthPercentage(50);

		PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("Name:"));
        PdfPCell pdfPCell2 = new PdfPCell(new Phrase(name));
        PdfPCell pdfPCell3 = new PdfPCell(new Paragraph("Roll No."));
        PdfPCell pdfPCell4 = new PdfPCell(new Paragraph(roll));
        PdfPCell pdfPCell5 = new PdfPCell(new Paragraph("Course"));
        PdfPCell pdfPCell6 = new PdfPCell(new Paragraph(course));
        PdfPCell pdfPCell7 = new PdfPCell(new Paragraph("Semester"));
        PdfPCell pdfPCell8 = new PdfPCell(new Paragraph(sem));
        PdfPCell pdfPCell9 = new PdfPCell(new Paragraph("year"));
        PdfPCell pdfPCell10 = new PdfPCell(new Paragraph(year));

			   pdfPCell1.setBorderColor(new BaseColor(181, 213, 197));
			   pdfPCell2.setBorderColor(new BaseColor(181, 213, 197));
			   pdfPCell3.setBorderColor(new BaseColor(181, 213, 197));
			   pdfPCell4.setBorderColor(new BaseColor(181, 213, 197));
			   pdfPCell5.setBorderColor(new BaseColor(181, 213, 197));
			   pdfPCell6.setBorderColor(new BaseColor(181, 213, 197));
			   pdfPCell7.setBorderColor(new BaseColor(181, 213, 197));
			   pdfPCell8.setBorderColor(new BaseColor(181, 213, 197));
			   pdfPCell9.setBorderColor(new BaseColor(181, 213, 197));
			   pdfPCell10.setBorderColor(new BaseColor(181, 213, 197));


		pdfPTable.addCell(pdfPCell1);
        pdfPTable.addCell(pdfPCell2);
        pdfPTable.addCell(pdfPCell3);
        pdfPTable.addCell(pdfPCell4);
        pdfPTable.addCell(pdfPCell5);
        pdfPTable.addCell(pdfPCell6);
        pdfPTable.addCell(pdfPCell7);
        pdfPTable.addCell(pdfPCell8);
        pdfPTable.addCell(pdfPCell9);
        pdfPTable.addCell(pdfPCell10);

		document.add(new Paragraph("\n\n"));
		document.add(pdfPTable);
//Paragraph p = new Paragraph("I Alice Khan, am submitting my resume for consideration for the Software Engineering internship program at Google. \nGiven the skills and experience outlined in my enclosed resume, I believe I might be a worthy asset to your team.\nIn my three years at R.B.S. college, I have completed a great deal of coursework on  Web development as well as Software Development where I learned and applied skills such as developing Notepad Clone, Winforms applications with C# with .Net framework, and designing websites using PHP, MySQL, Html, CSS, js. \nIn addition, I did a one-month web development internship and currently learning software development skills in a real-time environment.During my school time, I was the head and academic in charge, which taught me the importance of time management and teamwork. It also helped me grow my skills in team verbal communication and project leadership.I would make an excellent addition to your team. This internship would help me grow my real-world experience in the IT industry and help me further develop and refine my software development skills.I look forward to hearing from you! \nSincerely, \nAlice Khan");
//document.add(p);
//document.setPageSize(two);
//document.setMargins(20, 20, 20, 20);
//document.newPage();
document.add(logo);
document.close();
        System.out.println("Success");
    } catch (Exception e) {
	e.printStackTrace();
    }
	}
}