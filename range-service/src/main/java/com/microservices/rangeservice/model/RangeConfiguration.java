package com.microservices.rangeservice.model;

public class RangeConfiguration {

	private int maximimum;
	private int minimum;

	public RangeConfiguration() {
		super();
	}

	public RangeConfiguration(int maximimum, int minimum) {
		super();
		this.maximimum = maximimum;
		this.minimum = minimum;
	}

	public int getMaximimum() {
		return maximimum;
	}

	public void setMaximimum(int maximimum) {
		this.maximimum = maximimum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

}
