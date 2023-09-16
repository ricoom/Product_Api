package com.ricoom.api.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {
 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String productName;
	@Column(length = 1000)
	private String prodDescription;
	@OneToOne(cascade = CascadeType.ALL)
	private ProductImg prodImg;
	
	
	public Product(String productName, String prodDescription, ProductImg prodImg) {
		
		this.productName = productName;
		this.prodDescription = prodDescription;
		this.prodImg = prodImg;
	}
	
	
	
	
}
