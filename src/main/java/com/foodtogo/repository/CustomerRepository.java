package com.foodtogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodtogo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
//     @Query("select customer from Customer customer where customer.email=:name")
// 	 Customer findByName(@Param("name") String name);
//     @Query("select product from Product product where product.name=:param")
//     public List<Product> getListOnCondition(@Param("param") String name);
	Customer findByEmail(String email);
	Customer findByName(String name);
}
