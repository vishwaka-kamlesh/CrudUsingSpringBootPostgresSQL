package com.postgrecrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgrecrud.entity.Product;
import com.postgrecrud.repository.ProductRepository;

@RestController
@RequestMapping("/crud")
public class ProductController {

	@Autowired
	ProductRepository repository;
	
	@PostMapping("/product")
	public String createProduct(@RequestBody Product product){
		repository.save(product);
	    return "Product Saved";
	}
	
	@GetMapping("/product")
	public List<Product> getAllProducts(){
		return repository.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable int id) {
		return repository.findById(id).orElse(null);
	}
	
	@PutMapping("/product/{id}")
	public Product updateProduct(@PathVariable int id,@RequestBody Product product) {
		Product existingProduct = repository.findById(id).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return existingProduct;
		
	}
	
	@DeleteMapping("/product/{id}")
	public String deleteProductById(@PathVariable int id) {
		repository.deleteById(id);
		return "Product deleted";
	}
	
	@DeleteMapping("/product/")
	public String deleteAllProducts() {
		repository.deleteAll();
		return "All Products deleted";
	}
	
}

