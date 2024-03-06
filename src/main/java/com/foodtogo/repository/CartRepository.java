package com.foodtogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodtogo.model.FoodCart;
@Repository
public interface CartRepository extends JpaRepository<FoodCart,Integer>{
	List<FoodCart> findByCustomerCustId(int custId);
    List<FoodCart> findByFoodItemItemId(int itemId);    
}


