package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Donation;
import tn.esprit.spring.repository.DonationRepository;

@Service
public class DonationServiceImpl implements IDonationService {
	private Donation donation = new Donation();
	private List<Donation> donations;
	@Autowired
	DonationRepository donationRepository;

	@Override
	public String save() {
		donationRepository.save(donation);
		donation = new Donation();
		return "/donation-list.xhtml?faces-redirect=true";
	}

	@Override
	public Donation getDonation() {
		// TODO Auto-generated method stub
		return donation;
	}

	@Override
	public String delete(int id) {
		Donation d = donationRepository.findById(id).get();
		donationRepository.delete(d);
		return "/donation-list.xhtml?faces-redirect=true";
	}

	@Override
	public String modifier(Donation d, String amount, String date, String name_event) {
		donation = d;
		return "/donation-form-modif.xhtml?faces-redirect=true";

	}

	@Override
	public void loadData() {
		donations = (List<Donation>) donationRepository.findAll();
	}

	@Override
	public List<Donation> getDonations() {
		// TODO Auto-generated method stub
		return donations;
	}

	@Override
	public String saveModif() {
		Donation d1 = donationRepository.findById(donation.getId()).get();
		d1.setAmount(donation.getAmount());
		d1.setDate(donation.getDate());
		d1.setName_event(donation.getName_event());
		donationRepository.save(d1);
		donation = new Donation();
		return "/donation-list.xhtml?faces-redirect=true";

	}

}
