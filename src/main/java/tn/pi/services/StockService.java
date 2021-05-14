package tn.pi.services;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.pi.entities.Bill;
import tn.pi.entities.Product;
import tn.pi.entities.Stock;
import tn.pi.repositories.IProductRepository;
import tn.pi.repositories.IStockRepository;


@Service
public class StockService implements IStockService {
	
	@Autowired
	IProductRepository product;
	@Autowired
	IStockRepository stockRepository;

	
	
	@Override
	public Stock AddQStock(int prodID, float quan) {
	
		Product prod= product.findById(prodID).orElse(null);
		Stock st=(Stock) prod.getStock();
		float qex = st.getQuantity();
		float newq=quan + qex;
		st.setQuantity(newq);
		stockRepository.save(st);
		return st;
	}
	
	@Override
	public void AddStock(Stock nstock) {
	
		stockRepository.save(nstock);
	}
	@Override
	public Stock getStockByProduct(int prodID) {
		
		
		Product prod= product.findById(prodID).orElse(null);
		Stock st=stockRepository.findByproducts(prod);
		return st;
	}

 @Override 
 public Stock getepuisé() {
	 return 	 stockRepository.getstockep();
 }
 
	@Override
	public List<Product> ExpirationsNotif() {
		List<Product> productstoCommande=new ArrayList();
		Iterable<Stock> stocks=stockRepository.findAll();
		stocks.forEach(stock ->{
			if(stock.getQuantity() == 0){
			productstoCommande.add((Product) stock.getProducts());
			}
		});
		return productstoCommande;
	}

	@Override
	public String deleteStockById(int StockId) {
		
		stockRepository.deleteById( StockId);
		return "the stock is deleted successfully";
		
	}

	@Override
	public List<Stock> getStock() {
	
		return (List<Stock>) stockRepository.findAll();
	}
	
	@Override
	@Scheduled(cron="0 0 * * * ?")
	public ArrayList<String> DailyStock() {
		// TODO Auto-generated method stub
		ArrayList<String> daily=new ArrayList();
		List<Stock> stocks=(List<Stock>) stockRepository.findAll();		
		for(Stock stock : stocks){
			String name=stock.getProducts().getProductName();
			float quantity=stock.getQuantity();
			//return "Product Name"+name+":"+quantity;
			daily.add("Product Name :"+name+":"+quantity);
		}
		return daily;
		
	}
	
		
	}