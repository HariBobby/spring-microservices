package com.microservices.rangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.rangeservice.model.RangeConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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
	
	
	@GetMapping("/range-fault-tolerance")
	@HystrixCommand(fallbackMethod="fallbackRetrievelimits")
	public RangeConfiguration getLimitsfault() {
		//return new RangeConfiguration(1000, 1);
//connecting to mahesh machine and pull some data - Remote call
		throw new RuntimeException("Not available");
		//return new RangeConfiguration(configuration.getMaximum(), configuration.getMinimum());
		//return new RangeConfiguration(555551, 551);
	}
	
	
	public RangeConfiguration fallbackRetrievelimits()
	{
		//pull local data
		return new RangeConfiguration(6666, 66);
	}
	

}
