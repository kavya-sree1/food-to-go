package com.foodtogo.service;

import java.util.List;
import com.foodtogo.model.FoodCart;
public interface CartService {
      List<FoodCart> getCartsByCustomerId(int custId);
      void addToCart(int custId,int itemId);
      void removeFromCart(int cartId);
      void clearCart();
      void addItemToCart(int itemId);
      void deleteItemFromCart(int itemId);
      
}
