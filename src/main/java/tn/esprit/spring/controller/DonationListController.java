package tn.esprit.spring.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Donation;
import tn.esprit.spring.service.IDonationService;

@Scope(value = "session")
@Component(value = "donationList")
@ELBeanName(value = "donationList")
@Join(path = "/donations", to = "/donation-list.jsf")
public class DonationListController implements IDonationListController {
	private List<Donation> donations;

	@Autowired
	IDonationService iDonationService;

	@Deferred
	@RequestAction
	@IgnorePostback
	@Override
	public void loadDate() {
		iDonationService.loadData();
	}

	@Override
	public List<Donation> getDonations() {
		donations = iDonationService.getDonations();
		return donations;
	}

}
