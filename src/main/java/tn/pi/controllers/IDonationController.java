package tn.pi.controllers;

import java.util.Date;

import tn.pi.entities.Donation;

public interface IDonationController {
	public String save();

	public Donation getDonation();

	public String delete(int id);

	public String modifier(Donation d, String amount, Date date, String name_event);

	public String saveModif();


}
