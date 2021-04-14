package tn.pi.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_Rating")
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idR;
	
	@Column(name="Stars")
	private int stars;

	@ManyToOne(cascade = CascadeType.ALL)
	Post Post ;
	
	
	public long getIdR() {
		return idR;
	}

	public void setIdR(int idR) {
		this.idR = idR;
	}

	public long getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public Rating(int idR, int stars) {
		super();
		this.idR = idR;
		this.stars = stars;
	}

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Rating [idR=" + idR + ", stars=" + stars + "]";
	}
	

}

	

	