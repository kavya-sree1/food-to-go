package com.foodtogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodtogo.model.Customer;
import com.foodtogo.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public Customer registerCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

//	@Override
//	public Customer updateCustomer(int customerId,Customer customer) {
//		Customer existingCustomer=viewCustomerById(customerId);
//		existingCustomer.setName(customer.getName());
//		existingCustomer.setMobileNumber(customer.getMobileNumber());
//		existingCustomer.setAddress(customer.getAddress());
//		existingCustomer.setEmail(customer.getEmail());
//		existingCustomer.setPassword(customer.getPassword());
//		return customerRepository.save(existingCustomer);
//	}

	@Override
	public void removeCustomer(int customerId) {
		customerRepository.deleteById(customerId);
	}

	@Override
	public Customer viewCustomerById(int customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}

	@Override
	public Customer updateCustomer(int customerId, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

}
