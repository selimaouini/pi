package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Donation;
import tn.esprit.spring.service.IDonationService;
import tn.esprit.spring.service.IEventService;

@Scope(value = "session")
@Component(value = "donationController")
@ELBeanName(value = "donationController")
@Join(path = "/donationForm", to = "/donation-form.jsf")
public class DonationController implements IDonationController{
	@Autowired
	IDonationService iDonationService;
	IEventService iEventService;
	@Override
	public String save() {
		return iDonationService.save() ;
	}

	@Override
	public Donation getDonation() {
		// TODO Auto-generated method stub
		return iDonationService.getDonation();
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return iDonationService.delete(id);
	}

	@Override
	public String modifier(Donation d, String amount, String date, String name_event) {
		// TODO Auto-generated method stub
		return iDonationService.modifier(d, d.getAmount(), d.getDate(), d.getName_event());
	}

	@Override
	public String saveModif() {
		// TODO Auto-generated method stub
		return iDonationService.saveModif();
	}

}
