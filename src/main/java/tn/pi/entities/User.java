
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_USER")
public class User implements Serializable {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@Id
	/*Hibernate donne la main à la BD pour générer les clés avac l'option "IDENTITY" : auto-increment*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;

	
	private boolean availability;
	private int toHour;
	private String country;
	private int numPoints;
	private int convertedPoints;
	private String tel;
	private String lastName;
	private String firstName;
	private String password;
	private String email;
	private boolean connected;
	private boolean active;

	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	private String picture;
	private String gender;
	private int age;

	@Enumerated(EnumType.STRING)
	RoleType role;
	
	

	public User() {
		super();
	}

	public User(int idUser, boolean availability, int toHour, String country, int numPoints, int convertedPoints,
			String tel, String lastName, String firstName, String password, String email, boolean connected,
			boolean active, Date dateCreation, String picture, String gender, int age, RoleType role,
			tn.pi.entities.DeliveryMan deliveryMan) {
		super();
		this.idUser = idUser;
		this.availability = availability;
		this.toHour = toHour;
		this.country = country;
		this.numPoints = numPoints;
		this.convertedPoints = convertedPoints;
		this.tel = tel;
		this.lastName = lastName;
		this.firstName = firstName;
		this.password = password;
		this.email = email;
		this.connected = connected;
		this.active = active;
		this.dateCreation = dateCreation;
		this.picture = picture;
		this.gender = gender;
		this.age = age;
		this.role = role;
		
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
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

	public int getNumPoints() {
		return numPoints;
	}

	public void setNumPoints(int numPoints) {
		this.numPoints = numPoints;
	}

	public int getConvertedPoints() {
		return convertedPoints;
	}

	public void setConvertedPoints(int convertedPoints) {
		this.convertedPoints = convertedPoints;
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
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	

	
	

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", availability=" + availability + ", toHour=" + toHour + ", country="
				+ country + ", numPoints=" + numPoints + ", convertedPoints=" + convertedPoints + ", tel=" + tel
				+ ", lastName=" + lastName + ", firstName=" + firstName + ", password=" + password + ", email=" + email
				+ ", connected=" + connected + ", active=" + active + ", dateCreation=" + dateCreation + ", picture="
				+ picture + ", gender=" + gender + ", age=" + age + ", role=" + role + "]";
	}
	
	
}