package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Customer;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	public CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		Customer savedCustomer  = customerRepository.save(customer);
		return savedCustomer;
	}

	@Override
	public List<Customer> getAllCustomers() {
List<Customer> customer =customerRepository.findAll();
		
		return customer;
	}

	@Override
	public Customer getCustomerById(Integer custId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(custId);
		if (optionalCustomer.isEmpty())
			throw new ResourceNotFoundException("Customer Not found with id : " + custId);
		Customer customer = optionalCustomer.get();
		return customer;
	}

	@Override
	public void deleteCustomerId(Integer custId) {
		Customer customer = getCustomerById(custId);
		customerRepository.delete(customer);
	}

	@Override
	public Customer updateCustomer(Customer c) {
		Customer updateCustomer = getCustomerById(c.getCustId());
		updateCustomer = customerRepository.save(c);
		return updateCustomer;
	}
	
}
