package tn.pi.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.pi.entities.Bill;
import tn.pi.entities.Cart;
import tn.pi.entities.Command;
import tn.pi.entities.Demandestock;
import tn.pi.entities.Etat;
import tn.pi.entities.EtatCart;
import tn.pi.entities.Etatdemande;
import tn.pi.entities.LigneComand;
import tn.pi.entities.Product;
import tn.pi.entities.Stock;
import tn.pi.entities.TypeFacture;
import tn.pi.entities.User;
import tn.pi.repositories.IBillRepository;
import tn.pi.repositories.ICartRepository;
import tn.pi.repositories.ICommandRepository;
import tn.pi.repositories.ILigneCommandeRepository;
import tn.pi.repositories.IProductRepository;
import tn.pi.repositories.IStockRepository;
import tn.pi.repositories.Idemandestockrepository;
import tn.pi.repositories.UserRepository;
@Service
public  class DemandestockService implements IdemandestockService{
	@Autowired 
	Idemandestockrepository demrep;
	@Autowired
	IStockRepository stockrep;
	@Autowired IStockService ss;
	
	
	@Override
	public String deletedemande(int demId) {
		
		demrep.deleteById( demId);
		return "the stock is deleted successfully";
		
	}

	@Override
	public List<Demandestock> getdemande() {
	
		return demrep.findAll();
	}
	@Override
	public String validerdemande(int demandeID ) {
	
	    
		Demandestock ds = demrep.findById(demandeID).get();
	if (ds.getEtatdemande()!=Etatdemande.Validé){
		ds.setEtatdemande(Etatdemande.Validé);
		ds.getStock().setQuantity(ds.getStock().getQuantity()+ds.getQuantity());
		demrep.save(ds);
		stockrep.save(ds.getStock());
		return "validé"; }
	return null;
		
		
	}
	
	
	@Override
	public String refuserdemande(int demandeID ) {
	
	    
		Demandestock ds = demrep.findById(demandeID).get();
	if (ds.getEtatdemande()==Etatdemande.encours){
		ds.setEtatdemande(Etatdemande.refusé);
		
		demrep.save(ds);
		
		return "refusé"; }
	return null;
		
		
	}
	
	@Transactional
	@Override
	@Scheduled(cron="* 30 * * * ?")
	public Demandestock Demand() {
		
	Stock stock =  ss.getepuisé();
	 if (stock !=null) {
		 Demandestock ds = new Demandestock();
			ds.setQuantity(20);
	  		ds.setDateCreation(new Date());
			ds.setStock(stock);
			ds.setNomp(ds.getStock().getProducts().getProductName());
			ds.setEtatdemande(Etatdemande.encours);
			demrep.save(ds); 
		 
			return ds; }
	return null ;
			
		}
	
	

	
	@Transactional
	@Override
	public Demandestock DemanderStock(Demandestock ds) {
	Stock stock =  ss.getepuisé();
	 if (stock !=null) {
			
	  		ds.setDateCreation(new Date());
			ds.setStock(stock);
			ds.setNomp(ds.getStock().getProducts().getProductName());
			ds.setEtatdemande(Etatdemande.encours);
			demrep.save(ds); }
		 
			return ds;
			
		}
	
	}

	


	
	
	
	
