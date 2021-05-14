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

public class catalog implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String pic;
	private float price;
	private String barCode;
	private int  stock;
	//@OneToOne
	//private User user;
	
	
	public catalog() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "catalog [id=" + id + ", name=" + name + ", pic=" + pic + ", price=" + price + ", barCode=" + barCode
				+ ", stock=" + stock + "]";
	}




	public catalog(int id, String name, String pic, float price, String barCode, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.pic = pic;
		this.price = price;
		this.barCode = barCode;
		this.stock = stock;
	}

















	public catalog(String name, float price, String barCode, int stock) {
		super();
		this.name = name;
		this.price = price;
		this.barCode = barCode;
		this.stock = stock;
	}


	public catalog(int id, String name, String pic, float price, String barCode) {
		super();
		this.id = id;
		this.name = name;
		this.pic = pic;
		this.price = price;
		this.barCode = barCode;
	}


	public catalog(int id, String name, float price, String barCode, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.barCode = barCode;
		this.stock = stock;
	}


	public int getId() {
		return id;
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

















	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
	
	
	
	
}
