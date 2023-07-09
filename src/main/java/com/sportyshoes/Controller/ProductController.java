package com.sportyshoes.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.Model.Product;
import com.sportyshoes.Repositories.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	
	@GetMapping("/all")
	public ModelAndView allProducts(){
		List<Product> allProducts = productRepository.findAll();
		ModelAndView page = new ModelAndView("productAllPage");
		page.addObject("allProducts" ,allProducts);
		
		return page;
	}
	
	
	
	
	/*
	 *  Add product 
	 */
	
	@GetMapping("/add") 
	public ModelAndView addProductPage(){
		ModelAndView page = new ModelAndView("productAddPage");
		return page;
	}
	
	@PostMapping(path = "/add" ,consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String addProduct(Product newProduct) {
		
		
		try {
			productRepository.save(newProduct);
		} catch (Exception e) {
			// TODO: handle exception
			return e.getMessage();
		}
		
		return "Product Added "+newProduct.toString();
	}
	
	
	
	/*
	 * Edit Product
	 */
	
	@PutMapping("/edit/{productId}")
	public String editProduct(@RequestParam Map<String, String>req ,@PathVariable("productId") String id) throws Exception{
		
		
		try {
			
			final String productName = req.get("productName");
			final String category = req.get("category");
			final long price = Long.parseLong(req.get("price"));
			final int productId = Integer.parseInt(id);
			
			Product updatedProduct = new Product(productId,
					productName,
					price,
					category);
			
			productRepository.save(updatedProduct);
		}catch (Exception e) {
			throw e;
		}
		
	
		return "Edit done";
	}
	
	
	
	
	/*
	 * Delete Product
	 */
	
	
	
	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable(value="productId") String id) {
		
		try {			
			int productId = Integer.parseInt(id);
			productRepository.deleteById(productId);			
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return "Product deleted successfully";
	}
	
	
	
	
	
}
