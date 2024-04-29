package com.example.serach_api.Service;

import java.util.List;

import com.example.serach_api.Entity.Products;

public interface ProductService {

	Products saveProducts(Products product);
	List<Products>SearchProducts(String query);
	List<Products>SearchActiveProducts(String query);
	List<Products>SearchProductByPrice(String query);
}
