package com.ricoom.api.dao;

import com.ricoom.api.models.ProductImg;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class ProductDao {

	private String productName;
	
	private String prodDescription;


}
