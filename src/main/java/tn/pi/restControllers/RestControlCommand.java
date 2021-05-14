package tn.pi.restControllers;



import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.pi.entities.Bill;
import tn.pi.entities.Command;
import tn.pi.entities.Etat;
import tn.pi.entities.ModePayement;
import tn.pi.entities.ProgrammeFidelité;
import tn.pi.entities.User;
import tn.pi.services.ICommandeService;


@RestController
public class RestControlCommand {
@Autowired
ICommandeService comserv;




// URL : http://localhost:8081/SpringMVC/servlet/getCommande/{idc}
@GetMapping(value = "/getCommande/{idc}")
public Command getCommande(@PathVariable ("idc")int idcommand) {
	return comserv.getCommande(idcommand);
}

//URL : http://localhost:8081/SpringMVC/servlet/getCommande/{idc}
@GetMapping(value = "/getCommandes")
public List<Command> getCommandes() {
	return comserv.getCommandes();
}

//URL : http://localhost:8081/SpringMVC/servlet/getMaxNumcommand
@GetMapping(value = "/getMaxNumcommand")
public int getMaxNumcommand() {
	return comserv.getMaxNumcommand();
}
//URL : http://localhost:8081/SpringMVC/servlet/findCommandByCart/{idcart}
@GetMapping(value = "/findCommandByCart/{idcart}")
public Command findCommandByCart(@PathVariable ("idcart") int cartid) {
	return comserv.findCommandByCart(cartid);
}
//URL : http://localhost:8081/SpringMVC/servlet/findCommandByUser/{idu}
@GetMapping(value = "/findCommandByUser/{idu}")
public List<Command > findCommandByUser(@PathVariable ("idu") int userid) {
	return comserv.findCommandByUser(userid);
}

//URL : http://localhost:8081/SpringMVC/servlet/affecterCartACommand/{idc}/{idcmd}
@PutMapping(value = "/affecterCartACommand/{idc}/{idcmd}/{iddeliv}")
public void affecterCartACommand(@PathVariable ("idc") int cartId,@PathVariable ("idcmd") int commandId , @PathVariable("iddeliv")int deliveryid) {
	comserv.affecterCartACommand(cartId,commandId);
}


//URL : http://localhost:8081/SpringMVC/servlet/deleteCommandById/{idcom}
@DeleteMapping(value = "/deleteCommandById/{idcom}")
public void deleteCommandById(@PathVariable("idcom") int comandId) {
	comserv.deleteCommandById(comandId);
}

@GetMapping(value = "/client")
public int getUserofmonth() {
return comserv.getUserofmonth();	
}

@GetMapping(value = "/best")
public User bestuser() {
return comserv.bestuser();	
}





//URL : http://localhost:8081/SpringMVC/servlet/findByOrderByOrderDatecreationDesc
@GetMapping(value = "/findByOrderByOrderDatecreationDesc")
public List<Command> findByOrderByOrderDatecreationDesc() {
return comserv.findByOrderByOrderDatecreationDesc();	
}

//URL : http://localhost:8081/SpringMVC/servlet/cancel/{id}
@PutMapping(value = "/cancel/{id}")
public void cancel(@PathVariable("id") int id) {
	comserv.cancel( id);
}
//URL : http://localhost:8081/SpringMVC/servlet/{id}
@PutMapping(value = "/reduction/{id}")
public void reductionsurcommande(@PathVariable("id") int idcart) {
	comserv.reductionsurcommande(idcart);
}

//URL : http://localhost:8081/SpringMVC/servlet/count/{x}
@GetMapping(value = "/count/{x}")
public long count(@PathVariable("x") Etat etat) {
	return comserv.count(etat);
}

@PostMapping(value = "/saveCommande/{idc}/{mp}/{vp}")
public void saveCommande( @PathVariable("idc")int cartId ,@PathVariable("mp")ModePayement payement,@PathVariable("vp")Boolean validpayement) {
	comserv.saveCommande(cartId);
}

//URL : http://localhost:8081/SpringMVC/servlet/findByPayement/{x}
@GetMapping(value = "/findByPayement/{x}")
public List<Command> findByPayement(@PathVariable("x") ModePayement payement) {
	return comserv.findByPayement(payement);
}

//URL : http://localhost:8081/SpringMVC/servlet/updatestatus/{vp}/{idc}
@GetMapping(value = "/updatestatus/{vp}/{idc}")
public String updatestatus(@PathVariable("vp") Boolean validpayement,@PathVariable("idc")int idcmd) {
	return comserv.updatestatus(validpayement, idcmd);
}
@PutMapping(value = "/Activerfid/{iduser}")
public String activerprogrammefidelite(@PathVariable("iduser") int iduser) {
	return comserv.activerprogrammefidelite(iduser);
}
@PutMapping(value = "/convertir/{iduser}")
public String convertir(@PathVariable("iduser") int iduser) {
	return comserv.convertir(iduser);
}

@PutMapping(value = "/paymentbyfidelite/{idcart}")
public String paymentbyfidelite(@RequestBody ProgrammeFidelité pf ,@PathVariable("idcart") int idcart ) {
	return comserv.paymentbyfidelite(idcart);
}


@PutMapping(value = "/cadeau")
public User cadeau () {
	return comserv.cadeau();
}
//URL : http://localhost:8081/SpringMVC/servlet/findByDateCreation/{datecreation}
@GetMapping(value = "/findByDateCreation/{datec}")
public Command findByDateCreation(@PathParam("datec") @DateTimeFormat(pattern = "dd-MM-yyyy") Date datecreation) {
	return comserv.findByDateCreation(datecreation);
}

//URL : http://localhost:8081/SpringMVC/servlet/findAllByDateCreation/{datec}
@GetMapping(value = "/findAllByDateCreation/{datec}")
public List<Command> findAllByDateCreation(@PathParam("datec") @DateTimeFormat(pattern = "dd-MM-yyyy") Date datecreation) {
	return comserv.findAllByDateCreation(datecreation);
}
}