package com.foodtogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodtogo.model.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem,Integer>{
	FoodItem findByItemName(String name);

}
