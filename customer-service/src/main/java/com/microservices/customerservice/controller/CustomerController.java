package com.microservices.customerservice.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.customerservice.OrderServiceProxy;
import com.microservices.customerservice.entity.Customer;
import com.microservices.customerservice.entity.Order;

@RestController
@RequestMapping("/Customers")
public class CustomerController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private OrderServiceProxy orderServiceProxy;

	@GetMapping
	public List<Customer> getAllCustomers() {
		return null;
	}

	@GetMapping("/orders/{id}")
	public List<Order> getOrdersByCustomer(@PathVariable("id") Long customerid) {
		

		ResponseEntity<List<Order>> rateResponse = restTemplate.exchange("http://localhost:8000/orders/" + customerid,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Order>>() {
				});
		List<Order> orderList = rateResponse.getBody();
		return orderList;

	}
	
	@GetMapping("/feign/orders/{id}")
	public List<Order> getOrdersByCustomerFeign(@PathVariable("id") Long customerid) {
		
		LOGGER.info("CustomerController -> customer id {}",customerid);
		
		return orderServiceProxy.getOrderByCustomerId(customerid);

	}

}
