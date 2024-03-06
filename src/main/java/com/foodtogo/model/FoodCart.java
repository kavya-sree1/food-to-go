package com.foodtogo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_table")
public class FoodCart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cartId")
	public int cartId;
	@OneToOne
	@JoinColumn(name="custId",referencedColumnName="custId")
	private Customer customer;
	@OneToOne
	private FoodItem foodItem;

	public FoodCart() {
		super();
	}

	public FoodCart(int cartId, Customer customer, FoodItem foodItem) {
		super();	
		this.cartId = cartId;
		this.customer = customer;
		this.foodItem = foodItem;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public FoodItem getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}

	@Override
	public String toString() {
		return "FoodCart [cartId=" + cartId + ", customer=" + customer + ", foodItem=" + foodItem + "]";
	}
	


}