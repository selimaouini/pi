package tn.pi.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.pi.entities.Decision;
import tn.pi.services.decisionServices;

@RestController
public class DecisionRestController {

	@Autowired
	decisionServices decisionServices;
	
	
	@GetMapping("/retrieveAllDecisions")
	@ResponseBody
	public List<Decision> retrieveAllDecisions() {
	List<Decision> list = decisionServices.retrieveAllDecisions();
	return list; 
	}
	
	
	
	@PostMapping("/affecterDecisionAClaim/{idDecision}/{idClaim}")
	@ResponseBody
	public void affecterDecisionAClaim(@PathVariable("idDecision")int idDecision, @PathVariable("idClaim")int idClaim) {
		decisionServices.affecterDecisionAClaim(idDecision, idClaim);
	}
	
	
	
	@PutMapping("/acceptDecision/{idDecision}")
	@ResponseBody
	public String acceptDecision(@PathVariable("idDecision") int id) {
		decisionServices.acceptDecision(id);
		return decisionServices.acceptDecision(id);
	}
	
	
	
	@DeleteMapping("/deleteDecision/{idDecision}")
	@ResponseBody
	public void deleteDecision(@PathVariable("idDecision") int id) {
		decisionServices.deleteDecision(id);
	}
	
	
	@PutMapping("/updateDecision")
	@ResponseBody
	public Decision updateDecision(@RequestBody Decision c) {
	return decisionServices.updateDecision(c);
	}
	
	
	@PostMapping("/addDecision/{idClaim}")
	@ResponseBody
	public void addDecision(@RequestBody Decision d, @PathVariable("idClaim")int idClaim) {
		decisionServices.addDecision(d, idClaim);
	}
	
	
}
