package tn.pi.services;

import java.util.List;

import tn.pi.entities.Demandestock;
import tn.pi.entities.catalog;

public interface Icatalogservice {

	

public 	catalog addProduct(catalog catalog);

	public Demandestock DemanderStock(int idcatalog);

	public List<catalog> getcatalogs();

	public void deletecatalogById(int catalogId);

}
