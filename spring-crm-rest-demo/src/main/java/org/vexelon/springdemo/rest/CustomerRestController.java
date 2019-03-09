package org.vexelon.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	// add mapping for POST/customers - add new customer
	@PostMapping("customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		// also just in case the pass id in JSON ... set id to 0
		theCustomer.setId(0);
		
		customerSerivce.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	// add mapping for PUT/customers - update an existing customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customerSerivce.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
}
