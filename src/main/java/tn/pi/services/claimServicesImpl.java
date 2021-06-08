package tn.pi.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freemarker.template.TemplateException;
import tn.pi.repositories.UserRepository;
import tn.pi.repositories.claimRepository;
import tn.pi.repositories.decisionRepository;
import tn.pi.repositories.deliveryRepository;
import tn.pi.entities.Claim;
import tn.pi.entities.Decision;
import tn.pi.entities.Delivery;
import tn.pi.entities.DeliveryState;
import tn.pi.entities.User;


@Service
public class claimServicesImpl implements claimServices  {
	
	@Autowired
    claimRepository claimRepository;
	@Autowired
    UserRepository UserRepository;
	@Autowired
	deliveryRepository deliveryRepository;
	@Autowired
	EmailService EmailService;
	@Autowired
    decisionRepository decisionRepository;
	
	
	
	@Override
	
	public List<Claim> retrieveAllClaims() {
		claimRepository.findAll();
		return (List<Claim>)claimRepository.findAll();
	}
	
	
	@Override
	public Claim updateClaim(Claim d) {
		claimRepository.save(d);
		return d;
	}
	@Override
	public Claim retrieveClaim(int id_claim) {
		claimRepository.findById(id_claim);
		return claimRepository.findById(id_claim).orElse(null);
	}

	

	@Override
	public void deleteClaim(int id) {
	claimRepository.deleteById(id);
			
		
	}


	


	@Override
	public List<Claim> getClaimsByUser() {
		int id = 1;
		return claimRepository.getClaimsByUser(id);
	}


	@Override
	public List<Claim> getClaimsByState() {
		return claimRepository.findByStateFalse();
		
	}


	@Override
	public void acceptClaim(int id) {
		Claim c = claimRepository.findById(id).get();
		c.setState(true);

		int idaa = c.getUser().getIdUser();
		User aa = UserRepository.findById(idaa).get();
		
			try {
				EmailService.sendMail(c.getUser().getEmail(), " Reclamation Recu", "votre réclamation a été bien prise en compte, vous devez accepter notre suggestion avant 24h de ce mail.Merci pour votre confiance ");
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
		
			UserRepository.save(aa);
			claimRepository.save(c);
			 String ref=aa.getFirstName();
			
		}
		
	
		


	
	
	


	@Override
	public void acceptClaimAddDecision(int id, Decision d) {
		Claim c = claimRepository.findById( id).get();
		c.setState(true);
		d.setDate_decision(new Date());
		d.setClaim(c);
		decisionRepository.save(d);
		   
			try {
				EmailService.sendMail(c.getUser().getEmail(), " Reclamation Recu", "votre réclamation a été bien prise en compte, vous devez accepter notre suggestion avant 24h de ce mail.Merci pour votre confiance ");
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
	
	
	
	@Override
	public String addClaimByUserAndDelivery(int idUser, int idDelivery, Claim d) {
		User u=UserRepository.findById(idUser).get();
		Delivery dev=deliveryRepository.findById( idDelivery).get();
		if(dev.getState()!=DeliveryState.DELIVERED){
			return("Vous n'avez pas le droit à réclammer pour cette livraison");
		}
		else{
		Claim c = new Claim();
		c.setUser(u);
		c.setDate(new Date());
		c.setState(false);
		claimRepository.save(c);
		return ("votre réponse est bien enregistrée");
		}
	}


	@Override
	public String updateDescriptionComplaint(String description, int id) {
		Claim c=claimRepository.findById(id).get();
		if(c.getState()==true){
		return("Vous ne pouvez pas changer votre réclamation");
		}
		else{
		c.setDescription(description);
		claimRepository.save(c);
		return ("Changement réussi");
		}
	
	}
	@Override
	public void addClaim(int iduser, Claim comp) {
		User u=UserRepository.findById( iduser).get();
		Claim c = new Claim();
		c.setUser(u);
		c.setDate(new Date());
		c.setState(false);
		claimRepository.save(c);
	}


	@Override
	public String verifierClaim() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addClaimss(Claim cl) {
		cl.setDate(new Date());
		cl.setState(false);
		claimRepository.save(cl);
		
	}

}


		


	
	
