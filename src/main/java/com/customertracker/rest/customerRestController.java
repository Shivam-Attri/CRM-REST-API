package com.customertracker.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customertracker.entity.Customer;
import com.customertracker.exception.CustomerNotFoundException;
import com.customertracker.service.CustomerService;

@RestController
@RequestMapping("/api")
public class customerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId){
		Customer customer=customerService.getCustomer(customerId);
		if(customer==null) {
			throw new CustomerNotFoundException(String.format("Customer with id:%s Not Found",customerId));
		}
		return customer;
	}
}
