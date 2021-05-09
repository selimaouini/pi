package tn.esprit.spring.service.Rayon;

import java.util.List;

import tn.esprit.spring.entities.Rayon.Produit;
import tn.esprit.spring.entities.Rayon.Rayon;

public interface IRayonService {
	Rayon saveRayon(Rayon rayon);

	Rayon updateRayon(Rayon rayon);

	List<Rayon> getAllRayon();

	void deleteRayonById(long Idrayon);
	public List<Rayon> findRayonbyName(String name);
	
	public void affecterProduitARayon(Long Idrayon, Long Idproduit);
	
	public void desaffecterProduitduRayon(Long Idrayon, Long Idproduit);
	
	public List<Produit> findProduitNameParRayon(Long Idrayon);

	public List<Produit> getAllProduitName();
}
