package com.dev.anh.order_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceController {

	@Value("${custom.message}")
	private String message;
	
	@GetMapping("/")
	public String orders() {
		 return "Order Service Working";
	}
	
	@GetMapping("/order-config")
	public String config() {
		 return message;
	}
	
}
