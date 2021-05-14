package tn.pi.services;


import java.util.List;


import tn.pi.entities.Decision;

public interface decisionServices {

	
	
	List<Decision> retrieveAllDecisions();
	Decision updateDecision(Decision d);
	void deleteDecision(int idDecision);
	public void affecterDecisionAClaim(int idDecision,int idClaim);
	public String acceptDecision(int id);
	public List<Decision> getDecisionsByState();
	public void addDecision(Decision d ,int idClaim);
	
}
