package tn.pi.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_USER")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	/*Hibernate donne la main à la BD pour générer les clés avac l'option "IDENTITY" : auto-increment*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;

	private String workZone;
	private boolean availability;
	private int toHour;
	private String country;
	private int nb ;

	
	private String tel;
	private String lastName;
	private String firstName;
	private String password;
	private String Email;
	private boolean connected;
	private boolean active;
	private double pointconverti;
	private double nbrpoint;

	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	private String picture;
	private String gender;
	private int age;
	@Enumerated(EnumType.STRING)
	private Etatfidelite etat;
	@Enumerated(EnumType.STRING)
	RoleType role;

	// comment
	// @OneToMany (mappedBy="user", cascade = CascadeType.ALL, fetch=
	// FetchType.LAZY)
	// private Set<Comment> comments;

	// publication
	// @OneToMany (mappedBy="user", cascade = CascadeType.ALL, fetch=
	// FetchType.LAZY)
	// private Set<Publication> publications;

	// Rating
	// @OneToMany (mappedBy="user", cascade = CascadeType.ALL, fetch=
	// FetchType.LAZY)
	// private Set<Rating> ratings;

	// event
	// @OneToMany (mappedBy="user", cascade = CascadeType.ALL, fetch=
	// FetchType.LAZY)
	// private Set<Event> events;


	 @OneToMany (mappedBy="user", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	 private Set<Cart> carts;

	public int getIdUser() {
		return idUser;
	}



	public User(Object object, Object object2, Object object3, String string, int i, int j, String string2, String string3, String string4, String string5, String string6, boolean b, boolean c, Date date, Object object4, String string7, int k, RoleType client) {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getWorkZone() {
		return workZone;
	}

	public void setWorkZone(String workZone) {
		this.workZone = workZone;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	public int getToHour() {
		return toHour;
	}

	public void setToHour(int toHour) {
		this.toHour = toHour;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}
	

	public User(int idUser, String workZone, boolean availability, int toHour, String country, int nb, String tel,
			String lastName, String firstName, String password, String email, boolean connected, boolean active,
			double pointconverti, double nbrpoint, Date dateCreation, String picture, String gender, int age,
			Etatfidelite etat, RoleType role, Set<Cart> carts) {
		super();
		this.idUser = idUser;
		this.workZone = workZone;
		this.availability = availability;
		this.toHour = toHour;
		this.country = country;
		this.nb = nb;
		this.tel = tel;
		this.lastName = lastName;
		this.firstName = firstName;
		this.password = password;
		Email = email;
		this.connected = connected;
		this.active = active;
		this.pointconverti = pointconverti;
		this.nbrpoint = nbrpoint;
		this.dateCreation = dateCreation;
		this.picture = picture;
		this.gender = gender;
		this.age = age;
		this.etat = etat;
		this.role = role;
		this.carts = carts;
	}

	public User(int idUser, String workZone, boolean availability, int toHour, String country, int numPoints,
			int convertedPoints, String tel, String lastName, String firstName, String password, String email,
			boolean connected, boolean active, Date dateCreation, String picture, String gender, int age, RoleType role,
			Set<Cart> carts) {
		super();
		this.idUser = idUser;
		this.workZone = workZone;
		this.availability = availability;
		this.toHour = toHour;
		this.country = country;
		
		this.tel = tel;
		this.lastName = lastName;
		this.firstName = firstName;
		this.password = password;
		Email = email;
		this.connected = connected;
		this.active = active;
		this.dateCreation = dateCreation;
		this.picture = picture;
		this.gender = gender;
		this.age = age;
		this.role = role;
		this.carts = carts;
	}

	public User(double pointconverti, double nbrpoint, Etatfidelite etat) {
		super();
		this.pointconverti = pointconverti;
		this.nbrpoint = nbrpoint;
		this.etat = etat;
	}

	public double getPointconverti() {
		return pointconverti;
	}

	public void setPointconverti(double pointconverti) {
		this.pointconverti = pointconverti;
	}

	public double getNbrpoint() {
		return nbrpoint;
	}

	public void setNbrpoint(double d) {
		this.nbrpoint = d;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User(int idUser, String workZone, boolean availability, int toHour, String country, int numPoints,
		 String tel, String lastName, String firstName, String password, String email,
			boolean connected, boolean active, double pointconverti, int nbrpoint, Date dateCreation, String picture,
			String gender, int age, RoleType role, Set<Cart> carts) {
		super();
		this.idUser = idUser;
		this.workZone = workZone;
		this.availability = availability;
		this.toHour = toHour;
		this.country = country;
	
		
		this.tel = tel;
		this.lastName = lastName;
		this.firstName = firstName;
		this.password = password;
		Email = email;
		this.connected = connected;
		this.active = active;
		this.pointconverti = pointconverti;
		this.nbrpoint = nbrpoint;
		this.dateCreation = dateCreation;
		this.picture = picture;
		this.gender = gender;
		this.age = age;
		this.role = role;
		this.carts = carts;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public void setEtatf(Etatfidelite etat) {
		this.etat = etat;
	}
	
	

	public Etatfidelite getEtat() {
		return etat;
	}

	public void setEtat(Etatfidelite etat) {
		this.etat = etat;
	}

	public User(int idUser, String workZone, boolean availability, int toHour, String country, int numPoints,
			 String tel, String lastName, String firstName, String password, String email,
			boolean connected, boolean active, double pointconverti, int nbrpoint, Date dateCreation, String picture,
			String gender, int age, Etatfidelite etat, RoleType role, Set<Cart> carts) {
		super();
		this.idUser = idUser;
		this.workZone = workZone;
		this.availability = availability;
		this.toHour = toHour;
		this.country = country;
		this.tel = tel;
		this.lastName = lastName;
		this.firstName = firstName;
		this.password = password;
		Email = email;
		this.connected = connected;
		this.active = active;
		this.pointconverti = pointconverti;
		this.nbrpoint = nbrpoint;
		this.dateCreation = dateCreation;
		this.picture = picture;
		this.gender = gender;
		this.age = age;
		this.etat = etat;
		this.role = role;
		this.carts = carts;
	}



	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", workZone=" + workZone + ", availability=" + availability + ", toHour="
				+ toHour + ", country=" + country + ", nb=" + nb + ", tel=" + tel + ", lastName=" + lastName
				+ ", firstName=" + firstName + ", password=" + password + ", Email=" + Email + ", connected="
				+ connected + ", active=" + active + ", pointconverti=" + pointconverti + ", nbrpoint=" + nbrpoint
				+ ", dateCreation=" + dateCreation + ", picture=" + picture + ", gender=" + gender + ", age=" + age
				+ ", etat=" + etat + ", role=" + role + ", carts=" + carts + "]";
	}
	

}