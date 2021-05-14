package tn.pi.services;

import java.util.Date;
import java.util.List;

import tn.pi.entities.Bill;
import tn.pi.entities.TypeFacture;





public interface IBillService {

	 List<Bill> getBillByIduser(int iduser);

	Bill getBillById(int billId);

	String AddBill(Bill bill);

	double getBillTotalById(int billId);

	String deleteBillById(int billId);

	List<Bill> getAllBill();

	String addOrUpdateBill(Bill bill);

	

	public Bill find(int numero);

	public String addandassignUserABill(Bill bill, int userId);

	public String assignUserABill(int billId, int userId);

	public String assignOrderABill(int billId, int orderId);

	public String addandassignOrderABill(Bill bill, int orderId);

	public List<Bill> getBillByIdorder(int idorder);

	public long count();

	public List<Bill> findBYtype(TypeFacture typeofbill);

	public List<Bill> getBillBydatereglement(Date datereglmt);

	public List<Bill> getBillBydatebill(Date datebill);

	public List<Bill> getBillBytotalfinalsup();

	public Bill getBillByuser(int iduser, int idb);

	
	
}
