package com.foodtogo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtogo.model.FoodItem;
import com.foodtogo.repository.FoodItemRepository;

@Service
public class FoodItemServiceImp implements FoodItemService {
	@Autowired
	private FoodItemRepository foodItemRepository;

	@Override
	public List<FoodItem> getAllFoodItems() {
		return foodItemRepository.findAll();
	}

	public List<FoodItem> getAllFoodItemsByIds(List<Integer> foodItemIds) {
		return foodItemRepository.findAllById(foodItemIds);
	}

	@Override
	public FoodItem saveFoodItem(FoodItem item) {
		return foodItemRepository.save(item);
	}

	@Override
	public void deleteFoodItem(int id) {
		foodItemRepository.deleteById(id);
	}

	public FoodItem findByItemName(String name) {
		return foodItemRepository.findByItemName(name);
	}

	@Override
	public FoodItem getById(int id) {
		Optional<FoodItem> optional = foodItemRepository.findById(id);
		FoodItem item = null;
		if (optional.isPresent()) {
			item = optional.get();
		} else {
			throw new RuntimeException(" FoodItem not found for id :: " + id);
		}
		return item;
	}
}