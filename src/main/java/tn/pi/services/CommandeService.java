package tn.pi.services;

import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.transaction.Transactional;
import javax.xml.bind.ParseConversionEvent;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import freemarker.template.TemplateException;

import org.hibernate.Session;
import org.slf4j.helpers.BasicMDCAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import tn.pi.entities.Cart;
import tn.pi.entities.Codepromo;
import tn.pi.entities.Command;
import tn.pi.entities.Delivery;
import tn.pi.entities.Etat;
import tn.pi.entities.EtatCart;
import tn.pi.entities.Etatfidelite;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import tn.pi.entities.ModePayement;

import tn.pi.entities.Product;
import tn.pi.entities.ProgrammeFidelité;
import tn.pi.entities.RoleType;
import tn.pi.entities.State;
import tn.pi.entities.User;
import tn.pi.repositories.ICartRepository;
import tn.pi.repositories.ICommandRepository;
import tn.pi.repositories.IDeliveryRepository;
import tn.pi.repositories.IProgramfideliteRepository;
import tn.pi.repositories.UserRepository;
import tn.pi.repositories.codepromorep;
@Service

public class CommandeService implements ICommandeService{
	@Autowired
	ICommandRepository comrep;
	@Autowired
	ICartRepository cartrep;
	@Autowired
	UserRepository userep;
	@Autowired
	IDeliveryRepository delivrep;
    @Autowired
    IProgramfideliteRepository pfrep;
    @Autowired
    codepromorep promorep;
    @Autowired
    private EmailService emailService;
   	private JavaMailSender JavaMailSender;
   	
	
	@Override
	public List<Command> getCommandes() {

		return comrep.findAll();
	}
	
	
	

	@Override
	public List<Command> getCommandestoday() {

		return comrep.commandetoday(new Date());
	}
	@Override
	public List<User> getfidelités() {

		return (List<User>) userep.findAll();
	}
	
	
	@Override
	public User getfedelité(int id) {

		return userep.findById(id).get();
	}


	
	//get order by id 
	@Override
	public Command getCommande(int idcommand) {

		return comrep.findById(idcommand).get();
	}

	//get num max of order
	@Override
	public int getMaxNumcommand() {

		return comrep.getMaxNumcommand();
	}
	
	@Override
	public void affecterCartACommand(int cartId,int commandId ) {


		//Delivery delivery=delivrep.findById(deliveryid).get();
		Command cmd = comrep.findById(commandId).get();
		
		Cart c = cartrep.findById(cartId).get();
		
		cmd.setEtat(Etat.PREPARING);
		//cmd.setCart(c);
		//cmd.setDelivery(delivery);
		cmd.setAmountCommand(c.getSubtotal());
		cmd.setDateCreation(new Date());
		cmd.setValidpayement(false);
		cmd.setNumcommand(this.generatenumcommand());
		cmd.setCurrency("TND");
		cmd.setDescription("your order is in :"+cmd.getEtat());
	 if (c.getUser().getEtat()== Etatfidelite.ACTIF) {			
				
			
		c.getUser().setNbrpoint(c.getUser().getNbrpoint()+ cmd.getAmountCommand()/1000);
				
		
	 }
		 userep.save(c.getUser());
				comrep.save(cmd);
				}
		
	
	@Override
	public String  activerprogrammefidelite (int idUser ) {

		User u =userep.findById(idUser).get();
	
			
     if (u.getEtat()== Etatfidelite.INACTIF) {			
		u.setEtatf(Etatfidelite.ACTIF);
		u.setNbrpoint(10);
		userep.save(u);
		return "Bienvenu au programme de fidélité vous avez 100 points ";
     }
	return "déja inscrit" ;

		}
	@Override
	public String  desactiver(int idUser ) {

		User u =userep.findById(idUser).get();
	
			
     if (u.getEtat()== Etatfidelite.ACTIF) {			
		u.setEtatf(Etatfidelite.INACTIF);
		u.setNbrpoint(0);
		u.setPointconverti(0);
		userep.save(u);
		return "Bienvenu au programme de fidélité vous avez 100 points ";
     }
	return "déja inscrit" ;

		}
	
