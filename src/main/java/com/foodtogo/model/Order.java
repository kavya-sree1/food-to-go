package com.foodtogo.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_table")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orderId")
	private int orderId;
	@Column(name="order_date")
	private LocalDateTime orderDate;
	@Column(name="status")
	private String status;
	@OneToOne
	@JoinColumn(name="cartId",referencedColumnName="cartId")
	private FoodCart cart;
	@OneToOne
	@JoinColumn(name="itemId",referencedColumnName="itemId")
	private FoodItem item;
	@ManyToOne
	@JoinColumn(name="custId",referencedColumnName="custId")
	private Customer customer;
	public Order() {
		super();
	}
    
	public Order(int orderId,LocalDateTime orderDate, String status, FoodCart cart, FoodItem item, Customer customer) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.status = status;
		this.cart = cart;
		this.item = item;
		this.customer = customer;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public FoodItem getItem() {
		return item;
	}
	public void setItem(FoodItem item) {
		this.item = item;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public FoodCart getCart() {
		return cart;
	}
	public void setCart(FoodCart cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return " OrderId= " + orderId +"\n"+ "    ,orderDate= " + orderDate+"\n"+ "    ,customerId=" + customer.getCustId();
	}
}
