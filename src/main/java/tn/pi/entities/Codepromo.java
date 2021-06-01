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

public class Codepromo implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idcode;
	private double Promotion;
	private int codeprom;
	private State state;
	public int getIdcode() {
		return idcode;
	}
	public void setIdcode(int idcode) {
		this.idcode = idcode;
	}
	public double getPromotion() {
		return Promotion;
	}
	public void setPromotion(double promotion) {
		Promotion = promotion;
	}
	public int getCodeprom() {
		return codeprom;
	}
	public void setCodeprom(int codeprom) {
		this.codeprom = codeprom;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Codepromo(int idcode, double promotion, int codeprom, State state) {
		super();
		this.idcode = idcode;
		Promotion = promotion;
		this.codeprom = codeprom;
		this.state = state;
	}
	public Codepromo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Codepromo [idcode=" + idcode + ", Promotion=" + Promotion + ", codeprom=" + codeprom + ", state="
				+ state + "]";
	}
	
	
	
	}	
	



