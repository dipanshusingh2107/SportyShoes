package com.sportyshoes.Repositories;


import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sportyshoes.Model.ProductTransaction;



public interface ProductTransactionRepository extends JpaRepository<ProductTransaction, Integer> {
	
	List<ProductTransaction> findByTransactionDate(Date date);
	
	List<ProductTransaction> findByTransactionDateAndProductCategory(Date date , String category);
		
}