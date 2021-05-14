package tn.pi.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import tn.pi.entities.Bill;
import tn.pi.entities.Cart;
import tn.pi.entities.Command;
import tn.pi.entities.Etat;
import tn.pi.entities.EtatCart;
import tn.pi.entities.LigneComand;

import tn.pi.entities.Product;
import tn.pi.entities.TypeFacture;
import tn.pi.entities.User;
import tn.pi.repositories.IBillRepository;
import tn.pi.repositories.ICartRepository;
import tn.pi.repositories.ICommandRepository;
import tn.pi.repositories.ILigneCommandeRepository;
import tn.pi.repositories.IProductRepository;
import tn.pi.repositories.UserRepository;
@Service
public  class BillService implements IBillService{
	@Autowired
	IBillRepository facrep;
	@Autowired
	UserRepository userep;
	@Autowired
	ICommandRepository comrep;
	
	//recover bill by iduser
		@Override
		public List<Bill> getBillByIduser(int iduser) {
			
			return facrep.getbillByidUser(iduser);
		}

		@Override
		public Bill getBillById(int billId) {
			
			return facrep.findById(billId).get();
		}

		@Override
		public String AddBill(Bill bill) {
			facrep.save(bill);
			return "the Bill is added successfully";
			
		}
		

		@Override
		public double getBillTotalById(int billId) {
		Bill b =facrep.findById(billId).get();
			return b.getTotalfinal();
		}

		@Override
		public String deleteBillById(int billId) {
			
			facrep.deleteById( billId);
			return "the Bill is deleted successfully";
			
		}

		@Override
		public List<Bill> getAllBill() {
		
			return facrep.findAll();
		}

		@Override
		public String addOrUpdateBill(Bill bill) {
			facrep.save(bill);
			return "the Bill is added or updated successfully";
		}

		@Override
		public String addandassignUserABill(Bill bill, int userId) {
		User user = userep.findById(userId).get();	
		bill.setUser(user);
		facrep.save(bill);
		return "the Bill is added and the user is assigned successfully";
			
		}

		@Override
		public Bill find(int numero) {
			
			return facrep.find(numero);
		}

		

		@Override
		public String assignUserABill(int billId, int userId) {
			Bill bill =facrep.findById(billId).get();
			User user=userep.findById(userId).get();
			bill.setUser(user);
			facrep.save(bill);
			return " the user is assigned successfully";
		}

		@Override
		public String assignOrderABill(int billId, int orderId) {
			Bill bill =facrep.findById(billId).get();
			Command order =comrep.findById(orderId).get();
			bill.setCommand(order);
			facrep.save(bill);
			return " the order is assigned successfully";
		}

		@Override
		public String addandassignOrderABill(Bill bill, int orderId) {
			Command order =comrep.findById(orderId).get();
			bill.setCommand(order);
			bill.setTotalfinal(order.getAmountCommand());
			facrep.save(bill);
			return "the Bill is added and the order is assigned successfully";
				
		}

		@Override
		public List<Bill> getBillByIdorder(int idorder) {
			
			return facrep.getbillByIdorder(idorder);
		}

		@Override
		public long count() {
			
			return facrep.count();
		}

		public List<Object[]> getMoyenBillJour( int idcommand,Integer a,Integer m,Integer j){
			return facrep.getMoyenBillJour(idcommand, a, m, j);
		}

		@Override
		public List<Bill> findBYtype(TypeFacture typeofbill) {
			
			return facrep.findByTypeofbill(typeofbill);
		}

		

		

		@Override
		public List<Bill> getBillBydatereglement(Date datereglmt) {
			
			return facrep.findByDatereglement(datereglmt);
		}

		@Override
		public List<Bill> getBillBydatebill(Date datebill) {
			
			return facrep.findByDatebill(datebill);
		}

		@Override
		public List<Bill> getBillBytotalfinalsup() {
			
			return facrep.getBillBytotalfinalsup();
		}

		

		public Bill findonebill(int idbill) {
			return facrep.getOne(idbill);
		}

		

		@Override
		public Bill getBillByuser(int iduser,int idb) {
			Bill b =facrep.findById(idb).get();
			List<User>users=new ArrayList<>();
			users.add(b.getUser());
			for(User u:users) {
			b= facrep.getOne(idb);
		}
		
	return b;
	}}
