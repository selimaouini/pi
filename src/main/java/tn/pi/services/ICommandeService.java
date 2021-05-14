package tn.pi.services;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import tn.pi.entities.Cart;
import tn.pi.entities.Command;
import tn.pi.entities.Etat;
import tn.pi.entities.ModePayement;
import tn.pi.entities.ProgrammeFidelité;
import tn.pi.entities.User;
public interface ICommandeService {
	public List<Command> getCommandes();
	  
	

	

	public Command getCommande(int idcommand);

	
	public int getMaxNumcommand() ;
	public Command findCommandByCart(int cartid);
	
	
	public List<Command >findCommandByUser(int userid);
    public void cancel(int id);
	public String  deleteCommandById(int idc);



	
	public String reductionsurcommande(int idcart);



	ResponseEntity<String> modifiercommande(Command commande);



	List<Command> findByOrderByOrderDatecreationDesc();



	public long count(Etat etat);



	List<Command> findByPayement(ModePayement payement);



	String updatestatus(Boolean validpayement, int idcmd);



	



	Command findByDateCreation(Date datecreation);



	List<Command> findAllByDateCreation(Date datecreation);



	public int generatenumcommand();







	//public void affecterCartACommand(int cartId, int commandId,int deliveryid);



	



	public Command findCommandUser(int iduser, int idc);




	public String activerprogrammefidelite(int idUser);



	public String convertir(int UserId);



	//public String paymentbyfidelite(ProgrammeFidelité FL, int cartid);



	



	List<User> getfidelités();



	public User getfedelité(int id);



	void affecterCartACommand(int cartId, int commandId);



	String paymentbyfidelite(int cartid);



	public void saveCommande(int cartId);



	public String desactiver(int idUser);



	public long Sum();





	public int getUserofmonth();





	public User bestuser();





	public User cadeau();









	public List<Command> getCommandestoday();



	






	







	
	
	
	
}
