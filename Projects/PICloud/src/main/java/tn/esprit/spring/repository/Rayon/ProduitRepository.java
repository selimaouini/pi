package tn.esprit.spring.repository.Rayon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Rayon.Produit;


@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
	@Query(value = "SELECT * FROM produit WHERE nom_produit LIKE ?1%", nativeQuery = true)
	public List<Produit> findLikeName(String string);
	
	@Query(value = "SELECT * FROM produit WHERE Idrayon =?1", nativeQuery = true)
	public List<Produit> findProduitParRayon(Long Idrayon);

	
	@Query(value = "SELECT * FROM produit WHERE id=?1", nativeQuery = true)
	public Produit findProduit(Long idProduit);
	
	@Query(value = "SELECT * FROM produit WHERE barcode LIKE ?1%", nativeQuery = true)
	public List<Produit> findProduitByBarcode(String barcode);

}
