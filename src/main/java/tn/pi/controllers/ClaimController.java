package tn.pi.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import tn.pi.repositories.*;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.annotation.JsonIgnore;

import freemarker.template.TemplateException;
import tn.pi.entities.Claim;
import tn.pi.entities.Command;
import tn.pi.entities.Decision;
import tn.pi.entities.Delivery;
import tn.pi.entities.DeliveryMan;
import tn.pi.entities.User;
import tn.pi.services.EmailService;
import tn.pi.services.claimServices;
import tn.pi.services.decisionServices;

@Controller(value = "ClaimController")
@ELBeanName(value = "ClaimController")
public class ClaimController {

	@Autowired
	claimServices claimService;
	@Autowired
	decisionServices decisionServices;
	@Autowired
	EmailService EmailService;
	@Autowired 
	claimRepository claimRepository;
	 private String text2;
	private List<Claim> claim;
	private int idToUpdate;
    private int id_claim;
	private String description;
	private String result;
	private Date date;
	private boolean state;
	private Decision Decision;
	private Delivery Delivery;
	private User User;
	public claimServices getClaimService() {
		return claimService;
	}
	public void setClaimService(claimServices claimService) {
		this.claimService = claimService;
	}
	public List<Claim> getClaim() {
		claim =claimService.retrieveAllClaims();
		return claim;
	}
	public void setClaim(List<Claim> claim) {
		this.claim = claim;
	}
	public long getId_claim() {
		return id_claim;
	}
	
	
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setId_claim(int id_claim) {
		this.id_claim = id_claim;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isState() {
		return state;
	}
	
	public int getIdToUpdate() {
		return idToUpdate;
	}
	public void setIdToUpdate(int idToUpdate) {
		this.idToUpdate = idToUpdate;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Decision getDecision() {
		return Decision;
	}
	public void setDecision(Decision decision) {
		Decision = decision;
	}
	public Delivery getDelivery() {
		return Delivery;
	}
	public void setDelivery(Delivery delivery) {
		Delivery = delivery;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	
	public void acceptClaimAddDecision(int id){
		Decision d = new Decision();
		
		claimService.acceptClaimAddDecision(id,d);
		
	}
	public void deleteClaim(int id){
		claimService.deleteClaim(id);
	}
	public String getText2() {
        return text2;
    }
    public void setText2(String text2) {
    this.text2 = text2;
}
/*/////////avec user		
	public Claim addClaim(int iduser,Claim comp){
	    
		Claim claim=new Claim();
		claim.setDescription(description);
		claimService.addClaim(iduser, comp);
		return claim;
	    }
	*/
    public void addClaimss(){
		Claim comp = new Claim();
		comp.setDescription(description);
		claimService.addClaimss(comp);
		addMessage(FacesMessage.SEVERITY_INFO, "Success", "Claim added successfuly");

	}
    
    
	public void displayClaim(Claim cl){
	this.setIdToUpdate(cl.getId_claim());
	}
	public String selectClaim(int id){
		Claim dev= claimRepository.findById(id).get();
		displayClaim(dev);
		return "/pages/admin/createDecision.xhtml?faces-redirect=true";
	 }	
	public void addDecision(int idClaim){
		Decision dc =new Decision();
		dc.setDecision_result(result);
		decisionServices.addDecision(dc, idToUpdate);
		dc.getClaim().setState(true);
		addMessage(FacesMessage.SEVERITY_INFO, "Success", "Decision added");

		
			
			try {
				EmailService.sendMail(dc.getClaim().getUser().getEmail() , " Reclamation Recu", dc.getDecision_result());
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		
		
		
	}
	/*
	public String verifierClaim(int id) {
		Claim cl=claimRepository.findById(id).get();
		User user=new User();
		int idUser=user.getIdUser();
        
		
		  
		}
		*/
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
	     FacesContext.getCurrentInstance().
	             addMessage(null, new FacesMessage(severity, summary, detail));
	}
		
	}
	
	 
	
