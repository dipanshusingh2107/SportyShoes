package com.sportyshoes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	

}
