package com.ricoom.api.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ricoom.api.dao.ProductDao;
import com.ricoom.api.services.ProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProductController {
	
	private ProductService productService;
	
	@PostMapping("/addImage")
	public  ResponseEntity<?> uploadImg(@RequestParam("image") MultipartFile file) {
		
		try {
			productService.addProductImg(file);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<?> download(@RequestBody ProductDao product) {
		try {
			productService.addProduct(product);

		} catch (Exception e) {
return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> removeProduct(@PathVariable("id") long id){
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
