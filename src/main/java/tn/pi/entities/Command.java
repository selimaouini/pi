package tn.pi.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Currency;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Command implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcommand;

	//@Positive(message = "price must be positif")
	private int price;
	//@Currency(value = { "TND" ,"USD","EUR"})
	private String currency;
	@Size(min=4,message = " Description should have at least 4 characters")
	private String description;
	private double AmountCommand;
	private int reduction;
	

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dateCreation;

	
	@Enumerated(EnumType.STRING)
	private  Etat etat;
	
	//@Positive
	private int numcommand;
	//@PositiveOrZero
	private int tva;
	@Enumerated(EnumType.STRING)
	private ModePayement payement;
	private Boolean validpayement;
	
	private String nomuser;
	
	
	
	@OneToOne
    private Cart cart;
	
	
	@OneToOne(mappedBy = "command",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	private Bill bill;
	@JsonIgnore
	@ManyToOne
	private User user;
	
	@OneToOne(mappedBy = "command")
	private ProgrammeFidelité programmefidel;
	
	@OneToOne(mappedBy="commande")
	@JsonIgnore
	private Delivery delivery;
	
	
	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public Command() {
		super();
		
	}



	





	public String getCurrency() {
		return currency;
	}



	public void setCurrency(String currency) {
		this.currency = currency;
	}



	public String getNomuser() {
		return nomuser;
	}



	public void setNomuser(String nomuser) {
		this.nomuser = nomuser;
	}





	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	

	public int getReduction() {
		return reduction;
	}



	public void setReduction(int reduction) {
		this.reduction = reduction;
	}



	public int getIdcommand() {
		return idcommand;
	}

	public void setIdcommand(int idcommand) {
		this.idcommand = idcommand;
	}










	



	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	
	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public int getNumcommand() {
		return numcommand;
	}

	public void setNumcommand(int numcommand) {
		this.numcommand = numcommand;
	}

	public int getTva() {
		return tva;
	}

	public void setTva(int tva) {
		this.tva = tva;
	}

	public ModePayement getPayement() {
		return payement;
	}

	public void setPayement(ModePayement payement) {
		this.payement = payement;
	}

	public Boolean getValidpayement() {
		return validpayement;
	}

	public void setValidpayement(Boolean validpayement) {
		this.validpayement = validpayement;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	
	

	


	

	



	public Delivery getDelivery() {
		return delivery;
	}



	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}



	public double getAmountCommand() {
		return AmountCommand;
	}



	public void setAmountCommand(double amountCommand) {
		AmountCommand = amountCommand;
	}



	public Command(double amountCommand) {
		super();
		AmountCommand = amountCommand;
	}



	public Command(int idcommand, double amountCommand) {
		super();
		this.idcommand = idcommand;
		AmountCommand = amountCommand;
	}



	public Bill getBill() {
		return bill;
	}



	public void setBill(Bill bill) {
		this.bill = bill;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}





	public Command(int idcommand, int price, String currency, String description,
			int reduction, Date dateCreation,  Etat etat, int numcommand, int tva, ModePayement payement,
			Boolean validpayement, Cart cart) {
		super();
		this.idcommand = idcommand;
		this.price = price;
		this.currency = currency;
		this.description = description;
		
		this.dateCreation = dateCreation;
	
		this.etat = etat;
		this.numcommand = numcommand;
		this.tva = tva;
		this.payement = payement;
		this.validpayement = validpayement;
		this.cart = cart;
	   

	}







	public Command(Cart cart) {
		super();
		this.cart = cart;
	}



	public Command(int reduction) {
		super();
		this.reduction = reduction;
	}

	





	public Command(int idcommand, int reduction, Cart cart) {
		super();
		this.idcommand = idcommand;
		this.reduction = reduction;
		this.cart = cart;
	}



	public Command(int idcommand, Cart cart) {
		super();
		this.idcommand = idcommand;
		this.cart = cart;
	}



	public Command(int idcommand, int price, int reduction, Boolean validpayement) {
		super();
		this.idcommand = idcommand;
		this.price = price;
		this.reduction = reduction;
		this.validpayement = validpayement;
	}



	public Command(int idcommand, ModePayement payement) {
		super();
		this.idcommand = idcommand;
		this.payement = payement;
	}



	public Command(int idcommand, int price,  String currency,String description, double amountCommand, int reduction,  Date dateCreation, Etat etat,
			int numcommand, int tva, ModePayement payement, Boolean validpayement, String nomuser, Cart cart, Bill bill,
			User user, ProgrammeFidelité programmefidel, Delivery delivery) {
		super();
		this.idcommand = idcommand;
		this.price = price;
		this.currency = currency;
		this.description = description;
		AmountCommand = amountCommand;
		this.reduction = reduction;
		this.dateCreation = dateCreation;
		this.etat = etat;
		this.numcommand = numcommand;
		this.tva = tva;
		this.payement = payement;
		this.validpayement = validpayement;
		this.nomuser = nomuser;
		this.cart = cart;
		this.bill = bill;
		this.user = user;
		this.programmefidel = programmefidel;
		this.delivery = delivery;
	}



	public Command(int idcommand, Etat etat, ModePayement payement) {
		super();
		this.idcommand = idcommand;
		this.etat = etat;
		this.payement = payement;
	}



	public Command(int idcommand, int price, int paymentterm, String currency,
			String description, double amountCommand, int reduction,  Date dateCreation, Date dateSend,
			Etat etat, int numcommand, int tva, ModePayement payement, Boolean validpayement, Stock stock, Cart cart,
			Bill bill, User user) {
		super();
		this.idcommand = idcommand;
		this.price = price;
		this.currency = currency;
		this.description = description;
		AmountCommand = amountCommand;
		this.reduction = reduction;
		this.dateCreation = dateCreation;
		this.etat = etat;
		this.numcommand = numcommand;
		this.tva = tva;
		this.payement = payement;
		this.validpayement = validpayement;
		//this.stock = stock;
		this.cart = cart;
		this.bill = bill;
		this.user = user;
	}



	public Command(int idcommand, int price, int paymentterm, String currency,
			String description, double amountCommand, int reduction, int increase, Date dateCreation, Date dateSend,
			Etat etat, int numcommand, int tva, ModePayement payement, Boolean validpayement, Cart cart, Bill bill,
			User user, ProgrammeFidelité programmefidel, Delivery delivery) {
		super();
		this.idcommand = idcommand;
		this.price = price;
		this.currency = currency;
		this.description = description;
		AmountCommand = amountCommand;
		this.reduction = reduction;
		this.dateCreation = dateCreation;
		this.etat = etat;
		this.numcommand = numcommand;
		this.tva = tva;
		this.payement = payement;
		this.validpayement = validpayement;
		this.cart = cart;
		this.bill = bill;
		this.user = user;
		this.programmefidel = programmefidel;
		this.delivery = delivery;
	}



	public Command(String description) {
		super();
		this.description = description;
	}



	public ProgrammeFidelité getProgrammefidel() {
		return programmefidel;
	}



	public void setProgrammefidel(ProgrammeFidelité programmefidel) {
		this.programmefidel = programmefidel;
	}



	public Command( String description, double amountCommand, int reduction) {
		super();
		this.description = description;
		AmountCommand = amountCommand;
		
	
		this.reduction = reduction;
	}



	@Override
	public String toString() {
		return "Command [idcommand=" + idcommand + ", price=" + price +  ", currency="
				+ currency  + ", description=" + description
				+ ", AmountCommand=" + AmountCommand + ", reduction=" + reduction 
				+ ", dateCreation=" + dateCreation + ", etat=" + etat + ", numcommand=" + numcommand + ", tva=" + tva
				+ ", payement=" + payement + ", validpayement=" + validpayement + ", nomuser=" + nomuser + ", cart="
				+ cart + ", bill=" + bill + ", user=" + user + ", programmefidel=" + programmefidel + ", delivery="
				+ delivery + "]";
	}



	

	
















}
