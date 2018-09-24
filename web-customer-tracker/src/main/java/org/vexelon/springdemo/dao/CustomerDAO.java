package org.vexelon.springdemo.dao;

import java.util.List;

import org.vexelon.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
}
