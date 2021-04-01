package tn.esprit.pidev.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lowagie.text.DocumentException;

import org.springframework.http.HttpHeaders;
import lombok.var;
import tn.esprit.pidev.entities.Bill;
import tn.esprit.pidev.entities.BillPDFExporter;
import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.LigneComand;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.service.IBillService;
import tn.esprit.pidev.service.ICommandeService;
import tn.esprit.pidev.service.ILigneCommandeService;
import tn.esprit.pidev.service.IUserService;



@Controller
public class BillController {
@Autowired
IBillService bilserv;
@Autowired
ILigneCommandeService lignserv;
@Autowired
IUserService userserv;
@Autowired
ICommandeService comserv;
@GetMapping("/bills/export")
public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
    response.setContentType("application/pdf");
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    String currentDateTime = dateFormatter.format(new Date());
     
    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename=bills_" + currentDateTime + ".pdf";
    response.setHeader(headerKey, headerValue);
     
    List<LigneComand> lignes = lignserv.findLigneCommandByUser(1);
    Command commande =comserv.findCommandUser(1,1);
    Bill bill =bilserv.getBillByuser(1, 1);
    //List<User> users = userserv.getAll();
   User user = userserv.getUserById(1);
    BillPDFExporter exporter = new BillPDFExporter(user,lignes,bill,commande);
    exporter.export(response);
     
}
}
