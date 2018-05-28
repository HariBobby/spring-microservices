package com.microservices.rangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.rangeservice.model.RangeConfiguration;

@RestController
public class RangeController {
/*
	@Value("${range-service.minimum}")
	private int minimum;
	@Value("${range-service.maximum}")
	private int maximum;*/
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/range")
	public RangeConfiguration getLimits() {
		//return new RangeConfiguration(1000, 1);

		return new RangeConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}

}
