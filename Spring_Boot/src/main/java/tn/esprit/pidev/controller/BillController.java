package tn.esprit.pidev.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lowagie.text.DocumentException;

import org.springframework.http.HttpHeaders;

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
@Autowired
private JavaMailSender javaMailSender;
@GetMapping("/bills/export")
public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
    response.setContentType("application/pdf");
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    String currentDateTime = dateFormatter.format(new Date());
     
    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename=bills" + currentDateTime+".pdf";
    response.setHeader(headerKey, headerValue);
     
    List<LigneComand> lignes = lignserv.findLigneCommandByUser(1);
    Command commande =comserv.findCommandUser(1,1);
    Bill bill =bilserv.getBillByuser(1, 1);
    //List<User> users = userserv.getAll();
   User user = userserv.getUserById(1);
    BillPDFExporter exporter = new BillPDFExporter(user,lignes,bill,commande);
    exporter.export(response);
     
}
public   void sendEmail() {

    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setTo("validation.spring2021@gmail.com");

    msg.setSubject("Testing from Spring Boot");
    msg.setText("Hello World \n Spring Boot Email");

    javaMailSender.send(msg);

}

public void sendEmailWithAttachment() throws MessagingException, IOException {

    MimeMessage msg = javaMailSender.createMimeMessage();

    // true = multipart message
    MimeMessageHelper helper = new MimeMessageHelper(msg, true);

    helper.setTo("validation.spring2021@gmail.com");

    helper.setSubject("Testing from Spring Boot");

    // default = text/plain
    //helper.setText("Check attachment for image!");

    // true = text/html
    helper.setText("<h1>Check attachment for bill!</h1>", true);

	// hard coded a file path
    FileSystemResource file = new FileSystemResource(new File("C:/Users\\Manel Mattoussi\\Desktop\\bills_2021-03-29_23_33_50.pdf"));

    helper.addAttachment("bills_2021-03-29_23_33_50.pdf", file);

    javaMailSender.send(msg);

}	
}
