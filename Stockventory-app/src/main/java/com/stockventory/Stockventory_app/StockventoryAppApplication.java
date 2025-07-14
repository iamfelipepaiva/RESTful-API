package com.stockventory.Stockventory_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockventoryAppApplication {

//http://localhost:8080/swagger-ui/index.html#/ - SWAGGER ACCESS
//http://localhost:8080/h2-console - DB ACCESS

	public static void main(String[] args) {
		SpringApplication.run(StockventoryAppApplication.class, args);
	}

}
