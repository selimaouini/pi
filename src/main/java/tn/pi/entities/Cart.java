package tn.pi.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Currency;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Cart implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idcart;
	@PositiveOrZero
	private double subtotal;
	private int nb;
	
	public int getNb() {
		return nb;
	}
	public void setNb(int nb) {
		this.nb = nb;
	}
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	//@Currency(value = { "TND" })
	private String currency;
	@Enumerated(EnumType.STRING)
	private EtatCart etatcart;
	
	@JsonIgnore
	@ManyToOne
	private User user;
	@OneToOne(mappedBy = "cart")
	private Command command;
	@JsonIgnore
	@ManyToMany
	List<Stock>stocks;
	
	public EtatCart getEtatcart() {
		return etatcart;
	}
	public void setEtatcart(EtatCart etatcart) {
		this.etatcart = etatcart;
	}
	public int getIdcart() {
		return idcart;
	}
	public void setIdcart(int idcart) {
		this.idcart = idcart;
	}
	
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}

	

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int idcart, double subtotal, String currency,User user, Command command) {
		super();
		this.idcart = idcart;
		this.subtotal = subtotal;
		
		this.currency = currency;

		this.user = user;
		this.command = command;
	}
	public Cart(double subtotal, String currency, User user, Command command) {
		super();
		this.subtotal = subtotal;
		
		this.currency = currency;

		this.user = user;
		this.command = command;
	}
	/*
	public List<LigneComand> getLignescmd() {
		return lignescmd;
	}
	public void setLignescmd(List<LigneComand> lignescmd) {
		this.lignescmd = lignescmd;
	}
	public UserConsomi getUser() {
		return user;
	}
	public void setUser(UserConsomi user) {
		this.user = user;
	} */
	public Cart(int idcart, Command command) {
		super();
		this.idcart = idcart;
		this.command = command;
	}
	public Cart(Command command) {
		super();
		this.command = command;
	}
	public Cart(int idcart) {
		super();
		this.idcart = idcart;
	}
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Cart(int idcart, @PositiveOrZero double subtotal, int nb, String currency, EtatCart etatcart, User user,
			Command command, List<Stock> stocks) {
		super();
		this.idcart = idcart;
		this.subtotal = subtotal;
		this.nb = nb;
		this.currency = currency;
		this.etatcart = etatcart;
		this.user = user;
		this.command = command;
		this.stocks = stocks;
	}
	@Override
	public String toString() {
		return "Cart [idcart=" + idcart + ", subtotal=" + subtotal + ", nb=" + nb + ", currency=" + currency
				+ ", etatcart=" + etatcart + ", user=" + user + ", command=" + command + ", stocks=" + stocks + "]";
	}
	
	
	
	
	
	}	
	



