package com.foodtogo.service;

import java.util.List;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodtogo.model.Order;
import com.foodtogo.repository.OrderRepository;

@Service
public class OrderServiceImp implements OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order addOrder(Order order) {
		order.setOrderDate(LocalDateTime.now());
		order.setStatus("pending");
		return orderRepository.save(order);
	}

	@Override
	public Order updateOrder(int orderId, Order order) {
		Order existingOrder = orderRepository.findByOrderId(orderId);
		existingOrder.setStatus(order.getStatus());
		return orderRepository.save(existingOrder);
	}

	@Override
	public Order viewOrder(int orderId) {
		return orderRepository.findById(orderId).get();
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
}

//@Override
//public Customer updateCustomer(int customerId,Customer customer) {
//	Customer existingCustomer=viewCustomerById(customerId);
//	existingCustomer.setName(customer.getName());
//	existingCustomer.setMobileNumber(customer.getMobileNumber());
//	existingCustomer.setAddress(customer.getAddress());
//	existingCustomer.setEmail(customer.getEmail());
//	existingCustomer.setPassword(customer.getPassword());
//	return customerRepository.save(existingCustomer);
//}
