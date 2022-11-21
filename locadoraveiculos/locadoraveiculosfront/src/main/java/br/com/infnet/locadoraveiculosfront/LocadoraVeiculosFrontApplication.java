package br.com.infnet.locadoraveiculosfront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LocadoraVeiculosFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocadoraVeiculosFrontApplication.class, args);
	} 

}
