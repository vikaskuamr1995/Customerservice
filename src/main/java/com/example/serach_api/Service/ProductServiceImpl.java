package com.example.serach_api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.serach_api.Entity.Products;
import com.example.serach_api.RepoSitory.ProductsRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductsRepository ProductsRepositorys;

	@Override
	public Products saveProducts(Products product) {
		return ProductsRepositorys.save(product);
	}

	@Override
	public List<Products> SearchProducts(String query) {

		List<Products> listOfProduct = ProductsRepositorys.searchProductQuery(query);
		return listOfProduct;

	}

	@Override
	public List<Products> SearchActiveProducts(String query) {

		List<Products> ActiveProducts = ProductsRepositorys.SearchActiveProducts(query);
		return ActiveProducts;
	}

	@Override
	public List<Products> SearchProductByPrice(String query) {
		List<Products> priceOfProuduct = ProductsRepositorys.SearchProductByPrice(query);
		return priceOfProuduct;
	}

}
