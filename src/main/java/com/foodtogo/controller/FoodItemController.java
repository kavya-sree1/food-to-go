package com.foodtogo.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.foodtogo.model.FoodItem;
import com.foodtogo.service.FoodItemServiceImp;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FoodItemController {
	@Autowired
	private FoodItemServiceImp foodItemService;
	private static final Logger logger = LogManager.getLogger(FoodItemController.class);

	@PostMapping("/fooditem")
	public String getFoodItems(Model model) {
		List<FoodItem> items = foodItemService.getAllFoodItems();
		if (!items.isEmpty()) {
			model.addAttribute("items", items);
			logger.info("user searched for food items");
			return "fooditem";
		} else {
			model.addAttribute("message", "food item not found");
			logger.warn("food item not found");
			return "home";
		}
	}

	@GetMapping("/fooditem")
	public String getItem() {
		return "fooditem";
	}

	@GetMapping("/fchange")
	public String listFoodItems(Model model, HttpServletRequest request) {
		List<FoodItem> fooditems = foodItemService.getAllFoodItems();
		model.addAttribute("fooditems", fooditems);
		logger.info("owner reached manage food items page");
		return "fchange";
	}

	@PostMapping("/updatefood")
	public String saveFoodItem(@ModelAttribute("item") FoodItem item) {
		foodItemService.saveFoodItem(item);
		logger.info("owner updated food items");
		return "redirect:/fchange";
	}

	@GetMapping("/foodform")
	public String getFoodForm(Model model) {
		FoodItem item = new FoodItem();
		model.addAttribute("item", item);
		logger.info("owner opened food form");
		return "foodform";
	}

	@GetMapping("/foodupdate/{itemId}")
	public String updateFood(@PathVariable(value = "itemId") int itemId, Model model) {
		FoodItem item = foodItemService.getById(itemId);
		model.addAttribute("item", item);
		logger.info("owner updated food item");
		return "foodupdate";
	}

	@GetMapping("/deletefood/{itemId}")
	public String deleteFoodItem(@PathVariable(value = "itemId") int itemId) {
		foodItemService.deleteFoodItem(itemId);
		logger.info("owner deleted food item");
		return "redirect:/fchange";
	}
}
