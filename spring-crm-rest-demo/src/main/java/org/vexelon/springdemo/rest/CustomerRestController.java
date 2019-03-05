package org.vexelon.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vexelon.springdemo.entity.Customer;
import org.vexelon.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerSerivce;
	
	
	// add mapping for GET/ customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerSerivce.getCustomers();
	}
	
	// add mapping for GET/ customer/{customerId}
	@GetMapping("customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerSerivce.getCustomer(customerId);
		if(theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found: " + customerId);
		}
		
		return theCustomer;
	}
	
}
