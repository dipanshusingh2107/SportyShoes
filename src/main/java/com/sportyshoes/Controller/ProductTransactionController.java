package com.sportyshoes.Controller;



import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.Model.Product;
import com.sportyshoes.Model.ProductTransaction;
import com.sportyshoes.Repositories.ProductRepository;
import com.sportyshoes.Repositories.ProductTransactionRepository;


@RestController
@RequestMapping("/transactions")
public class ProductTransactionController {
	
	
	@Autowired
	ProductTransactionRepository productTransactionRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("") //List<ProductTransaction>
	public  List<ProductTransaction> getTransaction(@RequestParam("date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date , @RequestParam Optional<String> category) throws Exception{
		
		if(category.isPresent()) {
			return productTransactionRepository.findByTransactionDateAndProductCategory(date , category.get());
		}
		
		return  productTransactionRepository.findByTransactionDate(date);
	}
	
	@PostMapping("/add")
	public String addProductTransaction(@RequestBody Map<String, String>req)throws Exception {
		System.out.println(req);
		
		try {
			long purchaseValue = Long.parseLong(req.get("purchaseValue"));
			String username = req.get("username");
			int productId = Integer.parseInt(req.get("productId"));
		
			
			ProductTransaction transaction = new ProductTransaction(username , purchaseValue);
			
			Optional<Product> product = productRepository.findById(productId);
			
			transaction.setProduct(product.get());
			productTransactionRepository.save(transaction);
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
		
		return "Added Product Successfully";
	}

}
