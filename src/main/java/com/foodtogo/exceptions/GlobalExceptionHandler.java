package com.foodtogo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(FoodItemNotFoundException.class)
	public ResponseEntity<Object> foodItemNotFoundExceptionHandling(FoodItemNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	@ExceptionHandler(RestaurantNotFoundException.class)
	public ResponseEntity<Object> restaurantNotFoundExceptionHandling(RestaurantNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	@ExceptionHandler(EmptyCartException.class)
	public ResponseEntity<Object> emptyCartExceptionHandling(EmptyCartException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	@ExceptionHandler(NoOrdersPlacedException.class)
	public ResponseEntity<Object> noOrdersPlacedExceptionHandling(NoOrdersPlacedException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}
