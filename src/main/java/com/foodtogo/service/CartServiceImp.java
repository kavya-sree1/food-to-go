package com.foodtogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodtogo.model.Customer;
import com.foodtogo.model.FoodCart;
import com.foodtogo.model.FoodItem;
import com.foodtogo.repository.CartRepository;

@Service
public class CartServiceImp implements CartService {
	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<FoodCart> getCartsByCustomerId(int custId) {
		return cartRepository.findByCustomerCustId(custId);
	}

	public List<FoodCart> getCartsByFoodItemId(int itemId) {
		return cartRepository.findByFoodItemItemId(itemId);
	}

	@Override
	public void addToCart(int custId, int itemId) {
		FoodCart cart = new FoodCart();
		Customer customer = new Customer();
		FoodItem item = new FoodItem();
		customer.setCustId(custId);
		cart.setCustomer(customer);
		item.setItemId(itemId);
		cart.setFoodItem(item);
		cartRepository.save(cart);

	}

	@Override
	public void removeFromCart(int cartId) {
		cartRepository.deleteById(cartId);
	}

	@Override
	public void addItemToCart(int itemId) {
		FoodCart cart = new FoodCart();
		FoodItem item = new FoodItem();
		item.setItemId(itemId);
		cart.setFoodItem(item);
		cartRepository.save(cart);
	}

	public List<FoodCart> findByCartId() {
		return cartRepository.findAll();
	}

	public int getTotalPrice(List<FoodCart> carts) {
		int sum = 0;
		for (FoodCart cart : carts) {
			FoodItem item = cart.getFoodItem();
			sum += item.getPrice();
		}
		return sum;
	}

	public boolean isItemInCart(int itemId) {
		List<FoodCart> carts = cartRepository.findAll();
		for (FoodCart cart : carts) {
			FoodItem item = cart.getFoodItem();
			if (item.getItemId() == itemId) {
				return true;
			}

		}
		return false;
	}

//	@Override
//	public void deleteItemFromCart(int itemId) {
//        cartRepository.		
//	}
	@Override
	public void deleteItemFromCart(int itemId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearCart() {
          cartRepository.deleteAll();		
	}

}
