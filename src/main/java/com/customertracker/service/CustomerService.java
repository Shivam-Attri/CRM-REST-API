package com.customertracker.service;

import java.util.List;
import com.customertracker.entity.Customer;

public interface CustomerService {

	List<Customer> getCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomer(int customerId);
	void saveOrUpdateCustomer(Customer customer);
	void deleteCustomer(int customerId);
	List<Customer> searchCustomer(String searchText);
}
