package tn.esprit.spring.entities.User;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Employe implements Serializable {
	
	private static final long serialVersionUID = -1396669830860400871L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String prenom;
	
	private String nom;
	
	private String username;
	
	private String email;

	private String password;
	
	private boolean isActif=true;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private ERole role;
	
	private String address;
	private int pointsFidelite;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateN;
	
	private String tel;
	private String disponible;
	private boolean enabled = false;
	private String lieuxTravail;
	
	@ManyToMany  //(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getusername() {
		return username;
	}

	public void setusername(String username) {
	username = username;
	}

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public boolean isActif() {
		return isActif;
	}



	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPointsFidelite() {
		return pointsFidelite;
	}

	public void setPointsFidelite(int pointsFidelite) {
		this.pointsFidelite = pointsFidelite;
	}

	public Date getDateN() {
		return dateN;
	}

	public void setDateN(Date dateN) {
		this.dateN = dateN;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getLieuxTravail() {
		return lieuxTravail;
	}

	public void setLieuxTravail(String lieuxTravail) {
		this.lieuxTravail = lieuxTravail;
	}
	
	

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Employe(int id, String prenom, String nom,String username, String email, String password, boolean isActif, Set<Role> role) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.username=username;
		this.email = email;
		this.password = password;
		this.isActif = isActif;
		this.roles = role;
	}



	@Override
	public String toString() {
		return "Employe [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", username="+username+",  email=" + email + ", password="
				+ password + ", isActif=" + isActif + ", role=" + roles + "]";
	}



	public Employe(String prenom, String nom, String email, String password, boolean isActif, Set<Role> role) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.username=username;
		this.email = email;
		this.password = password;
		this.isActif = isActif;
		this.roles = role;
	}

	public Employe() {
		super();
	}


	public Employe(String prenom, String nom,String username, String email, String password, boolean isActif, String address,
			int pointsFidelite, Date dateN, String tel, String disponible, boolean enabled, String lieuxTravail,
			Set<Role> roles) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.username=username;
		this.email = email;
		this.password = password;
		this.isActif = isActif;
		this.address = address;
		this.pointsFidelite = pointsFidelite;
		this.dateN = dateN;
		this.tel = tel;
		this.disponible = disponible;
		this.enabled = enabled;
		this.lieuxTravail = lieuxTravail;
		this.roles = roles;
	}

	public Employe(String prenom, String nom, String username, String email, String password, String address,
			Date dateN, String tel) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.dateN = dateN;
		this.tel = tel;
	}

	public Employe(String username, String email, String password, String address, Date dateN, String tel) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.dateN = dateN;
		this.tel = tel;
	}

	public Employe(int id, String username, String email, String password, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	

	


	
	
}