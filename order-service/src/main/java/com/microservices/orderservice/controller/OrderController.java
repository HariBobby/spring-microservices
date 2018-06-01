package com.microservices.orderservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.orderservice.entity.Item;
import com.microservices.orderservice.entity.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private Environment environment;

	@GetMapping
	public List<Order> getOrders() {
		Order order1 = new Order();
		order1.setId(1L);
		order1.setBillingAddress("Billing Adress 1");
		order1.setOrderDate(new Date());
		order1.setShippingAddress("Shipping Adress1");
		order1.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		order1.setCustomerid(1L);

		Item item1 = new Item();
		item1.setId(1L);
		item1.setName("Amazon echo");
		item1.setPrice(4000F);
		item1.setQuantity(2);
		Item item2 = new Item();
		item2.setId(2L);
		item2.setName("Amazon echo");
		item2.setPrice(4000F);
		item2.setQuantity(2);
		Set<Item> itemList = new HashSet<>();
		itemList.add(item1);
		itemList.add(item2);
		order1.setItemList(itemList);

		Order order2 = new Order();
		order2.setId(2L);
		order2.setBillingAddress("Billing Adress 2");
		order2.setOrderDate(new Date());
		order2.setShippingAddress("Shipping Adress2");
		order2.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		order2.setCustomerid(2L);

		Item order2_item1 = new Item();
		order2_item1.setId(7L);
		order2_item1.setName("Music Instrument");
		order2_item1.setPrice(10000F);
		order2_item1.setQuantity(1);
		Item order2_item2 = new Item();
		order2_item2.setId(9L);
		order2_item2.setName("Amazon echo");
		order2_item2.setPrice(4000F);
		order2_item2.setQuantity(2);
		Set<Item> order2_itemList = new HashSet<>();
		order2_itemList.add(order2_item1);
		order2_itemList.add(order2_item2);
		order2.setItemList(order2_itemList);

		List<Order> orderList = new ArrayList<>();
		orderList.add(order1);
		orderList.add(order2);

		return orderList;
	}

	@GetMapping("/{customerid}")
	public List<Order> getOrderByCustomerId(@PathVariable("customerid") Long customerid) {
		
		System.out.println("OrderController:::: getOrderByCustomerId::: "+customerid);

		List<Order> custOrderList = new ArrayList<>();
		List<Order> allOrderList = getOrders();

		for (Order order : allOrderList) {

			if (order.getCustomerid() == customerid) {
				custOrderList.add(order);
			}

		}

		return custOrderList;
	}

}
