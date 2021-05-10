package tn.pi.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product") 
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduct;
	private String productName;
	private String picture;
	private String description;
	private boolean expired;
	@Temporal(TemporalType.DATE)
	private Date dateexpiration;
	private float price;
	private float pricepromotion;
	private boolean newProduct;
	private String barCode;
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	private int mostViewed;
	private boolean promotionEtat;

	 
	//@ManyToOne
	//private User user;
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<Promotion>promotions;
	@OneToOne
	private Ads Ads;
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	//@ManyToMany(mappedBy = "products")
	//private List<CommandProduct> commandproducts;
	//@ManyToOne
	//private Aisel aisel;
	//@OneToMany(mappedBy = "products")
	//private List<Cart>carts;
	//@OneToOne
	//private Stock stock;
	
	public int getIdProduct() {
		return idProduct;
	}

	
	

	public Ads getAds() {
		return Ads;
	}




	public void setAds(Ads ads) {
		Ads = ads;
	}




	public Product(String productName, String picture, String description, float price, boolean newProduct,
			String barCode, Date createdAt, int mostViewed, int weigth, boolean promotionEtat,
			List<Promotion> promotions, Category category, boolean expired ,Date dateexpiration) {
		super();
		this.productName = productName;
		this.picture = picture;
		this.description = description;
		this.price = price;
		this.newProduct = newProduct;
		this.barCode = barCode;
		this.createdAt = createdAt;
		this.mostViewed = mostViewed;
		this.promotionEtat = promotionEtat;
		this.promotions = promotions;
		this.category = category;
		this.expired = expired ;
		this.dateexpiration = dateexpiration;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
	public boolean getExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	
	public Date getDateexpiration() {
		return dateexpiration;
	}
	public void setDateexpiration(Date dateexpiration) {
		this.dateexpiration = dateexpiration;
	}
	public float getPricepromotion() {
		return pricepromotion;
	}
	public void setPricepromotion(float pricepromotion) {
		this.pricepromotion = pricepromotion;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
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
	public boolean isPromotionEtat() {
		return promotionEtat;
	}
	public void setPromotionEtat(boolean promotionEtat) {
		this.promotionEtat = promotionEtat;
	}
	public List<Promotion> getPromotions() {
		return promotions;
	}
	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Product(int idProduct, String productName, String picture, String description, float price,
			boolean newProduct, String barCode, Date createdAt, int mostViewed, int weigth, boolean promotionEtat,
			List<Promotion> promotions, Category category, boolean expired ,Date dateexpiration) {
		super();
		this.idProduct = idProduct;
		this.productName = productName;
		this.picture = picture;
		this.description = description;
		this.price = price;
		this.pricepromotion = pricepromotion;
		this.newProduct = newProduct;
		this.barCode = barCode;
		this.createdAt = createdAt;
		this.mostViewed = mostViewed;
		this.promotionEtat = promotionEtat;
		this.promotions = promotions;
		this.category = category;
		this.expired = expired;
		this.dateexpiration = dateexpiration;
	}
	
	public Product(String productName,String description, Date dateexpiration, float price, float pricepromotion,
			String barCode, Date createdAt, int mostViewed, boolean promotionEtat, Category category) {
		super();
		this.productName = productName;
		this.description = description;
		this.dateexpiration = dateexpiration;
		this.price = price;
		this.pricepromotion = pricepromotion;
		this.barCode = barCode;
		this.createdAt = createdAt;
		this.mostViewed = mostViewed;
		this.promotionEtat = promotionEtat;
		this.category = category ;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(int idProduct, Category category) {
		super();
		this.idProduct = idProduct;
		this.category = category;
	}
	
	public Product(Category category) {
		super();
		this.category = category;
	}
	
	public Product(int idProduct, String productName, String picture, String description, boolean expired,
			Date dateexpiration, float price, float pricepromotion, boolean newProduct, String barCode, Date createdAt,
			int mostViewed, boolean promotionEtat, List<Promotion> promotions,
			Category category) {
		super();
		this.idProduct = idProduct;
		this.productName = productName;
		this.picture = picture;
		this.description = description;
		this.expired = expired;
		this.dateexpiration = dateexpiration;
		this.price = price;
		this.pricepromotion = pricepromotion;
		this.newProduct = newProduct;
		this.barCode = barCode;
		this.createdAt = createdAt;
		this.mostViewed = mostViewed;
		this.promotionEtat = promotionEtat;
		this.promotions = promotions;
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", productName=" + productName + ", picture=" + picture
				+ ", description=" + description + ", expired=" + expired + ", dateexpiration=" + dateexpiration
				+ ", price=" + price + ", pricepromotion=" + pricepromotion + ", newProduct=" + newProduct
				+ ", barCode=" + barCode + ", createdAt=" + createdAt + ", mostViewed=" + mostViewed
				+ ", promotionEtat=" + promotionEtat + ", promotions="
				+ promotions + ", category=" + category + "]";
	}
	
	
	
	
	
	
	
	
	

	
}
