package tn.esprit.spring.service.Rayon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Rayon.Produit;
import tn.esprit.spring.entities.Rayon.Rayon;
import tn.esprit.spring.repository.Rayon.ProduitRepository;
import tn.esprit.spring.repository.Rayon.RayonRepository;

@Service
public class RayonServiceImpl implements IRayonService {

	@Autowired
	RayonRepository rayonRepository;
	@Autowired
	ProduitRepository produitRepository;

	@Override
	public Rayon saveRayon(Rayon rayon) {
		return rayonRepository.save(rayon);
	}
	
	
	@Override
	public Rayon updateRayon(Rayon rayon) {
		return rayonRepository.saveAndFlush(rayon);

	}

	@Override
	public List<Rayon> getAllRayon() {

		return rayonRepository.findAll();
	}
    @Transactional
	@Override
	public void deleteRayonById(long Idrayon) {
    	
		rayonRepository.deleteById(Idrayon);;

	}

	@Override
	public List<Rayon> findRayonbyName(String name) {
		return rayonRepository.findRayonbyName(name);
	}

	
	public List<Rayon> findRayonbyName1(String name) {
		return rayonRepository.findRayonbyName(name);
	}
	
	@Override
	public void affecterProduitARayon(Long Idrayon, Long Idproduit) {
		Rayon rayon = rayonRepository.findById(Idrayon).get();
		Produit produit = produitRepository.findById(Idproduit).get();
		
		
		produit.setIdrayon(rayon);
		produitRepository.save(produit);

		
	}

	
	
	public void desaffecterProduitduRayon(Long Idrayon, Long Idproduit) {
		Rayon rayon = rayonRepository.findById(Idrayon).get();
		
		int nbp=rayon.getProduits().size();
		for(int index = 0; index < nbp; index++){
			if(rayon.getProduits().get(index).getId() == Idproduit){
				rayon.getProduits().remove(index);
				
			}
		
	}
}

	@Override
	public List<Produit> findProduitNameParRayon(Long Idrayon) {
		
		return produitRepository.findProduitParRayon(Idrayon);
	}

	@Override
	public List<Produit> getAllProduitName() {
		
		return produitRepository.findAll();
	}

	




}