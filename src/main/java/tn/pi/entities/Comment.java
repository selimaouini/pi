package tn.pi.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "T_Comment")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idc;

	// @Size(min=1,description = " you should insert at least 1 character ")
	@Column(name = "description")
	private String description;

	@NotNull
	private LocalDateTime dateCreation = LocalDateTime.now();
	
	private String username;

	/************** Associations **************/

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	User User;

	@JsonIgnore
	@ManyToOne
	private Post Post;

	@OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE)
	private List<Likes> likes;

	public long getIdc() {
		return idc;
	}

	public void setIdc(long idc) {
		this.idc = idc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public Post getPost() {
		return Post;
	}

	public void setPost(Post post) {
		Post = post;
	}

	public List<Likes> getLikes() {
		return likes;
	}

	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public Comment(long idc, String description, LocalDateTime dateCreation, String username, tn.pi.entities.User user,
			tn.pi.entities.Post post, List<Likes> likes) {
		super();
		this.idc = idc;
		this.description = description;
		this.dateCreation = dateCreation;
		this.username = username;
		User = user;
		Post = post;
		this.likes = likes;
	}

	public Comment(String description) {
		super();
		this.description = description;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(long idc, String description) {
		super();
		this.idc = idc;
		this.description = description;
	}

}
