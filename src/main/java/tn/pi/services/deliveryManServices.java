package tn.pi.services;


import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tn.pi.entities.DeliveryMan;
import tn.pi.entities.DeliveryState;


public interface deliveryManServices  {
	List<DeliveryMan> retrieveAlleDliveryMen();
	public DeliveryMan addDeliveryMan(DeliveryMan DeliveryMan);
     public void deleteDeliveryMan(int id);
	DeliveryMan updateDeliveryMan(DeliveryMan dm);
	DeliveryMan retrieveDeliveryMan(int id);
	boolean createExcel(List<DeliveryMan> DeliveryMen, ServletContext context, HttpServletRequest request,
			HttpServletResponse response);
	//List<DeliveryMan> getdeliveryManOfMonth();
	public Map<String, Integer> getdeliveryManOfMonth();
	public DeliveryMan updateAvailibilityToTrue( int id);
	public DeliveryMan updateAvailibilityToFalse( int id);
	public DeliveryMan getById(int id);
}
