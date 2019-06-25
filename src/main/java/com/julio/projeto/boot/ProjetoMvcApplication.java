package com.julio.projeto.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.julio.projeto.boot"})
public class ProjetoMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoMvcApplication.class, args);
	}

}
