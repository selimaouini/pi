package tn.pi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.pi.entities.Bill;
import tn.pi.entities.Command;
import tn.pi.entities.Etatfidelite;
import tn.pi.entities.User;
import tn.pi.repositories.UserRepository;
import tn.pi.services.ICommandeService;
import tn.pi.services.IUserService;




@Controller(value = "FidelitéController")
@ELBeanName(value = "FidelitéController")

//@Join(path = "/fidelité/1", to = "/Fidelité.jsf")
public class FidelitéController {
	
	@Autowired
	ICommandeService cs;
	@Autowired
	IUserService us;
	@Autowired 
	UserRepository usrep;
	@Autowired 
	UserController uc;
	private List<User> user;
	public User oneuser; 
	private String lastName;
	private String firstName;
	
	
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	private int idUser;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public void setOneuser(User oneuser) {
		this.oneuser = oneuser;
	}
	

	public User getOneuser() {
	
		
		User oneuser = us.retrieveUser(uc.getIdUserC());
		
		return oneuser;
	}
;

	private double pointconverti;
	private double nbrpoint;
	@Enumerated(EnumType.STRING)
	private Etatfidelite etat;
	public List<User> getUser() {
		
		user = us.retrieveAllUsers();
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public double getPointconverti() {
		return pointconverti;
	}
	public void setPointconverti(double pointconverti) {
		this.pointconverti = pointconverti;
	}
	public double getNbrpoint() {
		return nbrpoint;
	}
	public void setNbrpoint(double nbrpoint) {
		this.nbrpoint = nbrpoint;
	}
	public Etatfidelite getEtat() {
		return etat;
	}
	public void setEtat(Etatfidelite etat) {
		this.etat = etat;
	}
	public void convertir(int id)
	{
	cs.convertir(id);
	}
	
	public void activer(int id)
	{
	cs.activerprogrammefidelite(id);}
	public void desactiver(int id)
	{
	cs.desactiver(id);
}}