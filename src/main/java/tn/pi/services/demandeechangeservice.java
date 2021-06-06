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
import tn.pi.entities.Demandechange;
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
import tn.pi.repositories.ProductRepository;
import tn.pi.repositories.UserRepository;
import tn.pi.repositories.demechangerep;
@Service
public  class demandeechangeservice implements Idemservice{
	@Autowired 
	demechangerep demrep;
	@Autowired
	IStockRepository stockrep;
	@Autowired IStockService ss;
	@Autowired
	ProductRepository pr;
	
	
	@Override
	public String deletedemande(int demId) {
		
		demrep.deleteById( demId);
		return "the stock is deleted successfully";
		
	}

	@Override
	public List<Demandechange> getdemande() {
	
		return (List<Demandechange>) demrep.findAll();
	}
	@Override
	@Transactional
	public String validerdemande(int id ) {
	
	    
		Demandechange ds = demrep.findById(id).get();
   
    	
    	ds.setEtatdemande(Etatdemande.Validé);
    	
    demrep.save(ds);
  return null;
		
	}
	
	
	@Override
	public String refuserdemande(int id) {
	
	    
		Demandechange ds = demrep.findById(id).get();
	
		ds.setEtatdemande(Etatdemande.refusé);
		
		demrep.save(ds);
		return null;
		
	}
		
		
	

	
	}

	


	
	
	
	
