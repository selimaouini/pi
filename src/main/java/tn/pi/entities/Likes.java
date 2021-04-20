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
	
	@Column(name="dislike")
	private int dislike;

	@ManyToOne
	private Comment Comment ;

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

	public int getdislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

	public Comment getComment() {
		return Comment;
	}

	public void setComment(Comment comment) {
		Comment = comment;
	}

	public int getDislike() {
		return dislike;
	}

	public Likes(int idL, int likee, int dislike, tn.pi.entities.Comment comment) {
		super();
		this.idL = idL;
		this.likee = likee;
		this.dislike = dislike;
		Comment = comment;
	}

	public Likes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
