package tn.pi.services;

import java.util.List;

import tn.pi.entities.Claim;

public interface claimServices {
	List<Claim> retrieveAllClaims();
	Claim addClaim(Claim d);
	void deleteClaim(String id);
	Claim updateClaim(Claim d);
	Claim retrieveClaim(String id_claim);

}
