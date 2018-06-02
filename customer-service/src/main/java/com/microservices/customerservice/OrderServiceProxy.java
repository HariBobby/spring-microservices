package com.microservices.customerservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.customerservice.entity.Order;

@FeignClient(name="order-service",url="localhost:8000")
public interface OrderServiceProxy {
	
	
	@GetMapping("/orders/{customerid}")
	public List<Order> getOrderByCustomerId(@PathVariable("customerid") Long customerid);
	
	
	

}
