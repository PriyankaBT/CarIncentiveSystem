package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Customer;

@Service
public interface CustomerService {
	public Customer addCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(Integer custId);

	public void deleteCustomerId(Integer custId);

	public Customer updateCustomer(Customer c);


}
