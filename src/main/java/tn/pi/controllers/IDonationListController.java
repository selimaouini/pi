package tn.pi.controllers;

import java.util.List;

import tn.pi.entities.Donation;

public interface IDonationListController {
	public void loadDate();
	public List<Donation> getDonations();
}
