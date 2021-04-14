package tn.pi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.entities.Delivery;
import tn.pi.entities.DeliveryMan;
import tn.pi.repositories.deliveryRepository;
import tn.pi.repositories.deliveryManRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class deliveryServicesImpl implements deliveryServices {
	
	@Autowired
	deliveryManRepository deliveryManRepository;
	@Autowired
	deliveryRepository deliveryRepository;

	
	public List<Delivery> retrieveAlldeliveries() {
		deliveryRepository.findAll();
		return (List<Delivery>)deliveryRepository.findAll();
	}

	public Delivery addDelivery(Delivery d) {
		deliveryRepository.save(d);
		return d;
	}

	public void deleteDelivery(String id_delivery) {
		deliveryRepository.deleteById(Long.parseLong(id_delivery));
		
	}

	public Delivery updateDelivery(Delivery d) {
		deliveryRepository.save(d);
		return d;
	}

	public Delivery retrieveDelivery(String id_delivery) {
		deliveryRepository.findById(Long.parseLong(id_delivery));
		return deliveryRepository.findById(Long.parseLong(id_delivery)).orElse(null);	}

	
	public void affecterDeliveryManADelivery(int devMan_Id, int delivery_Id) {
		DeliveryMan dm =deliveryManRepository.findById((long) devMan_Id).orElse(null);
		Delivery d = deliveryRepository.findById((long) delivery_Id).orElse(null);
		//dm.setDelivery(d);
		//deliveryManRepository.save(d);
		
	}

}