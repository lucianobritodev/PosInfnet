package com.lucianobrito.infnet.qualityassurencebdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.lucianobrito.infnet.qualityassurencebdd.entities")
public class InfnetQualityAsurrenceBddApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfnetQualityAsurrenceBddApplication.class, args);
	}

}
