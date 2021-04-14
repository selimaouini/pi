package tn.pi.services;

import java.util.List;

import tn.pi.entities.Delivery;



public interface deliveryServices {
	
	List<Delivery> retrieveAlldeliveries();
	Delivery addDelivery(Delivery d);
	void deleteDelivery(String id);
	Delivery updateDelivery(Delivery d);
	Delivery retrieveDelivery(String id_delivery);
    void affecterDeliveryManADelivery(int devMan_Id, int delivery_Id);
}
