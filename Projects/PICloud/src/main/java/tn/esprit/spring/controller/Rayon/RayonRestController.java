package tn.esprit.spring.controller.Rayon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Rayon.Produit;
import tn.esprit.spring.entities.Rayon.Rayon;
import tn.esprit.spring.service.Rayon.IRayonService;



@RestController
@RequestMapping("/rayon")
public class RayonRestController {
	
	@Autowired
	IRayonService rayonDAO;
	
	////////////////////////////////////////////////////////////////////////

	@PostMapping("/addrayon")
	@ResponseBody
	public Rayon addrayon(@RequestBody Rayon rayon) {
		return rayonDAO.saveRayon(rayon);

	}

	////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/allrayon")
	public List<Rayon> getAllRayon() {
		return rayonDAO.getAllRayon();
	}
	///////////////////////////////////////////////////////////////////////////

	@PutMapping("/editrayon")
	@ResponseBody
	public Rayon editrayon(@RequestBody Rayon rayon) {
		return rayonDAO.updateRayon(rayon);
	}

	////////////////////////////////////////////////////////////////////////////////

	@DeleteMapping("/deleterayon/{Idrayon}")
	public void deleterayon(@PathVariable(name ="Idrayon") Long Idrayon) {

		rayonDAO.deleteRayonById(Idrayon);

	}

	//////////////////////////////////////////////////////////////////////////////

	@GetMapping("/rechercherayon/{nomr}")
	public List<Rayon> rechercherayon(@PathVariable(value = "nomr") String name) {
		return rayonDAO.findRayonbyName(name);
	}
	
	@GetMapping("/findproduitparrayon/{idr}")
	public List<Produit> findProduitNameParRayon(@PathVariable(value = "idr") Long Idrayon) {
		return rayonDAO.findProduitNameParRayon(Idrayon);
	}
	

	//////////////////////////////////////////////////////////////////////////////////////////////
	@PutMapping("/affecterProduitARayon/{Idr}/{Idp}")
	public void affecterProduitARayon(@PathVariable(value = "Idr") Long Idrayon,
			@PathVariable(value = "Idp") Long Idproduit) {

		rayonDAO.affecterProduitARayon(Idrayon, Idproduit);
	}
	/////////////////////////////////////////////////////
	@GetMapping(value="/allprodname")
	public List<Produit> getAllProduitName() {
		return rayonDAO.getAllProduitName();
	}


	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@PutMapping("/desaffecterProduitARayon/{Idr}/{Idp}")
	public void desaffecterProduitARayon(@PathVariable(value = "Idr") Long Idrayon,
			@PathVariable(value = "Idp") Long Idproduit) {

		rayonDAO.desaffecterProduitduRayon(Idrayon, Idproduit);
	}
	
	

}
