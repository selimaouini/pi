package tn.pi.restControllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.pi.entities.Bill;
import tn.pi.entities.Demandestock;
import tn.pi.entities.Product;
import tn.pi.entities.Stock;
import tn.pi.entities.TypeFacture;
import tn.pi.repositories.Idemandestockrepository;
import tn.pi.services.IBillService;
import tn.pi.services.IdemandestockService;

@RestController
public class RestControllerdemandestock {
@Autowired
Idemandestockrepository demrep;
@Autowired
IdemandestockService demserv;


@PostMapping(value = "/demander")
public Demandestock DemanderStock( @RequestBody Demandestock demstock ) {
	return demserv.DemanderStock(demstock);
	}

@PostMapping(value = "/Valider/{ids}")
public String validerdemande(@PathVariable("ids") int demandeID) {
	return demserv.validerdemande(demandeID);
	}
@GetMapping("/dem")
@ResponseBody
public  List<Demandestock> getdemande()  {
	return demserv.getdemande();
}
}



