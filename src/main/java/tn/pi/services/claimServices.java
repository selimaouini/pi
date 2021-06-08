package tn.pi.services;

import java.util.List;

import tn.pi.entities.Claim;
import tn.pi.entities.Decision;

public interface claimServices {
	List<Claim> retrieveAllClaims();
	void deleteClaim(int id);
	Claim updateClaim(Claim d);
	public String updateDescriptionComplaint(String description, int id);
	Claim retrieveClaim(int id_claim);
	public List<Claim> getClaimsByUser();
	public List<Claim> getClaimsByState();
	public void acceptClaim(int id);
	public void addClaim(int iduser,Claim comp);
	public void addClaimss(Claim cl);
	public void acceptClaimAddDecision(int id, Decision d);
	public String addClaimByUserAndDelivery(int idUser, int idDelivery, Claim d);
    public String verifierClaim();
	public int nbnotifs();
}
