package tn.pi.services;

import java.util.ArrayList;
import java.util.List;
import tn.pi.entities.Product;
import tn.pi.entities.Stock;

public interface IStockService {
	
	Stock AddQStock(int prodID, float quan);
	
	void AddStock(Stock stock);
	Stock getStockByProduct(int prodID);

	ArrayList<String> DailyStock();
	List<Product> ExpirationsNotif();
	public List<Stock> getStock();
	public String deleteStockById(int StockId);

	public Stock getepuisé();
}