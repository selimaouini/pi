package tn.pi.entities;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrating;
	private int nbretoile;
	//private int like;

	@ManyToOne
	private User user;
	@ManyToOne
	private Product product;
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(int idrating, int nbretoile , User user, Product product) {
		super();
		this.idrating = idrating;
		this.nbretoile = nbretoile;
		//this.like =like;
		this.user = user;
		this.product = product;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
}