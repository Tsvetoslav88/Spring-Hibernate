package org.vexelon.springdemo.service;

import java.util.List;

import org.vexelon.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);
}
