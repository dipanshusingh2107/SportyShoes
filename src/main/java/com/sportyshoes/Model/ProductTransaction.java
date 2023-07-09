package com.sportyshoes.Model;

import java.util.Date;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "productTransaction")
public class ProductTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transactionId")
	int transactionId;
	
	@Column
	String username;
	@Column
	long purchaseValue;
	
		
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "productId")
	Product product;
	
	@Column
	@Temporal(TemporalType.DATE)
	Date transactionDate = new Date();
	
	
	
	
	
	
	public ProductTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ProductTransaction(String username, long purchaseValue) {
		super();
	
		this.username = username;
		this.purchaseValue = purchaseValue;
		this.transactionDate = new Date();
	}



	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public long getPurchaseValue() {
		return purchaseValue;
	}


	public void setPurchaseValue(long purchaseValue) {
		this.purchaseValue = purchaseValue;
	}


	public Date getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
