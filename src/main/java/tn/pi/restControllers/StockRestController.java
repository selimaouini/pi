package tn.pi.restControllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.pi.entities.Product;
import tn.pi.entities.Stock;
import tn.pi.services.StockService;

@RestController
public class StockRestController {
	
	@Autowired
	StockService stockservice;
	
	@PutMapping("AddQStock/{prodId}/{quan}")
	@ResponseBody
	public Stock AddQStock(@PathVariable("prodId")int prodID, @RequestBody float quan){
		
		return stockservice.AddQStock(prodID, quan);
	}
	
	
	
	
	@PostMapping("/AddStock")
	@ResponseBody
	public void AddStock(@RequestBody Stock stock){
		
		stockservice.AddStock(stock);		
	}
	
	@GetMapping("GetStock/{prodId}")
	@ResponseBody
	public Stock GetStockByProduct(@PathVariable("prodId") int ProductId){
		
		return stockservice.getStockByProduct(ProductId);
		
	} 

	@GetMapping("/ep")
	@ResponseBody
	public Stock getepuisé() {
		return stockservice.getepuisé();
	}
	
	@GetMapping("/DailyStock")
	@ResponseBody
	public ArrayList<String> DailyStock() {
		return stockservice.DailyStock();
	}
	
	@GetMapping("/ExpirationsNotif")
	@ResponseBody
	public List<Product> ExpirationsNotif() {
		return stockservice.ExpirationsNotif();
	}
	


}