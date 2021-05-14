package tn.pi.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="T_decision")
public class Decision {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private int id_decision;
	@Column (name="date_decision")
	private Date date_decision;
	@Column (name="decision_result")
	private String decision_result;

	@JsonIgnore
	@OneToOne
	private Claim Claim;

	public Decision() {
		super();
	}

	public int getId_decision() {
		return id_decision;
	}

	public void setId_decision(int id_decision) {
		this.id_decision = id_decision;
	}

	public Date getDate_decision() {
		return date_decision;
	}

	public void setDate_decision(Date date_decision) {
		this.date_decision = date_decision;
	}
	
	

	public Decision(String decision_result) {
		super();
		this.decision_result = decision_result;
	}

	public String getDecision_result() {
		return decision_result;
	}

	public void setDecision_result(String decision_result) {
		this.decision_result = decision_result;
	}

	public Claim getClaim() {
		return Claim;
	}

	public void setClaim(Claim claim) {
		Claim = claim;
	}

	public Decision(int id_decision, Date date_decision, String decision_result, tn.pi.entities.Claim claim) {
		super();
		this.id_decision = id_decision;
		this.date_decision = date_decision;
		this.decision_result = decision_result;
		Claim = claim;
	}

	@Override
	public String toString() {
		return "Decision [id_decision=" + id_decision + ", date_decision=" + date_decision + ", decision_result="
				+ decision_result + ", Claim=" + Claim + "]";
	}

	

	}