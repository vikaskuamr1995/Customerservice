package com.example.serach_api.RepoSitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.serach_api.Entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
	
	
	@Query(value="SELECT * from products p WHERE p.product_name"
			+ " LIKE CONCAT ('%',:query,'%') "
			+ "or p.description LIKE CONCAT ('%',:query,'%')",nativeQuery = true)
	List<Products>searchProductQuery(String query);
	
	
	@Query(value="select * from products p where p.status=:query",nativeQuery = true)
	List<Products>SearchActiveProducts(String query);
	
	@Query(value="select * from products p where p.product_price<:query",nativeQuery = true)
	List<Products>SearchProductByPrice(String query);

}
