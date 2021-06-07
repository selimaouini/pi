package tn.pi.services;

import java.util.Date;
import java.util.List;

import tn.pi.entities.Cart;
import tn.pi.entities.Demandestock;
import tn.pi.entities.Product;
import tn.pi.entities.Stock;




public interface IdemandestockService {

	
	public String validerdemande(int demandeID);

	public String deletedemande(int demId);

	public List<Demandestock> getdemande();

	public Demandestock DemanderStock(Demandestock ds);

	public Demandestock Demand();

	public String refuserdemande(int demandeID);

	public int nbdemande();



	




	

	
}
