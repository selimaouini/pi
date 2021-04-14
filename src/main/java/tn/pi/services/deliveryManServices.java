package tn.pi.services;

import java.util.List;

import tn.pi.entities.DeliveryMan;

public interface deliveryManServices  {
	List<DeliveryMan> retrieveAlleliveryMen();
	DeliveryMan addDeliveryMan(DeliveryMan dm);
	void deleteDeliveryMan(String id);
	DeliveryMan updateDeliveryMan(DeliveryMan dm);
	DeliveryMan retrieveDeliveryMan(String id);

}
