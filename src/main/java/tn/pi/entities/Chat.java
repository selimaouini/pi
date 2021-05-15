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

	@NotNull	
	private LocalDateTime dateCreation= LocalDateTime.now();
	
	private MessageType type;
	private String senderr;

	public enum MessageType {
		CHAT, LEAVE, JOIN
	}

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

		public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
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
	
	public MessageType getType() {
			return type;
		}

		public void setType(MessageType type) {
			this.type = type;
		}

	public String getSenderr() {
			return senderr;
		}

		public void setSenderr(String senderr) {
			this.senderr = senderr;
		}

	public Chat(String message) {
		super();
		this.message = message;
	}
	

	public Chat(long idch, String message) {
		super();
		this.idch = idch;
		this.message = message;
	}

	public Chat(long idch, String message, LocalDateTime dateCreation, User sender, User receiver) {
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


