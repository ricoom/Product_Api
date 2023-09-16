package com.ricoom.api.services;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ricoom.api.dao.ProductDao;
import com.ricoom.api.models.Product;
import com.ricoom.api.models.ProductImg;
import com.ricoom.api.repositories.ImgRepository;
import com.ricoom.api.repositories.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
@Transactional
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
  private ProductRepository productRepo; 
  private ImgRepository imgRepo; 

  private static final String FOLDER_PATH="C:\\Users\\ericm\\Documents\\workspace-spring-tool-suite-4-4.19.1.RELEASE\\Product_Api\\prod_images\\";
	@Override
	public ProductImg addProductImg(MultipartFile file) {
		String path=FOLDER_PATH+file.getOriginalFilename();
	
	
	try {
		file.transferTo(new File(path));
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ProductImg myFile= imgRepo.save(new ProductImg(
			file.getOriginalFilename(), file.getContentType(), path));
		return myFile;
	}
	@Override
	public Product addProduct(ProductDao product) {
		Optional<ProductImg> _img=imgRepo.findByname(product.getProductName().concat(".jpg"));
		
		_img.ifPresentOrElse((img)->{
//	      	productRepo.save(new Product(product.getProductName(), product.getProdDescription(), img));
		}, ()->{throw new RuntimeException("please upload image with it's name matching product name");});
		
		return productRepo.save(new Product(product.getProductName(), product.getProdDescription(), _img.get()));

	}
	@Override
	public void deleteProduct(long id) {
		productRepo.deleteById(id);
	}

}
