package com.dev.anh.api_gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@GetMapping("/fallback/user")
	public String userFallback() {
		return "User Service is Down. Please try again later";
	}
	
	@GetMapping("/fallback/order")
	public String orderFallback() {
		 return "Order Service is Down. Please try again later";
	}
	
	
}
