package tn.pi.restControllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.pi.entities.Bill;

import tn.pi.entities.TypeFacture;
import tn.pi.repositories.IBillRepository;
import tn.pi.services.IBillService;

@RestController
public class RestControlBill {
@Autowired
IBillService facserv;

@Autowired 
IBillRepository billrep;


private int numBill;

public int getNumBill() {
	return numBill;
}

public void setNumBill(int numBill) {
	this.numBill = numBill;
}

private Bill getbill(int id) {
	Bill Bill = billrep.findById(id).get();
	
	return Bill;
}

//URL : http://localhost:8081/SpringMVC/servlet/getBillByIduser/{userid}
@GetMapping(value = "/getBillByIduser/{userid}")
public List<Bill> getBillByIduser(@PathVariable("userid") int iduser) {
	return facserv.getBillByIduser(iduser);
}
//URL : http://localhost:8081/SpringMVC/servlet/getBillById/{idbill}
@GetMapping(value = "/getBillById/{idbill}")
public Bill getBillById(@PathVariable("idbill") int billId) {
	return facserv.getBillById(billId);
}

//URL : http://localhost:8081/SpringMVC/servlet/AddBill
@PostMapping(value = "/AddBill")
public String AddBill(@RequestBody Bill bill) {
	return facserv.AddBill(bill);
}

//URL : http://localhost:8081/SpringMVC/servlet/getBillTotalById/{idbill}
@GetMapping(value = "/getBillTotalById/{idbill}")
public double getBillTotalById(@PathVariable("idbill") int billId) {
	return facserv.getBillTotalById(billId);
}

//URL : http://localhost:8081/SpringMVC/servlet/deleteBillById/{idbill}
@DeleteMapping(value = "/deleteBillById/{idbill}")
public String deleteBillById(@PathVariable("idbill") int billId) {
	return facserv.deleteBillById(billId);
}

//URL : http://localhost:8081/SpringMVC/servlet/getAllBill
@GetMapping(value = "/getAllBill")
public List<Bill> getAllBill() {
	return facserv.getAllBill();
}
//URL : http://localhost:8081/SpringMVC/servlet/addOrUpdateBill
@PostMapping(value = "/addOrUpdateBill")
public String addOrUpdateBill(@RequestBody Bill bill) {
	return facserv.addOrUpdateBill(bill);
}
//URL : http://localhost:8081/SpringMVC/servlet/addandassignUserABill/{iduser}
@PostMapping(value = "/addandassignUserABill/{iduser}")
public void addandassignUserABill(@RequestBody Bill bill,@PathVariable("iduser") int userId) {
	facserv.addandassignUserABill(bill, userId);
}

//URL : http://localhost:8081/SpringMVC/servlet/find/{num}
@GetMapping(value = "/find/{num}")
public Bill find(@PathVariable("num") int numero) {
	return facserv.find(numero);
}




//URL : http://localhost:8081/SpringMVC/servlet//assignUserABill/{billId}/{iduser}
@PutMapping(value = "/assignUserABill/{billId}/{iduser}")
public String assignUserABill(@PathVariable("billId") int billId,@PathVariable("iduser") int userId) {
	return facserv.assignUserABill(billId, userId);
}

//URL : http://localhost:8081/SpringMVC/servlet/assignOrderABill/{billId}/{idorder}
@PutMapping(value = "/assignOrderABill/{billId}/{idorder}")
public String assignOrderABill(@PathVariable("billId") int billId,@PathVariable("idorder") int orderId) {
	return facserv.assignOrderABill(billId, orderId);
}

//URL : http://localhost:8081/SpringMVC/servlet/addandassignOrderABill/{idorder}
@PostMapping(value = "/addandassignOrderABill/{idorder}")
public String addandassignOrderABill(@RequestBody Bill bill,@PathVariable("idorder") int orderId) {
	return facserv.addandassignOrderABill(bill, orderId);
}

//URL : http://localhost:8081/SpringMVC/servlet/count
@GetMapping(value = "/count")
public long count() {
	return facserv.count();
}


//URL : http://localhost:8081/SpringMVC/servlet/findBYtype/{typefac}
@GetMapping(value = "/findBYtype/{typefac}")
public List<Bill> findBYtype(@PathVariable("typefac") TypeFacture tupefac) {
	return facserv.findBYtype(tupefac);
}




//URL : http://localhost:8081/SpringMVC/servlet/getBillByIdorder/{idorder}
@GetMapping(value = "/getBillByIdorder/{idorder}")
public List<Bill> getBillByIdorder(@PathVariable("idorder") int idorder) {
	return facserv.getBillByIdorder(idorder);
}




//URL : http://localhost:8081/SpringMVC/servlet/getBillBydatereglement/{datereglmt}
@GetMapping(value = "/getBillBydatereglement/{datereglmt}")
public List<Bill> getBillBydatereglement(@DateTimeFormat(pattern = "dd-MM-yyyy") Date datereglmt) {
	return facserv.getBillBydatereglement(datereglmt);
}


//URL : http://localhost:8081/SpringMVC/servlet/getBillBydatebill/{datebill}
@GetMapping(value = "/getBillBydatebill/{d1}")
public List<Bill> getBillBydatebill(@PathVariable("d1") @DateTimeFormat(pattern = "dd-MM-yyyy") Date datebill) {
	return facserv.getBillBydatebill(datebill);
}

//URL : http://localhost:8081/SpringMVC/servlet/getBillBytotalfinalsup
@GetMapping(value = "/getBillBytotalfinalsup")
public List<Bill> getBillBytotalfinalsup() {
	return facserv.getBillBytotalfinalsup();
}


}

