package com.microservices.zipkindistributedserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class ZipkinDistributedServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinDistributedServerApplication.class, args);
	}
}
