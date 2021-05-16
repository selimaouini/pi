package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Donation;

public interface IDonationService {
	public String save();

	public Donation getDonation();
	
	public Donation getDonationById(int id);


	public String delete(int id);

	public String modifier(Donation d, String amount, Date date, String name_event);

	public void loadData();

	public List<Donation> getDonations();

	public String saveModif();
	 

}
