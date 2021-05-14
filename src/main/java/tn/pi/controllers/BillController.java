package tn.pi.controllers;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lowagie.text.DocumentException;

import org.springframework.http.HttpHeaders;
import tn.pi.entities.Bill;
import tn.pi.entities.BillPDFExporter;
import tn.pi.entities.Command;
import tn.pi.entities.LigneComand;
import tn.pi.entities.User;
import tn.pi.repositories.UserRepository;
import tn.pi.services.IBillService;
import tn.pi.services.ICommandeService;
import tn.pi.services.ILigneCommandeService;
import tn.pi.services.IUserService;



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
UserRepository userep;
@GetMapping("/bills/export/{id}")
public void exportToPDF(HttpServletResponse response,@PathVariable("id")  int id) throws DocumentException, IOException {
    response.setContentType("application/pdf");
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    String currentDateTime = dateFormatter.format(new Date());
     
    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename=bills_" + currentDateTime + ".pdf";
    response.setHeader(headerKey, headerValue);
     
    List<LigneComand> lignes = lignserv.findLigneCommandByUser(1);
    Command commande =comserv.findCommandUser(1,1);
    Bill bill =bilserv.getBillByuser(1,1);
    
User user = userep.findById(id).get();

BillPDFExporter exporter = new BillPDFExporter(user,lignes,bill,commande );
exporter.export(response);
     
}
}