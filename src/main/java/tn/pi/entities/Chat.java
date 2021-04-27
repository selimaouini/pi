package tn.pi.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name="T_CHAT")
public class Chat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idch;
	
	//@Size(min=1,message = " you should insert at least 1 character ")
	@Column(name="message")
	private String message;

	@Temporal(TemporalType.DATE)
    private Date dateCreation;
	
	/**************Associations**************/
	/*@ManyToOne(cascade = CascadeType.ALL)
	User User ;*/
	
	@JsonIgnore
	 @ManyToOne
	 private User sender;
	 
	@JsonIgnore
	  @ManyToOne
	  private User receiver;
	
	public long getIdch() {
		return idch;
	}

	public void setIdch(long idch) {
		this.idch = idch;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	    public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

		public User getSender() {
	        return sender;
	    }

	    public void setSender(User sender) {
	        this.sender = sender;
	    }

	    public User getReceiver() {
	        return receiver;
	    }

	    public void setReceiver(User receiver) {
	        this.receiver = receiver;
	    }

	@Override
	public String toString() {
		return "Chat [idch=" + idch + ", message=" + message + "]";
	}
	
	public Chat(long idch, String message, Date dateCreation, User sender, User receiver) {
		super();
		this.idch = idch;
		this.message = message;
		this.dateCreation = dateCreation;
		this.sender = sender;
		this.receiver = receiver;
	}

	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}


