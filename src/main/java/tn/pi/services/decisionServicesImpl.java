package tn.pi.services;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.pi.entities.Claim;
import tn.pi.entities.Decision;
import tn.pi.entities.User;
import tn.pi.repositories.claimRepository;
import tn.pi.repositories.decisionRepository;
@Service
public class decisionServicesImpl implements decisionServices {

	
	@Autowired
	decisionRepository decisionRepository;
	@Autowired
	claimRepository claimRepository;

	@Override
	public List<Decision> retrieveAllDecisions() {
		decisionRepository.findAll();
		return(List<Decision>)decisionRepository.findAll();
	}

	@Override
	public Decision updateDecision(Decision d) {
		decisionRepository.save(d);
		return d;
	}

	@Override
	public void deleteDecision(int idDecision) {
		decisionRepository.deleteById(idDecision);
		
	}

	@Override
	public void affecterDecisionAClaim(int idDecision, int idClaim) {
		Claim e = claimRepository.findById(idClaim).orElse(null);
		Decision c = decisionRepository.findById( idDecision).orElse(null);
		c.setClaim(e);
		decisionRepository.save(c);
		
	}

	@Override
	public String acceptDecision(int id) {
		Decision c = decisionRepository.findById( id).get();
		
		int idaa = c.getClaim().getId_claim();
		Claim aa = claimRepository.findById(idaa).get();
		claimRepository.save(aa);
		decisionRepository.save(c);
		return ("votre réponse est bien enregistrée");
		}
		
	

	@Override
	public List<Decision> getDecisionsByState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDecision(Decision d, int idClaim) {
		Claim c = claimRepository.findById( idClaim).get();
		d.setDate_decision(new Date());
		d.setClaim(c);
		decisionRepository.save(d);
	}

	

}