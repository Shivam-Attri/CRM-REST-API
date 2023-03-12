package com.customertracker.dao;

import java.util.List;

import com.customertracker.entity.Customer;

public interface CustomerDAO {
	
	List<Customer> getCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomer(int customerId);
	void updateCustomer(Customer customer);
	void deleteCustomer(int customerId);
	List<Customer> searchCustomer(String searchText);
}
