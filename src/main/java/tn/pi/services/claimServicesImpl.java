package tn.pi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pi.repositories.claimRepository;
import tn.pi.entities.Claim;


@Service
public class claimServicesImpl implements claimServices  {
	
	@Autowired
    claimRepository claimRepository;

	
	public List<Claim> retrieveAllClaims() {
		claimRepository.findAll();
		return (List<Claim>)claimRepository.findAll();
	}

	public Claim addClaim(Claim c) {
		claimRepository.save(c);
		return c;
	}

	public void deleteClaim(String id) {
		claimRepository.deleteById(Long.parseLong(id));
		
	}

	public Claim updateClaim(Claim d) {
		claimRepository.save(d);
		return d;
	}

	public Claim retrieveClaim(String id_claim) {
		claimRepository.findById(Long.parseLong(id_claim));
		return claimRepository.findById(Long.parseLong(id_claim)).orElse(null);
	}

}
