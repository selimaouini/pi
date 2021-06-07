package tn.pi.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;



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
	
	private float price;
	private boolean newProduct;
	private String barCode;
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	private int mostViewed;
	private boolean expired;
	@Temporal(TemporalType.DATE)
	private Date dateexpiration;
	private int weigth;
	private float pricepromotion;
	private String categ;

	private boolean promotionEtat;
	@JsonIgnore
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<Promotion>promotions;
	@JsonIgnore
	@OneToOne
	private Ads Ads;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<Rating>rating;

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	public Ads getAds() {
		return Ads;
	}

	public void setAds(Ads ads) {
		Ads = ads;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}
    
	public String getCateg() {
		return categ;
	}

	public void setCateg(String categ) {
		this.categ = categ;
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

	public float getPricepromotion() {
		return pricepromotion;
	}

	public void setPricepromotion(float pricepromotion) {
		this.pricepromotion = pricepromotion;
	}

	public boolean isPromotionEtat() {
		return promotionEtat;
	}

	public void setPromotionEtat(boolean promotionEtat) {
		this.promotionEtat = promotionEtat;
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
		return price;
	}

	public void setSellPrice(float sellPrice) {
		this.price = sellPrice;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	//@ManyToMany(mappedBy = "products")
//	private List<CommandProduct> CommandProduct;

	
	
	

	@OneToOne
	private Stock stock;
	

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	
	



	public boolean isExpired() {
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

	public Product(int idProduct, String productName, String picture, String description, float price,
			boolean newProduct, String barCode, Date createdAt, int mostViewed, int weigth, Stock stock,
			List<Cart> carts) {
		super();
		this.idProduct = idProduct;
		this.productName = productName;
		this.picture = picture;
		this.description = description;
		this.price = price;
		this.newProduct = newProduct;
		this.barCode = barCode;
		this.createdAt = createdAt;
		this.mostViewed = mostViewed;
		this.weigth = weigth;
		this.stock = stock;
		
	}

	public Product(String productName, String picture, String description, float price, boolean newProduct,
			String barCode, Date createdAt, int mostViewed, int weigth) {
		super();
		this.productName = productName;
		this.picture = picture;
		this.description = description;
		this.price = price;
		this.newProduct = newProduct;
		this.barCode = barCode;
		this.createdAt = createdAt;
		this.mostViewed = mostViewed;
		this.weigth = weigth;
	}

	public Product(int idProduct, String productName, String picture, String description, float price,
			boolean newProduct, String barCode, Date createdAt, int mostViewed, int weigth) {
		super();
		this.idProduct = idProduct;
		this.productName = productName;
		this.picture = picture;
		this.description = description;
		this.price = price;
		this.newProduct = newProduct;
		this.barCode = barCode;
		this.createdAt = createdAt;
		this.mostViewed = mostViewed;
		this.weigth = weigth;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Product(String productName) {
		super();
		this.productName = productName;
	}

	public Product(int idProduct, String productName, String picture, String description, float price,
			boolean newProduct, String barCode, Date createdAt, int mostViewed, int weigth, List<Promotion> promotions,
			tn.pi.entities.Ads ads, Category category, List<Rating> rating, Stock stock) {
		super();
		this.idProduct = idProduct;
		this.productName = productName;
		this.picture = picture;
		this.description = description;
		this.price = price;
		this.newProduct = newProduct;
		this.barCode = barCode;
		this.createdAt = createdAt;
		this.mostViewed = mostViewed;
		this.weigth = weigth;
		this.promotions = promotions;
		Ads = ads;
		this.category = category;
		this.rating = rating;
		this.stock = stock;
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
	
	public Product(String productName,String picture,String description, Date dateexpiration, float price, float pricepromotion,
			String barCode, Date createdAt, int mostViewed, boolean promotionEtat, Category category) {
		super();
		this.productName = productName;
		this.picture = picture;
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

	public Product(int idProduct, String productName, String picture, String description, float price,
			boolean newProduct, String barCode, Date createdAt, int mostViewed, boolean expired, Date dateexpiration,
			int weigth, float pricepromotion, String categ, boolean promotionEtat, List<Promotion> promotions,
			tn.pi.entities.Ads ads, Category category, List<Rating> rating, Stock stock) {
		super();
		this.idProduct = idProduct;
		this.productName = productName;
		this.picture = picture;
		this.description = description;
		this.price = price;
		this.newProduct = newProduct;
		this.barCode = barCode;
		this.createdAt = createdAt;
		this.mostViewed = mostViewed;
		this.expired = expired;
		this.dateexpiration = dateexpiration;
		this.weigth = weigth;
		this.pricepromotion = pricepromotion;
		this.categ = categ;
		this.promotionEtat = promotionEtat;
		this.promotions = promotions;
		Ads = ads;
		this.category = category;
		this.rating = rating;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", productName=" + productName + ", picture=" + picture
				+ ", description=" + description + ", price=" + price + ", newProduct=" + newProduct + ", barCode="
				+ barCode + ", createdAt=" + createdAt + ", mostViewed=" + mostViewed + ", expired=" + expired
				+ ", dateexpiration=" + dateexpiration + ", weigth=" + weigth + ", pricepromotion=" + pricepromotion
				+ ", categ=" + categ + ", promotionEtat=" + promotionEtat + ", promotions=" + promotions + ", Ads="
				+ Ads + ", category=" + category + ", rating=" + rating + ", stock=" + stock + "]";
	}
 
	
	
	
}
