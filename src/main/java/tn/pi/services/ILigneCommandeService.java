package tn.pi.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.pi.entities.Command;
import tn.pi.entities.Etat;
import tn.pi.entities.LigneComand;
import tn.pi.entities.Product;
import tn.pi.repositories.ILigneCommandeRepository;

public interface ILigneCommandeService  {

	String affecterProductAlc(int productId, int cartId, int quantity);



	public List<LigneComand> findLigneCommandByUser(int userid);

	public LigneComand getbyid(int lcid);

	public List<LigneComand> getall();



	public String affecterpanier(int lcId);



	public LigneComand incrementer(int lcid);



	public LigneComand decrementer(int lcid);



	public LigneComand delete(int lcid);



	public int count(int cartid);



	public String affecterpromo(int cartid, int codepromo);





	//LigneComand supprimerLignecommande(Product p);



}