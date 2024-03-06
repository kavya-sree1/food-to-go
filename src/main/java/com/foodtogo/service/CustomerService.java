package com.foodtogo.service;
import com.foodtogo.model.Customer;

public interface CustomerService {
     Customer registerCustomer(Customer customer);
     Customer updateCustomer(int customerId,Customer customer);
     void removeCustomer(int customerId);
     Customer viewCustomerById(int customerId);
  //   public List<Customer> viewAllCustomers( customer);
}

