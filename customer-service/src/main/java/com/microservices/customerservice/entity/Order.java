package com.microservices.customerservice.entity;

import java.util.Date;
import java.util.Set;

public class Order {

	private Long id;
	private Date orderDate;
	private String shippingAddress;
	private String billingAddress;
	private Long customerid;

	private Set<Item> itemList;
	
	private int port;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Set<Item> getItemList() {
		return itemList;
	}

	public void setItemList(Set<Item> itemList) {
		this.itemList = itemList;
	}
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	

	public Long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", shippingAddress=" + shippingAddress
				+ ", billingAddress=" + billingAddress + ", itemList=" + itemList + "]";
	}

}
