package tn.esprit.pidev.Controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.pidev.entities.Stock;
import tn.esprit.pidev.entities.supplying;
import tn.esprit.pidev.model.ExelExporter;
import tn.esprit.pidev.service.SupplyingService;

@RestController
public class SupplyingRestController {
	
	@Autowired
	SupplyingService supplyingservice;
	
	@PostMapping("/AddSupplying")
	@ResponseBody
	public void AddSupplying(@RequestBody supplying supplyin){
		
		supplyingservice.AddSupplying(supplyin);
	}
	
	@PutMapping("/supptostock")
	@ResponseBody
	public String FromSupplyingtoStock() {
		return supplyingservice.FromSupplyingtoStock();
	}
	
	@GetMapping("/msupplies")
	@ResponseBody
	public List<supplying> msupplies(){
		return supplyingservice.suppThisMonth();
		
	}
	
	@GetMapping("/mexp")
	@ResponseBody
	public ArrayList mexp(){
		return supplyingservice.Mexpeses();
		
	}
	
    /*@GetMapping("/supplying/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Suppliers_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<supplying> listsupp = supplyingservice.suppThisMonth();
         
        ExelExporter excelExporter = new ExelExporter(listsupp);
         
        excelExporter.export(response);   
    }*/
	
	@RequestMapping(value = "/import-excel", method = RequestMethod.POST)
    public ResponseEntity<List<supplying>> importExcelFile(@RequestParam("file") MultipartFile files) throws IOException {
        HttpStatus status = HttpStatus.OK;
        List<supplying> suppList = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
            if (index > 0) {
                supplying supp = new supplying();

                XSSFRow row = worksheet.getRow(index);
                Integer id = (int) row.getCell(0).getNumericCellValue();
                supp.setIdSupp(id);
                supp.setDateCreation(row.getCell(1).getDateCellValue());
                supp.setProduct(row.getCell(2).getStringCellValue());
                supp.setD_arrivale(row.getCell(3).getDateCellValue());
                supp.setQuantity((float) row.getCell(4).getNumericCellValue());
                supp.setTot_coast((float) row.getCell(5).getNumericCellValue());

                suppList.add(supp);
            }
        }

        return new ResponseEntity<>(suppList, status);
    }
	

}
