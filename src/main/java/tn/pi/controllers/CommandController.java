package tn.pi.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lowagie.text.DocumentException;

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




@Controller(value = "CommandController")
@ELBeanName(value = "CommandController")
//@Join(path = "/", to = "/login.jsf")
public class CommandController {
	
	@Autowired
	ICommandeService cs;
	@Autowired
	IBillService bilserv;
	@Autowired
	ILigneCommandeService lignserv;
	@Autowired
	IUserService userserv;
	@Autowired 
	UserController uc;
	
	@Autowired 
	UserRepository userep;
	private List<Command> command;
	private double price;
	private int paymentterm;
	//@Currency(value = { "TND" ,"USD","EUR"})
	private String currency;
	private String nomuser;
  private String description;
	private double AmountCommand;
	private int reduction;
	
	
	public User bestclient;
	public double totaljour;
	private List<Command> commandjour;
	private List<Command> commanduser;
	
	
	
	
	
	
public List<Command> getCommanduser() {

	commanduser = cs.findCommandByUser(uc.getIdUserC());
		return commanduser;
	}


	public void setCommanduser(List<Command> commanduser) {
		this.commanduser = commanduser;
	}


public List<Command> getCommandjour() {
	commandjour=cs.getCommandestoday();
			return commandjour;
	}


	public void setCommandjour(List<Command> commandjour) {
		this.commandjour = commandjour;
	}


public void cadeau(){
	cs.cadeau();
}
	
	
public String getBestclient() {
	String bestclient = cs.bestuser().getFirstName()+" "+ cs.bestuser().getLastName();
		return bestclient;
	}
	public void setBestclient(User bestclient) {
		this.bestclient = bestclient;
	}
public double getTotaljour() {
	totaljour= cs.Sum();
		return totaljour;
	}
	public void setTotaljour(double totaljour) {
		this.totaljour = totaljour;
	}
public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPaymentterm() {
		return paymentterm;
	}
	public void setPaymentterm(int paymentterm) {
		this.paymentterm = paymentterm;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getNomuser() {
		return nomuser;
	}
	public void setNomuser(String nomuser) {
		this.nomuser = nomuser;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmountCommand() {
		return AmountCommand;
	}
	public void setAmountCommand(double amountCommand) {
		AmountCommand = amountCommand;
	}
	public int getReduction() {
		return reduction;
	}
	public void setReduction(int reduction) {
		this.reduction = reduction;
	}

	
	public String redirect() 

	{ 

	String navigateTo = "/pages/admin/index.jsf";
	return navigateTo;
	}
	

public List<Command> getCommand() {
	command = cs.getCommandes();
	return command;
	}



public void setCommand(List<Command> command) {
	command = command;
}

}