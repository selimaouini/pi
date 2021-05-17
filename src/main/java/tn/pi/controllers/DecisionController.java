 package tn.pi.controllers;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.pi.entities.Claim;
import tn.pi.services.decisionServices;
import tn.pi.entities.Decision;
import tn.pi.repositories.*;


@Controller(value = "DecisionController")
@ELBeanName(value = "DecisionController")
public class DecisionController {
	
	
	@Autowired
	decisionServices decisionServices;
	@Autowired
	claimRepository claimRepository;


	private List<Decision> decision;
	private int id_decision;
	private Date date_decision;
	private String decision_result;
	private Claim Claim;
	public decisionServices getDecisionServices() {
		return decisionServices;
	}
	public void setDecisionServices(decisionServices decisionServices) {
		this.decisionServices = decisionServices;
	}
	public List<Decision> getDecision() {
		decision= decisionServices.retrieveAllDecisions();
		return decision;
	}
	public void setDecision(List<Decision> decision) {
		this.decision = decision;
	}
	public long getId_decision() {
		return id_decision;
	}
	public void setId_decision(int id_decision) {
		this.id_decision = id_decision;
	}
	public Date getDate_decision() {
		return date_decision;
	}
	public void setDate_decision(Date date_decision) {
		this.date_decision = date_decision;
	}
	
	public String getDecision_result() {
		return decision_result;
	}
	public void setDecision_result(String decision_result) {
		this.decision_result = decision_result;
	}
	public Claim getClaim() {
		return Claim;
	}
	public void setClaim(Claim claim) {
		Claim = claim;
	}
	public void displayClaim(Claim cl){
		this.getClaim().setId_claim(cl.getId_claim());
		}
		
		
		public void selectClaim(int id){
			Claim dev= claimRepository.findById(id).get();
			displayClaim(dev);
		 }	
	public void addDecision(){
		Claim cl =new Claim();
		int idClaim = cl.getId_claim();
		Decision dc = new Decision();
		dc.setDate_decision(new Date());
		dc.setDecision_result(decision_result);
		decisionServices.addDecision(dc, idClaim);

	}
	
	public void deleteDecision(int id){
		decisionServices.deleteDecision(id);
		
	}
	
	
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
	     FacesContext.getCurrentInstance().
	             addMessage(null, new FacesMessage(severity, summary, detail));
	}


}