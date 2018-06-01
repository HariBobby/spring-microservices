package com.microservices.customerservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.customerservice.entity.Customer;
import com.microservices.customerservice.entity.Order;

@RestController
@RequestMapping("/Customers")
public class CustomerController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping
	public List<Customer> getAllCustomers() {
		return null;
	}

	@GetMapping("/orders/{id}")
	public List<Order> getOrdersByCustomer(@PathVariable("id") Long customerid) {
		// List<Order> orderList= (List<Order>)
		// restTemplate.getForObject("http://localhost:8001/orders/"+customerid,
		// Order[].class)
		/*
		 * System.out.println("CustomerService .... Get orders...");
		 * 
		 * ResponseEntity<Order[]> response =
		 * restTemplate.getForEntity("http://localhost:8000/orders/"+customerid,
		 * Order[].class);
		 * 
		 * return Arrays.asList(response.getBody());
		 */

		ResponseEntity<List<Order>> rateResponse = restTemplate.exchange("http://localhost:8000/orders/" + customerid,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Order>>() {
				});
		List<Order> orderList = rateResponse.getBody();
		return orderList;

	}

}
