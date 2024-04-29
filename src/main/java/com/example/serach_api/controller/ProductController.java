package com.example.serach_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.serach_api.Entity.Products;
import com.example.serach_api.Service.ProductServiceImpl;

@RestController
public class ProductController {

	@Autowired
	ProductServiceImpl ProductServiceImpls;

	@PostMapping("/saveProducts")
	public ResponseEntity<Products> saveProdcuts(@RequestBody Products product) {
		Products saveProducts = ProductServiceImpls.saveProducts(product);

		return new ResponseEntity<Products>(saveProducts, HttpStatus.CREATED);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Products>> SearchProduct(@RequestParam("query") String query) {
		List<Products> SearchProduct = ProductServiceImpls.SearchProducts(query);

		return new ResponseEntity<List<Products>>(SearchProduct, HttpStatus.OK);
	}

	@GetMapping("/searchActiveProduct")
	public ResponseEntity<List<Products>> SearchActiveProduct(@RequestParam("query") String query) {
		List<Products> SearchProduct = ProductServiceImpls.SearchActiveProducts(query);

		return new ResponseEntity<List<Products>>(SearchProduct, HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/searchProductByPrice")
	public ResponseEntity<List<Products>> SearchProductByPrice(@RequestParam("query") String query) {
		List<Products> SearchProductByPrice = ProductServiceImpls.SearchProductByPrice(query);

		return new ResponseEntity<List<Products>>(SearchProductByPrice , HttpStatus.OK);
	}
}
