package tn.pi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class LigneComand implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 951570144146761511L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idlc;
    //@PositiveOrZero
	private int qte;
	//@PositiveOrZero
	private double price;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne(fetch = FetchType.EAGER)
	private Cart cart;
	@ManyToOne(fetch = FetchType.EAGER)
	private Product produit;
	@OneToOne
	private User user;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
		
	public Product getProduit() {
		return produit;
	}
	public void setProduit(Product produit) {
		this.produit = produit;
	}
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	public int getIdlc() {
		return idlc;
	}
	public void setIdlc(int idlc) {
		this.idlc = idlc;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public LigneComand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneComand(int idlc, int qte, double price, Date date, Cart cart, Product produit) {
		super();
		this.idlc = idlc;
		this.qte = qte;
		this.price = price;
		this.date = date;
		this.cart = cart;
		this.produit = produit;
	}
	
	
	public LigneComand( int qte,  double price, Date date) {
		super();
		this.qte = qte;
		this.price = price;
		this.date = date;
	}
	
	public LigneComand(int idlc,  int qte,  double price, Date date) {
		super();
		this.idlc = idlc;
		this.qte = qte;
		this.price = price;
		this.date = date;
	}
	
	
	public LigneComand(int qte, double price, Date date, Cart cart, Product produit, User user) {
		super();
		this.qte = qte;
		this.price = price;
		this.date = date;
		this.cart = cart;
		this.produit = produit;
		this.user = user;
	}
	public LigneComand(int idlc, int qte, double price, Date date, Cart cart, Product produit, User user) {
		super();
		this.idlc = idlc;
		this.qte = qte;
		this.price = price;
		this.date = date;
		this.cart = cart;
		this.produit = produit;
		this.user = user;
	}
	@Override
	public String toString() {
		return "LigneComand [idlc=" + idlc + ", qte=" + qte + ", price=" + price + ", date=" + date + ", cart=" + cart
				+ ", produit=" + produit + ", user=" + user + "]";
	}


	
	
	
}
