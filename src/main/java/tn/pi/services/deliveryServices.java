package tn.pi.services;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;

import tn.pi.entities.DeliveryState;
import tn.pi.entities.Delivery;
import tn.pi.entities.DeliveryCity;
import tn.pi.entities.DeliveryMan;



public interface deliveryServices {
	
	List<Delivery> retrieveAlldeliveries();
	Delivery addDelivery(Delivery d);
	void deleteDelivery(int id);
	public void updateState( int id , DeliveryState etat );
	public void AjouterAffecterCalculerDelivery(Delivery delivery);
	Delivery updateDelivery(Delivery d);
	Delivery retrieveDelivery(int id_delivery);
	public void sendSms(String to, String from, String body);
    void affecterDeliveryManADelivery(int devMan_Id, int delivery_Id);
    public boolean createPdf(List<Delivery> deliveries, ServletContext context, HttpServletRequest request,
			HttpServletResponse response);
    public String upateStateDeliveryToDelivered(int id_delivery);
    public void updateStateDeliveryToAffected(int id_delivery);
    public String cancelDelivery(int id_delivery);
    public Delivery addNewDelivery(@RequestBody Delivery delivery ,  DeliveryCity city, DeliveryState state,DeliveryMan dd);
    public Delivery addNewDeliveryByCommmad( Delivery delivery , int idCommand);

    
}
