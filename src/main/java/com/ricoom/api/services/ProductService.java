package com.ricoom.api.services;

import org.springframework.web.multipart.MultipartFile;

import com.ricoom.api.dao.ProductDao;
import com.ricoom.api.models.Product;
import com.ricoom.api.models.ProductImg;

public interface ProductService {
	
	public ProductImg addProductImg(MultipartFile file);
	public Product addProduct(ProductDao product);
	public void deleteProduct(long id);

}
