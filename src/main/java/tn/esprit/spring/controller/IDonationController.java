package tn.esprit.spring.controller;

import tn.esprit.spring.entity.Donation;

public interface IDonationController {
	public String save();

	public Donation getDonation();

	public String delete(int id);

	public String modifier(Donation d, String amount, String date, String name_event);

	public String saveModif();


}
