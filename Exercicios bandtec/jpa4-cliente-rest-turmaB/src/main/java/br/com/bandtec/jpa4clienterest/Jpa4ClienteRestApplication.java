package br.com.bandtec.jpa4clienterest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Jpa4ClienteRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jpa4ClienteRestApplication.class, args);
	}

}
