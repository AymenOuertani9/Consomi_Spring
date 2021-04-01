package tn.esprit.pidev.Controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	
    @GetMapping("/supplying/export/excel")
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
    }
	

}
