package com.microservices.rangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class RangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RangeServiceApplication.class, args);
	}
}
