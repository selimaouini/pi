package tn.pi.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.PrimeFaces;
import org.primefaces.component.export.ExcelOptions;
import org.primefaces.component.export.PDFOptions;
import org.primefaces.component.export.PDFOrientationType;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import tn.pi.entities.Cart;
import tn.pi.entities.DeliveryMan;
import tn.pi.entities.Demandestock;
import tn.pi.entities.Etatdemande;
import tn.pi.entities.LigneComand;
//import tn.esprit.spring.entities.Employe;
import tn.pi.entities.Product;
import tn.pi.entities.User;
import tn.pi.entities.catalog;
import tn.pi.repositories.ILigneCommandeRepository;
import tn.pi.repositories.IProductRepository;
import tn.pi.repositories.catalogrepository;
import tn.pi.services.ILigneCommandeService;
import tn.pi.services.ProductService;
import tn.pi.services.catalogservice;


@Controller(value = "catalogcontroller")
@ELBeanName(value = "catalogcontroller")
//@Join(path = "/", to = "/Product.jsf")

public class catalogcontroller {
@Autowired
ProductService ProductService;
@Autowired
ILigneCommandeService ls;
@Autowired
ILigneCommandeRepository lcrep;
@Autowired 
catalogcontroller cc;
@Autowired
IProductRepository PR;
@Autowired 
catalogservice cs;
@Autowired
catalogrepository catarep;

private UploadedFile image;
private int id;
private String name;
private String pic;
private float price;
private String barCode;
private int  stock;
public int getId() {
	return id;
}


private int IdToUpdate;

public int getIdToUpdate() {
	return IdToUpdate;
}




















public void setIdToUpdate(int idToUpdate) {
	IdToUpdate = idToUpdate;
}




















public UploadedFile getImage() {
	return image;
}




















public void setImage(UploadedFile image) {
	this.image = image;
}



public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPic() {
	return pic;
}
public void setPic(String pic) {
	this.pic = pic;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getBarCode() {
	return barCode;
}
public void setBarCode(String barCode) {
	this.barCode = barCode;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}


private List<catalog> cat;

public List<catalog> getCat() {
	cat= cs.getcatalogs();
	return cat;
}
public void setCat(List<catalog> cat) {
	this.cat = cat;
}



public void SaveImage(InputStream inputStream, File ImageFile) throws IOException {
    OutputStream outputStream=new FileOutputStream(ImageFile);
    IOUtils.copy(inputStream, outputStream);
}
public catalog proposer() throws IOException{
	
	catalog dst = new catalog();
	
	
	
    
	dst.setName(name);
	dst.setBarCode(barCode);
	dst.setPrice(price);
	dst.setStock(stock);
	// dst.setImage(image.getFileName());

	  cs.addProduct(dst);
	return cs.addProduct(dst);
	

}
	public String delete(int id)
	{ 
		cs.deletecatalogById(id);
		return null ;
	}
	public Demandestock demander(int id)
	{  
		cs.DemanderStock(id);
		return cs.DemanderStock(id);
	}
	
	 public void display(catalog cat){
			 
			this.setName(name);
			this.setBarCode(barCode);
			this.setPrice(price);
			this.setStock(stock);
			this.setIdToUpdate(cat.getId());
			
			}
		 
		 public String select(int id){ 
			catalog  cat = catarep.findById(id).get();
			display(cat);
		 	return "/pages/admin/updatecatalog.xhtml?faces-redirect=true";
		 }	
		 

		 public void updatecatalog(){
			 cs.addProduct(new catalog(IdToUpdate,name,barCode,price,stock));
		   
			 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", "CATALOG UPDATED");
				PrimeFaces.current().dialog().showMessageDynamic(message);} 

}
