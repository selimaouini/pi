package tn.pi.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	@ManyToOne(cascade = CascadeType.ALL)
	User User ;
	
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

	@Override
	public String toString() {
		return "Chat [idch=" + idch + ", message=" + message + "]";
	}

	public Chat(long idch, String message, tn.pi.entities.User user) {
		super();
		this.idch = idch;
		this.message = message;
		User = user;
	}

	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}


