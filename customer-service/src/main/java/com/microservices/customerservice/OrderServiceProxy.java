package com.microservices.customerservice;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.customerservice.entity.Order;

//@FeignClient(name="order-service",url="localhost:8001")
@FeignClient(name="order-service")
@RibbonClient(name="order-service")
public interface OrderServiceProxy {
	
	@GetMapping("/orders/{customerid}")
	public List<Order> getOrderByCustomerId(@PathVariable("customerid") Long customerid);

}
