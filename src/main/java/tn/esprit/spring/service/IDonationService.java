package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Donation;

public interface IDonationService {
	public String save();

	public Donation getDonation();

	public String delete(int id);

	public String modifier(Donation d, String amount, String date, String name_event);

	public void loadData();

	public List<Donation> getDonations();

	public String saveModif();
	 

}
