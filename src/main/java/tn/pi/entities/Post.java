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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;


@Entity
@Table(name="T_Post")
public class Post implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idP;
	
	@NotEmpty 
	@Size(min=3,max= 25,message = " you should insert at least 1 character ")
	@Column(name="title")
	private String title;
	
	@NotEmpty 
	//@Size(min=5, max= 200, message = " you should insert at least 1 character ")
	@Column(name="content")
	private String content;
	
	
	@Column(name="photo")
	private String photo;
	
	@NotNull	
	private LocalDateTime dateCreation= LocalDateTime.now();
	
	//@Temporal(TemporalType.DATE)
	//private Date dateCreation;

	@Enumerated(EnumType.STRING)
	Theme theme; 
	
	private Long postdToBeUpdated;
	
	/**************Associations**************/
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	User User ;
	
		@OneToMany(mappedBy="Post" ,cascade=CascadeType.REMOVE)
		public List<Comment> comments;
		
		@OneToMany(mappedBy = "Post")
		private List<Rating>rating;

		
		
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(long idP,
			@NotEmpty @Size(min = 3, max = 25, message = " you should insert at least 1 character ") String title,
			@NotEmpty String content, String photo, LocalDateTime dateCreation, Theme theme,
			tn.pi.entities.User user, List<Comment> comments, List<Rating> rating) {
		super();
		this.idP = idP;
		this.title = title;
		this.content = content;
		this.photo = photo;
		this.dateCreation = dateCreation;
		this.theme = theme;
		User = user;
		this.comments = comments;
		this.rating = rating;
	}

	public Post(@NotEmpty @Size(min = 3, max = 25, message = " you should insert at least 1 character ") String title,
			@NotEmpty String content, String photo, Theme theme) {
		super();
		this.title = title;
		this.content = content;
		this.photo = photo;
		this.theme = theme;
	}

	public Long getPostdToBeUpdated() {
		return postdToBeUpdated;
	}

	public void setPostdToBeUpdated(Long postdToBeUpdated) {
		this.postdToBeUpdated = postdToBeUpdated;
	}

	public Post(@NotEmpty @Size(min = 3, max = 25, message = " you should insert at least 1 character ") String title,
			@NotEmpty String content, String photo, Theme theme, Long postdToBeUpdated) {
		super();
		this.title = title;
		this.content = content;
		this.photo = photo;
		this.theme = theme;
		this.postdToBeUpdated = postdToBeUpdated;
	}

	
	
	

}
