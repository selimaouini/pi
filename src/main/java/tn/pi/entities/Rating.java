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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="T_Rating")
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idR;
	
	@Column(name="Stars")
	private int stars;

	/**************Associations**************/
	@ManyToOne(cascade = CascadeType.ALL)
	private Post Post ;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	User User ;
	
	
	public long getIdR() {
		return idR;
	}

	public void setIdR(long idR) {
		this.idR = idR;
	}

	public long getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public Post getPost() {
		return Post;
	}

	public void setPost(Post Post) {
		this.Post = Post;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User User) {
		this.User = User;
	}

	public Rating(long idR, int stars, Post Post, User User) {
		super();
		this.idR = idR;
		this.stars = stars;
		this.Post = Post;
		this.User = User;
	}

	public Rating(int stars) {
		super();
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

	

	