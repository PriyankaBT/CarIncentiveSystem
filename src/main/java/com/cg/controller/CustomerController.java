package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.Customer;
import com.cg.service.CustomerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired 
	public CustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer c) {
		Customer c1 = customerService.addCustomer(c);
		return new ResponseEntity<>(c1, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomers() {
	List<Customer> l1 = customerService.getAllCustomers();
	return new ResponseEntity<List<Customer>>(l1, HttpStatus.OK);
	}

	@GetMapping("/get/{custId}")
	public ResponseEntity<Object> getCustomerById(@PathVariable("custId") Integer custId) {

		Customer c1 = customerService.getCustomerById(custId);
		if (c1 == null) {
			return new ResponseEntity<>("Sorry Customer id not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(c1, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{custId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("custId") Integer custId) {

		ResponseEntity<Object> responseEntity = null;
		customerService.deleteCustomerId(custId);
		responseEntity = new ResponseEntity<>("Customer data deleted successfully", HttpStatus.OK);
		return responseEntity;
	}
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c) {
		Customer c1 = customerService.updateCustomer (c);
		return new ResponseEntity<>(c1, HttpStatus.OK);
	}
}

	


