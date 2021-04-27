package tn.pi.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="T_LIKES")
public class Likes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idL;
	
	@Column(name="likee")
	private boolean likee;
	
	@Column(name="dislike")
	private boolean dislike;

	/**************Associations**************/
	@ManyToOne
	private Comment Comment ;


	public long getIdL() {
		return idL;
	}

	public void setIdL(long idL) {
		this.idL = idL;
	}

	public boolean isLikee() {
		return likee;
	}

	public void setLikee(boolean likee) {
		this.likee = likee;
	}

	public boolean isDislike() {
		return dislike;
	}

	public void setDislike(boolean dislike) {
		this.dislike = dislike;
	}

	public Comment getComment() {
		return Comment;
	}

	public void setComment(Comment comment) {
		Comment = comment;
	}

	public Likes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
