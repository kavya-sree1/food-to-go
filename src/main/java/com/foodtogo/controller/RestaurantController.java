package com.foodtogo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.foodtogo.exceptions.FoodItemNotFoundException;
import com.foodtogo.exceptions.RestaurantNotFoundException;
import com.foodtogo.model.FoodItem;
import com.foodtogo.model.Restaurant;
import com.foodtogo.service.FoodItemServiceImp;
import com.foodtogo.service.RestaurantServiceImp;

@Controller
public class RestaurantController {
	@Autowired
	private RestaurantServiceImp restaurantService;
	@Autowired
	private FoodItemServiceImp foodItemService;
	private static final Logger logger = LogManager.getLogger(RestaurantController.class);

	@PostMapping("/searchfood")
	public String listRestaurants(Model model, @RequestParam("itemname") String itemname)
			throws FoodItemNotFoundException {
		List<Restaurant> restaurants = restaurantService.getAllRestaurants();
		List<FoodItem> foodItems = foodItemService.getAllFoodItems();
		FoodItem item = foodItemService.findByItemName(itemname);
		if (!foodItems.contains(item)) {
			logger.warn("food item not found :{}", itemname);
			throw new FoodItemNotFoundException("<h2>" + "Food Item Is Not Found!" + "</h2>");
		}
		logger.info("searched food item{}", itemname);
		model.addAttribute("name", itemname);
		model.addAttribute("restaurants", restaurants);
		return "searchfood";
	}

	@GetMapping("/searchfood")
	public String listRest() {
		return "searchfood";
	}

	@PostMapping("/restmenu")
	public String getRestaurantMenu(Model model, @RequestParam("restname") String restname)
			throws RestaurantNotFoundException {
		Restaurant rest = restaurantService.getByName(restname);
		List<Restaurant> restaurants = restaurantService.getAllRestaurants();
		if (!restaurants.contains(rest)) {
			logger.warn("restaurant not found:{}", restname);
			throw new RestaurantNotFoundException("<h2>" + "Restaurant not found!" + "</h2>");
		}
		logger.info("searched for restaurant :{}", restname);
		List<FoodItem> items = foodItemService.getAllFoodItems();
		model.addAttribute("items", items);
		return "fooditem";
	}

	@GetMapping("/restmenu")
	public String getmenu() {
		return "fooditem";
	}
}
