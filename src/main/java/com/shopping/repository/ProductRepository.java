package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopping.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("from Product where id=:id")
	public Product productFindByID(@Param("id") long Id);
	//@Query(nativeQuery=true, value="select productname from product inner join order_line_item  ON product_id = order_line_item_id inner join user where name=:name and email=:email")
	//public Optional<Product> findShoppingCartDetails(@Param("name") String name, @Param("email") String email);

}
