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
@Table(name="fooditem_table")
public class FoodItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="itemId")
    private int itemId;
	@Column(name="itemName")
	private String itemName;
	@Column(name="price")
    private int price;
	@Column(name="availability")
	private String availability;
	@Column(name="imageUrl")
	private String imageUrl;
	@OneToOne
	@JoinColumn(name="restId",referencedColumnName="restId")
	private Restaurant restaurant;
	public FoodItem() {
		super();
	}
	public FoodItem(int itemId, String itemName, int price, String availability, Restaurant restaurant,String imageUrl) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.availability = availability;
		this.restaurant = restaurant;
		this.imageUrl=imageUrl;
				}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return itemName;
	}
	


}


