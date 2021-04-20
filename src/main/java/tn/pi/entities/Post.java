package tn.pi.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;


@Entity
@Table(name="T_Post")
public class Post implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idP;
	
	//@Size(min=3,title = " you should insert at least 1 character ")
	@Column(name="title")
	private String title;
	
	//@Size(min=25,description = " you should insert at least 1 character ")
	@Column(name="description")
	private String description;
	
	
	@Column(name="photo")
	private String photo;
	
	//@NotNull	
	//private LocalDateTime dateCreation= LocalDateTime.now();
	
	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	@Enumerated(EnumType.STRING)
	Theme theme; 
	
	@ManyToOne
	User user ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Post")
	private Set<Rating> rating;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="Post")
	List<Comment> comment;
	
	public long getIdP() {
		return idP;
	}

	public void setIdP(long idP) {
		this.idP = idP;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Rating> getRating() {
		return rating;
	}

	public void setRating(Set<Rating> rating) {
		this.rating = rating;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment= comment;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(long idP, String title, String description, String photo, Date dateCreation, Theme theme) {
		super();
		this.idP = idP;
		this.title = title;
		this.description = description;
		this.photo = photo;
		this.dateCreation = dateCreation;
		this.theme = theme;
	}

	
	public Post(long idP, String title, String description, String photo, Date dateCreation, Theme theme, User user,
			Set<Rating> rating, List<Comment> comment) {
		super();
		this.idP = idP;
		this.title = title;
		this.description = description;
		this.photo = photo;
		this.dateCreation = dateCreation;
		this.theme = theme;
		this.user = user;
		this.rating = rating;
		this.comment = comment;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idP != other.idP)
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	

}
