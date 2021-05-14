package tn.pi.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity

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
	
	private int weigth;

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

	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", productName=" + productName + ", picture=" + picture
				+ ", description=" + description + ", sellPrice=" + price + ", newProduct=" + newProduct
				+ ", barCode=" + barCode + ", createdAt=" + createdAt + ", mostViewed=" + mostViewed + ", weigth="
				+ weigth + ", stock=" + stock + "]";
	}

	
	
	
	
	
}
