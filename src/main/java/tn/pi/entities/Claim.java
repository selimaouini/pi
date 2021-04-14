package tn.pi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_claim")
public class Claim implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private long id_claim;
	
	@Column (name="description")
	private String description;
	@Column (name="date")
	private Date date;
	@Column (name="state")
	private String state;
	public Claim() {
		super();
	}
	public Claim(long id_claim, String description, Date date, String state) {
		super();
		this.id_claim = id_claim;
		this.description = description;
		this.date = date;
		this.state = state;
	}
	public long getId_claim() {
		return id_claim;
	}
	public void setId_claim(long id_claim) {
		this.id_claim = id_claim;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Claim [id_claim=" + id_claim + ", description=" + description + ", date=" + date + ", state=" + state
				+ "]";
	}
	
	
	
}
