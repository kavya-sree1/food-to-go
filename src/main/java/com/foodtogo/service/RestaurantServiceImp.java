package com.foodtogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtogo.model.Restaurant;
import com.foodtogo.repository.RestaurantRepository;

@Service
public class RestaurantServiceImp implements RestaurantService {
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}
	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	public Restaurant getByName(String restName) {
		return restaurantRepository.findByRestName(restName);
	}
	@Override
	public void deleteRestaurant(int id) {
		this.restaurantRepository.deleteById(id);
	}

}
