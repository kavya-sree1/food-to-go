package com.foodtogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.foodtogo.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{
	Order findByOrderId(int orderId);

}
