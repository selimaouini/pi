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
@Table(name="T_LIKES")
public class Likes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idL;
	
	@Column(name="likee")
	private int likee;
	
	@Column(name="unlike")
	private int unlike;

	@ManyToOne(cascade = CascadeType.ALL)
	Comment Comment ;
	


	public int getIdL() {
		return idL;
	}

	public void setIdL(int idL) {
		this.idL = idL;
	}

	public int getLikee() {
		return likee;
	}

	public void setLikee(int likee) {
		this.likee = likee;
	}

	public int getUnlike() {
		return unlike;
	}

	public void setUnlike(int unlike) {
		this.unlike = unlike;
	}

	@Override
	public String toString() {
		return "Likes [idL=" + idL + ", likee=" + likee + ", unlike=" + unlike + "]";
	}

	public Likes(int idL, int likee, int unlike) {
		super();
		this.idL = idL;
		this.likee = likee;
		this.unlike = unlike;
	}

	public Likes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
