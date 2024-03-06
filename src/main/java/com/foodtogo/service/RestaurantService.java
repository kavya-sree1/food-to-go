package com.foodtogo.service;

import java.util.List;

import com.foodtogo.model.Restaurant;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    Restaurant saveRestaurant(Restaurant restaurant);
    void deleteRestaurant(int id); 
}
