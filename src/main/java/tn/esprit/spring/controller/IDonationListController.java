package tn.esprit.spring.controller;

import java.util.List;

import tn.esprit.spring.entity.Donation;

public interface IDonationListController {
	public void loadDate();
	public List<Donation> getDonations();
}
