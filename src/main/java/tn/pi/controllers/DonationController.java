package tn.pi.controllers;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import tn.pi.entities.Donation;
import tn.pi.services.IDonationService;
import tn.pi.services.IEventService;

@Scope(value = "session")
@Component(value = "donationController")
@ELBeanName(value = "donationController")
@Join(path = "/donationForm", to = "/donation-form.jsf")
public class DonationController implements IDonationController{
	@Autowired
	IDonationService iDonationService;
	IEventService iEventService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	SimpleMailMessage msg = new SimpleMailMessage();
    
	@Override
	public String save() {
		
		String mailAdress="amir.ibenabdellah@esprit.tn";
 		MimeMessage message = javaMailSender.createMimeMessage();
 	    try {
 	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
 	        helper.setFrom("amirbenabdallah97@gmail.com");
 	        helper.setTo(mailAdress);
 	        helper.setSubject("Donation");
 	        helper.setText("Cher client, \n \n"
 	        		+ "Nous voulons vous vous remercier pour votre donation. Voici les détails pour confirmer: \n"
 	        		+"\t Montant: "+iDonationService.getDonation().getAmount()+"\n"
 	        		+"\t Nom Evenement: " + iDonationService.getDonation().getName_event()+"\n"
 	        		+"\t Date: "+ iDonationService.getDonation().getDate()+"\n\n"
 	        		+"vous pouvez nous suivre sur notre platform 'Consommi Tounsi' pour plus de visibilité sur l'évévenement.\n"
 	        		+"Merci pour votre soutien\n\n"
 	        		+"equipe Consommi Tounsi"
 	        		);
 	        
 	        	        
 	        javaMailSender.send(message);
 	    } catch (MessagingException  e) {

 	        e.printStackTrace();
 	    }
		return iDonationService.save() ;
	}

	@Override
	public Donation getDonation() {
		// TODO Auto-generated method stub
		return iDonationService.getDonation();
	}

	@Override
	public String delete(int id) {
		String mailAdress="amir.ibenabdellah@esprit.tn";
 		MimeMessage message = javaMailSender.createMimeMessage();
 	    try {
 	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
 	        helper.setFrom("amirbenabdallah97@gmail.com");
 	        helper.setTo(mailAdress);
 	        helper.setSubject(" Delete Donation");
 	        helper.setText("Cher client, \n \n"
 	        		+ "Nous voulons vous confirmer la supression de votre donation. voici les détails de donation: \n"
 	        		+"\t Montant: "+iDonationService.getDonationById(id).getAmount()+"\n"
 	        		+"\t Nom Evenement: " + iDonationService.getDonationById(id).getName_event()+"\n"
 	        		+"\t Date: "+ iDonationService.getDonationById(id).getDate()+"\n\n"
 	        		+"vous pouvez nous suivre sur notre platform 'Consommi Tounsi' pour plus de visibilité sur l'évévenement.\n"
 	        		+"Merci pour votre soutien\n\n"
 	        		+"equipe Consommi Tounsi"
 	        		);
 	        
 	        	        
 	        javaMailSender.send(message);
 	    } catch (MessagingException  e) {

 	        e.printStackTrace();
 	    }
		return iDonationService.delete(id);
	}

	@Override
	public String modifier(Donation d, String amount, Date date, String name_event) {
		// TODO Auto-generated method stub
		return iDonationService.modifier(d, d.getAmount(), d.getDate(), d.getName_event());
	}

	@Override
	public String saveModif() {
		String mailAdress="amir.ibenabdellah@esprit.tn";
 		MimeMessage message = javaMailSender.createMimeMessage();
 	    try {
 	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
 	        helper.setFrom("amirbenabdallah97@gmail.com");
 	        helper.setTo(mailAdress);
 	        helper.setSubject("update Donation");
 	        helper.setText("Cher client, \n \n"
 	        		+ "Nous voulons vous vous informer concernant les modification. Voici les nouveaux détails pour confirmer: \n"
 	        		+"\t Montant: "+iDonationService.getDonation().getAmount()+"\n"
 	        		+"\t Nom Evenement: " + iDonationService.getDonation().getName_event()+"\n"
 	        		+"\t Date: "+ iDonationService.getDonation().getDate()+"\n\n"
 	        		+"vous pouvez nous suivre sur notre platform 'Consommi Tounsi' pour plus de visibilité sur l'évévenement.\n"
 	        		+"Merci pour votre soutien\n\n"
 	        		+"equipe Consommi Tounsi"
 	        		);
 	        
 	        	        
 	        javaMailSender.send(message);
 	    } catch (MessagingException  e) {

 	        e.printStackTrace();
 	    }
		return iDonationService.saveModif();
	}

}
