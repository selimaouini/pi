package tn.pi.entities;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="T_USER")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idu;
	@Column(name="first_name")
	private String firstName;
	
	private String lastName;
	@Temporal(TemporalType.DATE)
	
	private Date dateNaissance;
	
	@Enumerated(EnumType.STRING)
	Role role;
	
	/*@OneToMany(cascade = CascadeType.ALL,mappedBy = "User")
	private Set<Post> post;*/
	
	
	/*

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "User")
	private Set<Chat> chat;
	
	@OneToMany(mappedBy = "user")
	private List<Comment> comment;
	
	@OneToMany(mappedBy = "user")
	private List <Rating> rating;
	
	*/
	
	public long getIdu() {
		return idu;
	}

	public void setIdu(long idu) {
		this.idu = idu;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User(long idu, String firstName, String lastName, Date dateNaissance, Role role) {
		super();
		this.idu = idu;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateNaissance = dateNaissance;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
