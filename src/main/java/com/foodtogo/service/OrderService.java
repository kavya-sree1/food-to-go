package com.foodtogo.service;

import java.util.List;

import com.foodtogo.model.Order;

public interface OrderService {
	Order addOrder(Order order);
	Order updateOrder(int orderId,Order order);
	Order viewOrder(int orderId);
	List<Order> getAllOrders();

}
