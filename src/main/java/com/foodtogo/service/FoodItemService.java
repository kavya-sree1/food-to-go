package com.foodtogo.service;

import java.util.List;

import com.foodtogo.model.FoodItem;

public interface FoodItemService {
	List<FoodItem> getAllFoodItems();
	FoodItem saveFoodItem(FoodItem item);
	void deleteFoodItem(int id);
	FoodItem getById(int id);	
}
