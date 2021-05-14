package tn.pi.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProgrammeFidelité {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfidilite;
	
	
	@OneToOne
	private Command command;
	public int getIdfidilite() {
		return idfidilite;
	}
	public void setIdfidilite(int idfidilite) {
		this.idfidilite = idfidilite;
	}
	
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	
}
