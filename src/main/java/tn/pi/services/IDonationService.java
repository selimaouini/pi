package tn.pi.services;

import java.util.Date;
import java.util.List;

import tn.pi.entities.Donation;

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
