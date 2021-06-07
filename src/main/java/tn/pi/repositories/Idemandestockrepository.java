package tn.pi.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.pi.entities.Ads;
import tn.pi.entities.Bill;
import tn.pi.entities.Cart;
import tn.pi.entities.Demandestock;
import tn.pi.entities.Etatdemande;
import tn.pi.entities.ModePayement;
import tn.pi.entities.Product;
import tn.pi.entities.TypeFacture;
import tn.pi.entities.User;


@Repository
public interface Idemandestockrepository extends JpaRepository<Demandestock, Integer>{
	@Query("select count(c) from Demandestock c where c.etatdemande=:y ")
	public int countt(@Param("y")Etatdemande etatdemande);
}
