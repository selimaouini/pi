package tn.pi.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "T_LIKES")
public class Likes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idL;

	@Column(name = "liked")
	private boolean liked;

	@Column(name = "disliked")
	private boolean disliked;

	@Column(name = "etat")
	private String etat;

	private LocalDateTime date = LocalDateTime.now();

	/************** Associations **************/

	@JsonIgnore
	@ManyToOne
	private Comment comment;

	@JsonBackReference(value = "user")
	@ManyToOne
	private User user;

	/*
	 * @JsonBackReference(value="comment")
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "idc", referencedColumnName = "Likes",
	 * insertable=false, updatable=false) private Comment Comment;
	 * 
	 * 
	 */

	public long getIdL() {
		return idL;
	}

	public void setIdL(long idL) {
		this.idL = idL;
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public boolean isDisliked() {
		return disliked;
	}

	public void setDisliked(boolean disliked) {
		this.disliked = disliked;
	}

	

	public Likes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Likes(long idL, boolean like, boolean dislike, String etat, LocalDateTime date, Comment comment, User user) {
		super();
		this.idL = idL;
		this.liked = liked;
	//	this.dislike = dislike;
		this.etat = etat;
		this.date = date;
		this.comment = comment;
		this.user = user;
	}

	

}
