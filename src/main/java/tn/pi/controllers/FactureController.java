package tn.pi.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.pi.entities.Bill;
import tn.pi.entities.Command;
import tn.pi.entities.TypeFacture;
import tn.pi.entities.User;
import tn.pi.services.IBillService;
import tn.pi.services.ICommandeService;




@Controller(value = "FactureController")
@ELBeanName(value = "FactureController")
//@Join(path = "/", to = "/login.jsf")
public class FactureController {
	
	@Autowired
	IBillService bs;
	@Autowired 
	UserController uc;
	private List<Bill> bill;
	private List<Bill> bill2;
	private int idBill;
	private int numBill;
	
	private double totalfinal;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date datereglement;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date datebill;
	@Enumerated(EnumType.STRING)
	private TypeFacture typeofbill;
    private Command command;
    private User user;
    
	
	public List<Bill> getBill2() {
		bill2 = bs.getBillByIduser(uc.getIdUserC());
		return bill2;
	}
	public void setBill2(List<Bill> bill2) {
		this.bill2 = bill2;
	}
	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public int getNumBill() {
		return numBill;
	}
	public void setNumBill(int numBill) {
		this.numBill = numBill;
	}
	public double getTotalfinal() {
		return totalfinal;
	}
	public void setTotalfinal(double totalfinal) {
		this.totalfinal = totalfinal;
	}
	public Date getDatereglement() {
		return datereglement;
	}
	public void setDatereglement(Date datereglement) {
		this.datereglement = datereglement;
	}
	public Date getDatebill() {
		return datebill;
	}
	public void setDatebill(Date datebill) {
		this.datebill = datebill;
	}
	public TypeFacture getTypeofbill() {
		return typeofbill;
	}
	public void setTypeofbill(TypeFacture typeofbill) {
		this.typeofbill = typeofbill;
	}
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
	public List<Bill> getBill() {
		bill = bs.getAllBill();
	return bill;
	}
	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}

}