	@Override 
	public String convertir(int idUser){
		User u =userep.findById(idUser).get();
	//	 if (u.getEtat()== Etatfidelite.ACTIF) {			
				
			u.setPointconverti(u.getNbrpoint()*0.8);
			u.setNbrpoint(0);
			
			userep.save(u);
						
		//     }
		return "felicitations vous avez converti" ;
	}

	
	@Transactional
		@Override
		public String paymentbyfidelite(int cartid ) {
		
			
			
			Cart c = cartrep.findById(cartid).get();
			Command cmd = new Command();
			ProgrammeFidelité FL = new ProgrammeFidelité();
			if(c.getUser().getPointconverti()>=c.getSubtotal()) {
				cmd.setPayement(ModePayement.BYFIDELITE);
				
					

					c.getUser().setPointconverti(c.getUser().getPointconverti()-c.getCommand().getPrice());
                    FL.setCommand(c.getCommand());
					
                   // cmd.setCart(c);
                    cmd.setAmountCommand(c.getSubtotal());
                    cmd.setCurrency(c.getCurrency());
                    cmd.setNumcommand(generatenumcommand());
					cmd.setEtat(Etat.ORDERED);
					cmd.setValidpayement(true);
					cmd.setDateCreation(new Date());

					comrep.save(cmd);
					userep.save(c.getUser());
					pfrep.save(FL);

					return "you pay "+" "+c.getCommand().getPrice()+" "+"by fidality";
				}

		
		return "you can't pay by fidality";
		}
	

	
	@Override
	public String deleteCommandById(int idc) {
		//Command cmd = comrep.findById(comandId).get();
		comrep.deleteById(idc);
		return "the order is deleted with succefuly";

	}
	
	
	@Transactional
	@Override
	public void saveCommande(int cartId) {
		
		int tva=18;
		Command cmd = new Command();
		Cart cart = cartrep.findById(cartId).get();
	    cmd.setAmountCommand(cart.getSubtotal());
	    cmd.setPayement(ModePayement.ENLIGNE);
		//cmd.setCart(cart);
		cmd.setNumcommand(generatenumcommand());
		cmd.setEtat(Etat.COMPLETE);
		cmd.setCurrency(cart.getCurrency());
		cmd.setDateCreation(new Date());
		cmd.setValidpayement(true);
		cmd.setDescription(" order is in :"+cmd.getEtat());
		cmd.setNomuser(cart.getUser().getFirstName()+" "+cart.getUser().getLastName());
		
		cmd.setTva(tva);
		cmd.setUser(cart.getUser());
		cmd.getUser().setNb(cmd.getUser().getNb()+1);

		if(cmd.getPayement()==ModePayement.ENLIGNE) {
			cmd.setReduction(5);
		}
		if(cmd.getAmountCommand()>=500) {
			cmd.setReduction(10);
		}
		cmd.setPrice((int) (cmd.getAmountCommand()-cmd.getReduction()));
	
		
		 if (cart.getUser().getEtat()== Etatfidelite.ACTIF) {			
				
				
				cmd.getUser().setNbrpoint(cmd.getUser().getNbrpoint()+ cmd.getAmountCommand()/1000);
						
				
			 }
		 Codepromo cp = new Codepromo();
		 cp.setCodeprom(generatecodepromo());
		 cp.setState(State.valide);
		 cp.setPromotion(cmd.getPrice()*0.05);
		 
			cmd.getUser().setNbrpoint(cmd.getUser().getNbrpoint()+ 5000);
		 promorep.save(cp);	
		 comrep.save(cmd);
			userep.save(cart.getUser());
			// You may want to store charge id along with order information
			 try {
				try {
					emailService.sendMailMultipart(cmd.getUser().getEmail(), " félicitations");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TemplateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			 
	     String s= "+216" + String.valueOf(cmd.getUser().getTel());
		sendSms(s, "+12067853390" , "Your order has been confirmed , Your Promo code is" + cp.getCodeprom() +" this code is available only one time" );
	
				
				
				
				
						
				
		
		

		
	}


	public int generatecodepromo() {
		return UUID.randomUUID().hashCode();
	}


public void sendSms(String to,String from,String body) {
	
	try {
	 Twilio.init("AC97e41d3e8b79b440d26a39ce19f53f30", "dbc0d30b1911a2235813732b6cf03ef8");
        Message message = Message.creator( new PhoneNumber(to), new PhoneNumber(from),body) // to:to which no  you want to send sms           
            //.setMediaUrl(Arrays.asList(URI.create("https://demo.twilio.com/owl.png")))     // from: twillio given phone no
            .setStatusCallback(URI.create("http://postb.in/1234abcd"))                      // body : text message
            .create();


	}catch(Exception e) {
		
		e.printStackTrace();
		
	}
	
}



	@Override
	public ResponseEntity<String> modifiercommande(Command commande) {


	
		Command savedc=comrep.save(commande);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedc.getIdcommand()).toUri();



		return ResponseEntity.ok("Order is successfully modified") ;
	}
	@Transactional
	public void cancel( int id) {
		Command order = comrep.findById(id).get();
		

		order.setEtat(Etat.CANCELED);
		comrep.save(order);

	}
	@Override
	public String reductionsurcommande(int idcart) {
		Cart c = cartrep.findById(idcart).get();
		
		if(c.getCommand().getPayement()==ModePayement.ENLIGNE) {
			c.getCommand().setReduction(5);
		}
		if(c.getCommand().getAmountCommand()>=500) {
			c.getCommand().setReduction(10);
		}
		c.getCommand().setPrice((int) (c.getCommand().getAmountCommand()-c.getCommand().getReduction()));
		comrep.save(c.getCommand());
		return "you can benefit from reduction";
	}

	



	@Override
	public String updatestatus( Boolean validpayement,int idcmd) {

		Command cmd = comrep.findById(idcmd).get();
		if(validpayement==true) {
			cmd.setEtat(Etat.ORDERED);
			comrep.save(cmd);
			return "the order is validated";
		}
		else if(validpayement==false)
		{
			cmd.setEtat(Etat.COMPLETE);
			comrep.save(cmd);
			return "the order is complete ";
		}
		return "";

	}


@Override
public int getUserofmonth(){
return comrep.getclient();

}

@Override
public User  bestuser(){
	
return comrep.bestuser(getUserofmonth());

}

@Override
public User  cadeau(){
	
  int id = bestuser().getIdUser();
  User u = userep.findById(id).get();
  u.setPointconverti(u.getPointconverti()+100);  
  userep.save(u);
  String s= "+216"+ u.getTel();
	sendSms(s, "+12067853390" , "Félicications vous étes le meilleur client de ce mois vous avez un bon d'achat de 100 dinars ");
  
return u;
  
	


}
	
	


	public int generatenumcommand() {
		return UUID.randomUUID().hashCode();
	}

	





	@Override
	public Command findCommandByCart(int cartid) {
		return comrep.findCommandByCart(cartid);
	}



	@Override
	public List<Command> findCommandByUser(int userid) {
		User x=userep.findById(userid).get();
	return comrep.getAllCommandByUser(x);
	}



	


	@Override
	public List<Command> findByOrderByOrderDatecreationDesc() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public long count(Etat etat) {
		return comrep.count(etat);
	}
	
	@Override
	public long Sum() {
		return comrep.sum(new Date());
	}



	@Override
	public List<Command> findByPayement(ModePayement payement) {
		return comrep.findByPayement(payement);
	}



	@Override
	public Command findByDateCreation(Date datecreation) {
		return comrep.findByDateCreation(datecreation);
	}



	@Override
	public List<Command> findAllByDateCreation(Date datecreation) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Command findCommandUser(int iduser, int idc) {
		
		Command cmd = comrep.findById(idc).get();
		List<User>users=new ArrayList<>();
		users.add(cmd.getUser());
		for(User u:users) {
		cmd= comrep.getOne(idc);
	}
	
return cmd;
	}





	


	




	
}

