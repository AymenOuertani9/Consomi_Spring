package tn.esprit.pidev.entities;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class BillPDFExporter {
	private List<Command> listcommands;
   ///  private List<User>users;
	private List<LigneComand>lignes;
	private User u;
	private List<Bill> bills;
	//private List<User> users; 
	private Bill bill;
private Command c;
		private void writeTableHeader(PdfPTable table,PdfPTable table2,PdfPTable table3,PdfPTable table4,PdfPTable table5,PdfPTable table6,PdfPTable table7,PdfPTable table8) {
			 PdfPCell cell2 = new PdfPCell();
		        cell2.setBorderColor(Color.white);
		        cell2.setPaddingLeft(2);
		        
		         
		        Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
		        font1.setColor(Color.BLACK);
		         
	        PdfPCell cell = new PdfPCell();
	        cell.setBorderColor(Color.black);
	        cell.setBackgroundColor(Color.BLACK);
	        cell.setPadding(5);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	       
	        
	        cell.setPhrase(new Phrase("Product_Description", font));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Quantity", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Currency", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Unit_Price", font));
	        table.addCell(cell);
	      
	        cell.setPhrase(new Phrase("Total_Price", font));
	        table.addCell(cell);   
	    
	        PdfPCell cell1 = new PdfPCell();
	        cell1.setBackgroundColor(Color.GREEN);
	        cell1.setPadding(4);
	         
	       
	         
	       /*
	        
	        cell1.setPhrase(new Phrase("% TVA", font));
	         cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
	        table2.addCell(cell1);
	         
	        cell1.setPhrase(new Phrase("Reduction", font));
	        cell1.setHorizontalAlignment(Element.ALIGN_BASELINE);
	        table2.addCell(cell1);
	         
	        cell1.setPhrase(new Phrase("Shipping cost", font));
	        cell1.setHorizontalAlignment(Element.ALIGN_BASELINE);
	        table2.addCell(cell1);
	         
	       
	        cell1.setPhrase(new Phrase("Total", font));
	        cell1.setHorizontalAlignment(Element.ALIGN_BASELINE);
	        table2.addCell(cell1);   */
	    }
	   

		public BillPDFExporter(User u , List<LigneComand> lignes, Bill bill,Command c) {
			super();
			this.u = u;
			this.lignes = lignes;
			this.bill = bill;
			this.c=c;
		}


		private void writeTableData(PdfPTable table,PdfPTable table2,PdfPTable table3 ,PdfPTable table4,PdfPTable table5,PdfPTable table6,PdfPTable table7,PdfPTable table8) {
	        for (LigneComand lc : lignes) {
	        	 PdfPCell cell = new PdfPCell();
	 	        cell.setBorderColor(Color.BLACK);
	        	//table.addCell(String.valueOf(u.getLc().getProduit().getCategory()));
	            table.addCell(lc.getProduit().getDescription());
	            table.addCell(String.valueOf(lc.getQte()));
	            table.addCell(lc.getCart().getCurrency());
	            table.addCell(String.valueOf(lc.getPrice()));
	            table.addCell(String.valueOf(lc.getCart().getTotal()));
	           
	        }
	     //   for (Command c : listcommands) {
	        	 PdfPCell cell = new PdfPCell();
	 	        cell.setBorderColor(Color.BLACK);
	 	       Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		        font.setSize(15);
		        font.setColor(Color.BLACK);
		        
		        
	        	//table.addCell(String.valueOf(u.getLc().getProduit().getCategory()));
		        cell.setBackgroundColor(Color.BLACK);
		        cell.setPadding(5);
		        
		       
		        font.setColor(Color.WHITE);
		         
		       
		        
		        Paragraph p = new Paragraph("Total_bill", font);
		        
			      
		        
		        p.setAlignment(Paragraph.ALIGN_CENTER);
		        cell.addElement(p);
		        table2.addCell(cell);
	            table2.addCell("TVA  "+"                       "+String.valueOf(c.getTva())+""+c.getCart().getCurrency());
	            table5.addCell("Reduction  "+"              "+String.valueOf(c.getReduction())+""+c.getCart().getCurrency());
	            table6.addCell("Shipping cost "+"          "+String.valueOf(c.getDelivery().getFraislivraison())+""+c.getCart().getCurrency());
	            table7.addCell("Total  "+"                      "+String.valueOf(c.getBill().getTotalfinal())+""+c.getCart().getCurrency());
	            
	           
	     //   }
//for (Bill b : bills) {
		    	
	PdfPCell cell2;
	  Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
      font1.setSize(50);
      font1.setColor(Color.BLACK);
      font1.setStyle(5);
      Paragraph p1 = new Paragraph("Bill" +"  "+ "N°"+bill.getNumBill(), font1);
      
    
      
      p1.setAlignment(Paragraph.ALIGN_LEFT);
     
      p1.setFont(font1);
    cell2 = new PdfPCell(p1);
  //  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
   // cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell2.setBorderColor(Color.white);
    table8.addCell(cell2);
   // table8.setSpacingAfter(40);
    cell2 = new PdfPCell(new Phrase("Date_bill :  "+String.valueOf(bill.getDatebill())));
    cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
    //cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell2.setBorderColor(Color.white);
    table3.addCell(cell2);
    table3.setSpacingAfter(10);
   // table3.setSpacingBefore(20);
    cell2 = new PdfPCell(new Phrase("Date_reglement :  " +String.valueOf(bill.getDatereglement())));
    cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
   // cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell2.setBorderColor(Color.white);
    table3.addCell(cell2);
    table3.setSpacingAfter(10);
    cell2 = new PdfPCell(new Phrase("Payment_method : " +String.valueOf(bill.getCommand().getPayement())));
    cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
   // cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell2.setBorderColor(Color.white);
    table3.addCell(cell2);
	         
	        
	            
	           
	       // }

//for (Command c : listcommands) {
	
	PdfPCell cell1;

    cell1 = new PdfPCell(new Phrase("First_Name :  "+String.valueOf(u.getFirstname())));
    cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
   // cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell1.setBorderColor(Color.white);
    table3.addCell(cell1);
    table3.setSpacingAfter(10);
    cell1 = new PdfPCell(new Phrase("Last_Name:  "+String.valueOf(u.getLastname())));
    cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
    //cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell1.setBorderColor(Color.white);
    table3.addCell(cell1);
    table3.setSpacingAfter(10);
    cell1 = new PdfPCell(new Phrase("Adress :  " +String.valueOf(u.getAdress())));
    cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
   // cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell1.setBorderColor(Color.white);
    table3.addCell(cell1);
    table3.setSpacingAfter(10);
    cell1 = new PdfPCell(new Phrase("Tel : " +String.valueOf(u.getTel())));
    cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
   // cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell1.setBorderColor(Color.white);
    table3.addCell(cell1);
    cell1 = new PdfPCell(new Phrase("Email : " +String.valueOf(u.getLogin())));
    cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
   // cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell1.setBorderColor(Color.white);
    table3.addCell(cell1);
	         
	        
	            
	           
	        }
	        
	    
	  
	       
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	      
	     //   document.add(p);
	   
	        PdfPTable table = new PdfPTable(5);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {4.5f, 4.5f, 3.0f, 3.0f, 3.0f});
	        table.setSpacingBefore(10);
	        PdfPTable table3 = new PdfPTable(1);
	        table3.setWidthPercentage(100f);
	     //   table3.setWidths(new float[] {4.5f, 4.5f, 3.0f, 3.0f});
	        table3.setSpacingAfter(50);
	       // table3.setSpacingBefore(20);
	       // document.add(table);
	        PdfPTable table4 = new PdfPTable(1);
	        table4.setWidthPercentage(100f);
	     //   table3.setWidths(new float[] {4.5f, 4.5f, 3.0f, 3.0f});
	        table4.setSpacingAfter(50);
	        PdfPTable table2 = new PdfPTable(1);
	        table2.setWidthPercentage(40f);
	       // table2.setWidths(new float[] {1f, 1.5f, 1.5f, 1.5f});
	        table2.setSpacingBefore(70);
	      //  table2.setHeadersInEvent(true);
	     table2.setHorizontalAlignment(Table.ALIGN_RIGHT);
	       // table2.setHorizontalAlignment(4);
	        PdfPTable table5 = new PdfPTable(1);
	        table5.setWidthPercentage(40f);
	        //table2.setWidths(new float[] {1f, 1.5f, 1.5f, 1.5f});
	      //  table2.setSpacingBefore(10);
	       // table2.setHeadersInEvent(true);
	     table5.setHorizontalAlignment(Table.ALIGN_RIGHT);
	     PdfPTable table6 = new PdfPTable(1);
	        table6.setWidthPercentage(40f);
	        //table2.setWidths(new float[] {1f, 1.5f, 1.5f, 1.5f});
	      //  table2.setSpacingBefore(10);
	       // table2.setHeadersInEvent(true);
	     table6.setHorizontalAlignment(Table.ALIGN_RIGHT);
	     PdfPTable table7 = new PdfPTable(1);
	        table7.setWidthPercentage(40f);
	        //table2.setWidths(new float[] {1f, 1.5f, 1.5f, 1.5f});
	      //  table2.setSpacingBefore(10);
	       // table2.setHeadersInEvent(true);
	     table7.setHorizontalAlignment(Table.ALIGN_RIGHT);
	    //    table2.setHorizontalAlignment(4);
	     PdfPTable table8 = new PdfPTable(1);
	        table8.setWidthPercentage(100f);
	     //   table3.setWidths(new float[] {4.5f, 4.5f, 3.0f, 3.0f});
	        table8.setSpacingAfter(20);
	        writeTableHeader(table, table2,table3,table4,table5,table6,table7,table8);
	        writeTableData(table, table2,table3,table4,table5,table6,table7,table8);
	        Image image = Image.getInstance ("c:\\logoconsomi34.png");
	        image.setAlignment(Image.RIGHT);
	        image.scaleAbsolute(154, 94);
	        image.scalePercent(50);
	        document.add(table8);
	         document.add(image);
	        document.add(table3);
	        document.add(table4);
	        document.add(table);
	        document.add(table2);
	        document.add(table5);
	        document.add(table6);
	        document.add(table7);
	        document.close();
	         
	    }
}
