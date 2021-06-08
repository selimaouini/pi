package tn.pi.services;

import java.util.List;

import tn.pi.entities.Demandechange;
import tn.pi.entities.catalog;

public interface Idemservice {

	String deletedemande(int demId);

	List<Demandechange> getdemande();

	String validerdemande(int id);

	public String refuserdemande(int demandeID);

	

	public catalog Catalog(String name);

}
