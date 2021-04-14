package tn.pi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="T_Comment")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idC;
	
	@Column(name="description")
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	User User ;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Post Post ;


	public long getIdC() {
		return idC;
	}


	public void setIdC(long idC) {
		this.idC = idC;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public Comment(long idC, String description, Date dateCreation) {
		super();
		this.idC = idC;
		this.description = description;
		this.dateCreation = dateCreation;
	}


	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Comment [idC=" + idC + ", description=" + description + ", dateCreation=" + dateCreation + ", User="
				+ User + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((User == null) ? 0 : User.hashCode());
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (idC ^ (idC >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (User == null) {
			if (other.User != null)
				return false;
		} else if (!User.equals(other.User))
			return false;
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
		if (idC != other.idC)
			return false;
		return true;
	}
	
	
	
}
	

	