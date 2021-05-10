package tn.pi.restControllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.pi.entities.Claim;
import tn.pi.entities.Decision;
import tn.pi.services.EmailService;
import tn.pi.services.claimServices;


@RestController
public class ClaimRestController {
	
	@Autowired
	claimServices claimServices;
	@Autowired
	EmailService EmailService;
	
	

		
		@GetMapping("/ClaimsStateFalse")
		public List<Claim> afficherComplaint() {
			return claimServices.getClaimsByState();
		}

		
			@GetMapping("/retrieve-all-claims")
			@ResponseBody
			public List<Claim> retrieveAllClaims() {
			List<Claim> list = claimServices.retrieveAllClaims();
			return list; 
			}
			

		
			@DeleteMapping("/deleteClaim/{id}")
			@ResponseBody
			public void deleteClaim(@PathVariable("id") int id) {
				claimServices.deleteClaim(id);
			}
			
			
			@PutMapping("/updateClaim")
			@ResponseBody
			public Claim updateDeliveryMan(@RequestBody Claim c) {
			return claimServices.updateClaim(c);
			}
			
			
			
			@PutMapping("/acceptComplaint/{id}")
			@ResponseBody
			public ResponseEntity<String> acceptComplaint(@PathVariable("id") int id) {
				claimServices.acceptClaim(id);
				return new ResponseEntity<>("Réclamation a été acceptée.", HttpStatus.OK);
			}
			
			
			@PutMapping("/updateComplaint/{id}/{description}")
			@ResponseBody
			public String updateDescriptionComplaint(@PathVariable("id") int id, @PathVariable("description") String description) {
				claimServices.updateDescriptionComplaint(description, id);
			return claimServices.updateDescriptionComplaint(description, id);
			}
			
			
			@PostMapping("/acceptClaimAddDecision/{id}")
			public ResponseEntity<String> acceptClaimAddDecision(@PathVariable("id") int id,@RequestBody Decision d ) {
				claimServices.acceptClaimAddDecision(id,d);
				return new ResponseEntity<>("Successful add", HttpStatus.CREATED);
			}
			
			@PostMapping("/addClaim/{id_user}")
			public String addClaim(@PathVariable("id_user") int id_user,@RequestBody Claim C) {
				claimServices.addClaim(id_user,C);
				return ("Successful add");
			}
			
			
			@PostMapping("/addClaimByUserAndDelivery/{id_user}/{id_delivery}")
			public String addClaimByUserAndDelivery(@PathVariable("id_user") int iduser,@PathVariable("id_delivery") int id_delivery,@RequestBody Claim C) {
				claimServices.addClaimByUserAndDelivery(iduser,id_delivery,C);
				return claimServices.addClaimByUserAndDelivery(iduser,id_delivery,C);
			}
			
	}

