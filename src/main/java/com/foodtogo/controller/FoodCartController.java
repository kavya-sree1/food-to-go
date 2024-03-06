package com.foodtogo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.foodtogo.exceptions.EmptyCartException;
import com.foodtogo.model.FoodCart;
import com.foodtogo.model.FoodItem;
import com.foodtogo.service.CartServiceImp;
import com.foodtogo.service.FoodItemServiceImp;
import java.util.List;

@Controller
public class FoodCartController {
	@Autowired
	private CartServiceImp cartService;
	@Autowired
	private FoodItemServiceImp foodItemService;

	private static final Logger logger = LogManager.getLogger("FoodcartController.class");

//    @PostMapping("/addToCart")
//    public String addToCart(@RequestParam int itemId,HttpSession session,Model model) {
//    	Integer custId=(Integer)session.getAttribute("custid");
//		List<FoodItem> items=foodItemService.getAllFoodItems();
//    	if(custId==null) {
//    		return "redirect:/login";
//    	}
//    	if(!items.isEmpty()) {
//			model.addAttribute("items",items);
//    	}
//    	cartService.addToCart(custId, itemId);
//    	return "fooditem";
//    }
	@PostMapping("/addToCart")
	public String addToCart(@RequestParam int itemId, Model model) throws EmptyCartException {
		List<FoodItem> items = foodItemService.getAllFoodItems();
		FoodItem item=foodItemService.getById(itemId);
		if (!items.isEmpty()) {
			model.addAttribute("items", items);
		}
		if (item.getAvailability().equals("No")) {
			model.addAttribute("message", "Item is not available");
			logger.info("item is not available : {}", itemId);
		}
		else if(cartService.isItemInCart(itemId)) {
			model.addAttribute("message", "Item added to cart successfully");
		}
		else {
			cartService.addItemToCart(itemId);
			model.addAttribute("message", "Item added to cart successfully");
			logger.info("item added to cart successfully : {}", itemId);
		}
		return "fooditem";
	}

	@PostMapping("/viewc")
	public String getCartsByCustomerId(Model model) throws EmptyCartException {
		List<FoodCart> citems = cartService.findByCartId();
		model.addAttribute("citems", citems);
		int sum = cartService.getTotalPrice(citems);
		if (sum == 0) {
			logger.warn("cart is empty");
			throw new EmptyCartException("<h2>" + "Cart is Empty ! please Add Items" + "</h2");
		}
		model.addAttribute("sum", sum);
		return "viewcart";
	}

	@GetMapping("/viewc")
	public String getCartsById(Model model) throws EmptyCartException {
		List<FoodCart> citems = cartService.findByCartId();
		int sum = cartService.getTotalPrice(citems);
		model.addAttribute("sum", sum);
		if (sum == 0) {
			logger.warn("cart is empty");
			throw new EmptyCartException("<h2>" + "Cart is Empty ! please Add Items" + "</h2");
		}
		model.addAttribute("citems", citems);
		return "viewcart";
	}

	@GetMapping("/deletecart/{cartId}")
	public String deleteFromCart(@PathVariable(value = "cartId") int cartId) {
		cartService.removeFromCart(cartId);
		return "redirect:/viewc";
	}

}
