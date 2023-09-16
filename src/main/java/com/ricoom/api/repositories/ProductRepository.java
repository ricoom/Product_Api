package com.ricoom.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricoom.api.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	

}
