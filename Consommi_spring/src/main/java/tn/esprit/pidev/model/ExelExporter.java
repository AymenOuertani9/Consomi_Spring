package tn.esprit.pidev.model;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tn.esprit.pidev.entities.Stock;
import tn.esprit.pidev.entities.supplying;

public class ExelExporter {
	
	 private XSSFWorkbook workbook;
	    private XSSFSheet sheet;
	    private List<supplying> listSupplyings;
	     
	    public ExelExporter(List<supplying> listSupplyings) {
	        this.listSupplyings=listSupplyings;
	        workbook = new XSSFWorkbook();
	    }
	 
	 
	    private void writeHeaderLine() {
	        sheet = workbook.createSheet("Supplying");
	         
	        Row row = sheet.createRow(0);
	         
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setBold(true);
	        font.setFontHeight(16);
	        style.setFont(font);
	         
	        createCell(row, 0, "supplying ID", style);      
	        createCell(row, 1, "Creation Date", style);       
	        createCell(row, 2, "Product Name", style);    
	        createCell(row, 3, "Arrivale Date", style);
	        createCell(row, 4, "quantity", style);
	        createCell(row, 5, "Coasts", style);
	         
	    }
	     
	    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
	        sheet.autoSizeColumn(columnCount);
	        Cell cell = row.createCell(columnCount);
	        if (value instanceof Integer) {
	            cell.setCellValue((Integer) value);
	        } else if (value instanceof Boolean) {
	            cell.setCellValue((Boolean) value);
	        }else {
	            cell.setCellValue((String) value);
	        }
	        cell.setCellStyle(style);
	    }
	     
	    private void writeDataLines() {
	        int rowCount = 1;
	 
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setFontHeight(14);
	        style.setFont(font);
	                 
	        for (supplying supp : listSupplyings) {
	            Row row = sheet.createRow(rowCount++);
	            int columnCount = 0;
	             
	            createCell(row, columnCount++,supp.getIdSupp(), style);
	            createCell(row, columnCount++, supp.getDateCreation(), style);
	            createCell(row, columnCount++,supp.getProduct(), style);
	            createCell(row, columnCount++, supp.getD_arrivale(), style);
	            createCell(row, columnCount++,supp.getQuantity(), style);
	            createCell(row, columnCount++, supp.getTot_coast(), style);
	             
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws IOException {
	        writeHeaderLine();
	        writeDataLines();
	         
	        ServletOutputStream outputStream = response.getOutputStream();
	        workbook.write(outputStream);
	        workbook.close();
	         
	        outputStream.close();
	         
	    }

}
