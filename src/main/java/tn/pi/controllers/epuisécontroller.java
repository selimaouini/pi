package tn.pi.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.pi.entities.Demandestock;
import tn.pi.entities.Product;
import tn.pi.entities.Stock;
import tn.pi.repositories.IProductRepository;
import tn.pi.services.DemandestockService;
import tn.pi.services.IStockService;
@Controller(value = "epuiséController")
@ELBeanName(value = "epuiséController")
@ManagedBean
@ViewScoped
public class epuisécontroller {
	@Autowired
	IStockService ep;
	@Autowired
	DemandestockService ds;
	@Autowired
	IProductRepository pro;
	private int idProduct;
	private String productName;
	private String picture;
	private String description;
	private Product productt;
	
	
	public Product getProductt() {
		return productt;
	}
	public void setProductt(Product productt) {
		this.productt = productt;
	}
	private float sellPrice;
	private boolean newProduct;
	private String barCode;
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	private int mostViewed;
	
	private int weigth;
	private List<Product> product;
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(float sellPrice) {
		this.sellPrice = sellPrice;
	}
	public boolean isNewProduct() {
		return newProduct;
	}
	public void setNewProduct(boolean newProduct) {
		this.newProduct = newProduct;
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
	public int getWeigth() {
		return weigth;
	}
	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}
	public List<Product> getProduct() {
		product = ep.ExpirationsNotif();
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	private float quantity;
	
	
	public float getQuantity() {
		return quantity;
	}
	
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	
	
	public IProductRepository getPro() {
		return pro;
	}
	public void setPro(IProductRepository pro) {
		this.pro = pro;
	}


}
