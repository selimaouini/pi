package tn.pi.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.entities.Cart;
import tn.pi.entities.Demandestock;
import tn.pi.entities.Etatdemande;
import tn.pi.entities.LigneComand;
import tn.pi.entities.Stock;
import tn.pi.entities.catalog;
import tn.pi.repositories.Idemandestockrepository;
import tn.pi.repositories.catalogrepository;
@Service 
public class catalogservice implements Icatalogservice{
	@Autowired
	catalogrepository categrep;
	@Autowired
	Idemandestockrepository demrep;
	
	@Transactional
	@Override
	public catalog addProduct(catalog catalog) {
		categrep.save(catalog);
				return categrep.save(catalog);
			
	}

	@Override
	public void deletecatalogById(int catalogId) {
	
	categrep.deleteById(catalogId);}
	
	@Transactional
	@Override
	public Demandestock DemanderStock(int idcatalog) {
			catalog catalog = categrep.findById(idcatalog).get();
			Demandestock ds = new Demandestock();
	  		ds.setDateCreation(new Date());
	  		ds.setCatalog(catalog);
	  		ds.setQuantity(30);
	  		ds.setNomp(catalog.getName());
		    ds.setEtatdemande(Etatdemande.encours);
	        demrep.save(ds); 
		 
			return ds;
			
		}


	@Override
	public List<catalog> getcatalogs() {
	categrep.findAll();
		return categrep.findAll();
	}
	

}
