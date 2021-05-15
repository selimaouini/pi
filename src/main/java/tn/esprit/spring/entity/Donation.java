package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Donation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String amount;
	private String date;
	private String name_event;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName_event() {
		return name_event;
	}

	public void setName_event(String name_event) {
		this.name_event = name_event;
	}

	public Donation(String amount, String date, String name_event) {

		this.amount = amount;
		this.date = date;
		this.name_event = name_event;
	}

	public Donation() {

	}

}
