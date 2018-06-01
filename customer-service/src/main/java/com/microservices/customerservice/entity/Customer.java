package com.microservices.customerservice.entity;

public class Customer {

	private Long id;
	private String name;
	private String address;
	private String contactnumber;
	private Float credit_limit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public Float getCredit_limit() {
		return credit_limit;
	}

	public void setCredit_limit(Float credit_limit) {
		this.credit_limit = credit_limit;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", contactnumber=" + contactnumber
				+ ", credit_limit=" + credit_limit + "]";
	}

}
