package tn.pi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.pi.entities.Claim;
import tn.pi.entities.DeliveryMan;
import tn.pi.repositories.deliveryManRepository;

public class deliveryManServicesImpl implements deliveryManServices {
	
	@Autowired
	deliveryManRepository deliveryManRepository;
	
	
	public List<DeliveryMan> retrieveAlleliveryMen() {
		deliveryManRepository.findAll();
		return (List<DeliveryMan>)deliveryManRepository.findAll();

	}

	public DeliveryMan addDeliveryMan(DeliveryMan dm) {
		deliveryManRepository.save(dm);
		return dm;
	}

	public void deleteDeliveryMan(String id) {
		deliveryManRepository.deleteById(Long.parseLong(id));
		
	}

	public DeliveryMan updateDeliveryMan(DeliveryMan dm) {
		deliveryManRepository.save(dm);
		return dm;
	}

	public DeliveryMan retrieveDeliveryMan(String id) {
		deliveryManRepository.findById(Long.parseLong(id));
		return deliveryManRepository.findById(Long.parseLong(id)).orElse(null);
	}

}
