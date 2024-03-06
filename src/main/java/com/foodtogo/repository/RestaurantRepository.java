package com.foodtogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodtogo.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>{
	Restaurant findByRestName(String name);
}
