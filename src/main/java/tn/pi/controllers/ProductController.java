package tn.pi.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.apache.commons.io.IOUtils;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RateEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tn.pi.entities.Category;
//import tn.esprit.spring.entities.Employe;
import tn.pi.entities.Product;
import tn.pi.entities.Rating;
import tn.pi.entities.User;
import tn.pi.repositories.CategoryRepository;
import tn.pi.repositories.ProductRepository;
import tn.pi.services.ProductService;
import tn.pi.services.AdsViewService;
import tn.pi.services.IRatingService;
import tn.pi.repositories.RatingRepository;

@Controller(value = "ProductController")
@ELBeanName(value = "ProductController")
//@Join(path = "/", to = "/Product.jsf")

public class ProductController {
@Autowired
ProductService ProductService;
@Autowired
AdsViewService AdsViewService;
@Autowired
CategoryRepository CategoryRepository;
@Autowired
ProductRepository ProductRepository;
@Autowired
RatingRepository RatingRepository;
@Autowired
IRatingService RatingService;
@Autowired 
UserController uc;
private String productName;
@Size(max = 250)
@Column(name = "picture")
private String picture;
private int idPromotion;
private String description;
@Temporal(TemporalType.DATE)
private Date dateexpiration;
private float price;
private float pricepromotion;
private String barCode;
@Temporal(TemporalType.DATE)
private Date createdAt;
private int mostViewed;
private List<Product> product;
private List<Product> productboissons;
private Category category;
private boolean promotionEtat;
private int idrating;
private int nbretoile;
private String categ;



public String getCateg() {
	return categ;
}

public void setCateg(String categ) {
	this.categ = categ;
}

public List<Product> getProductboissons() {
	productboissons =ProductService.filterProductByCategory("Boissons");
	
	return productboissons;
}

public void setProductboissons(List<Product> productboissons) {
	this.productboissons = productboissons;
}

public int getIdrating() {
	return idrating;
}

public void setIdrating(int idrating) {
	this.idrating = idrating;
}

public int getNbretoile() {
	return nbretoile;
}

public void setNbretoile(int nbretoile) {
	this.nbretoile = nbretoile;
}

public String getPicture() {
	return picture;
}
public void setPicture(String picture) {
	this.picture = picture;
}
public int getIdPromotion() {
	return idPromotion;
}
public void setIdPromotion(int idPromotion) {
	this.idPromotion = idPromotion;
}
public boolean isPromotionEtat() {
	return promotionEtat;
}
public void setPromotionEtat(boolean promotionEtat) {
	this.promotionEtat = promotionEtat;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getDateexpiration() {
	return dateexpiration;
}
public void setDateexpiration(Date dateexpiration) {
	this.dateexpiration = dateexpiration;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public float getPricepromotion() {
	return pricepromotion;
}
public void setPricepromotion(float pricepromotion) {
	this.pricepromotion = pricepromotion;
}
public String getBarCode() {
	return barCode;
}
public void setBarCode(String barCode) {
	this.barCode = barCode;
}
public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
public int getMostViewed() {
	return mostViewed;
}
public void setMostViewed(int mostViewed) {
	this.mostViewed = mostViewed;
}



public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public List<Product> getProduct() {
	product = ProductService.getAllProducts();
	return product; 
}
public void setProduct(List<Product> product) {
	product = product;
}


public Product addProduct(){
	    
	Product prod = new Product();
	
	prod.setProductName(productName);
	prod.setPicture(picture);
	prod.setDescription(description);
	prod.setDateexpiration(dateexpiration);
	prod.setPrice(price);
	prod.setPricepromotion(pricepromotion);
	prod.setBarCode(barCode);
	prod.setMostViewed(mostViewed);
	prod.setCateg(categ);
	//prod.setPromotionEtat(promotionEtat);
	ProductService.addProduct(prod);
	return prod;
}
public int Ajouterpub(int idproduit){
	Product prod = ProductRepository.findById(idproduit).get();
	int idadd = prod.getAds().getIdAds();
	return AdsViewService.AddAdsView(idadd);
}


public int deleteProduct(int idProduct){
	
	return ProductService.deleteProduct(idProduct);
}

public void displayProduct(Product Product)
{
this.setProductName(Product.getProductName());
this.setPicture(Product.getPicture());
this.setDescription(Product.getDescription());
this.setDateexpiration(Product.getDateexpiration());
this.setPrice(Product.getPrice());
this.setPricepromotion(Product.getPricepromotion());
this.setBarCode(Product.getBarCode());
this.setCreatedAt(Product.getCreatedAt());
this.setMostViewed(Product.getMostViewed());
this.setPromotionEtat(Product.isPromotionEtat());
}

public void updateProduct(int idProduct)
{ 
	Product prod =ProductRepository.findById(idProduct).get();
	prod.setProductName(productName);
	prod.setDescription(description);
	prod.setDateexpiration(dateexpiration);
	prod.setPrice(price);
	prod.setPricepromotion(pricepromotion);
	prod.setBarCode(barCode);
	prod.setCreatedAt(new Date());
	prod.setMostViewed(mostViewed);
	prod.setPromotionEtat(promotionEtat);
	ProductService.updateProduct(idProduct , prod);
	
}

public String Redirection() {
	
String navigateTo = "/pages/admin/ProductCremerie.jsf";
	return navigateTo ;
}


public String Ratting(int idProduct ) {
	Rating rat = new Rating();
	rat.setNbretoile(nbretoile);
	RatingService.addRatingPub(uc.getIdUserC(), idProduct, rat);
	
	return RatingService.addRatingPub(uc.getIdUserC(), idProduct, rat);
	
	
	
}
int idProduct=1;
public void onrate(RateEvent<Integer> rateEvent) {
	Rating rat = new Rating();
	rat.setNbretoile(rateEvent.getRating());
	RatingService.addRatingPub(uc.getIdUserC(), idProduct, rat);
	
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + rateEvent.getRating());
    FacesContext.getCurrentInstance().addMessage(null, message);
    
}

public void upload() {
	try{
		if(picture != null){
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/pi?createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		PreparedStatement st= cn.prepareStatement("INSERT INTO Product(picture) VALUES (?)");
		//st.setBinaryStream(1,picture.getInputStream());
		st.executeUpdate();
		cn.close();
		}
		}
		catch (Exception e){}
}
}
