package tn.pi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.entities.Bill;
import tn.pi.entities.Product;
import tn.pi.repositories.ICommandRepository;
import tn.pi.repositories.IProductRepository;

@Service
public class ProductService implements IProductService {
	@Autowired
	
	IProductRepository PR;
	
	
	@Override
	public List<Product> getAllProducts() {
	
		return PR.findAll();
	}

}
