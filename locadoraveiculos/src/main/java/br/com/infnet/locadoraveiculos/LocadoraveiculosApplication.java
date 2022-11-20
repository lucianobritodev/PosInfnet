package br.com.infnet.locadoraveiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LocadoraveiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocadoraveiculosApplication.class, args);
	} 

}
