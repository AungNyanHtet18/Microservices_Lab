package com.dev.anh.user_service;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserServiceController {

	private AtomicInteger counter = new AtomicInteger(0);
	
	@Value("${custom.message}")
	private String message;
	
	@GetMapping("/")
	public String users(HttpServletRequest request) {
		
		int port = request.getLocalPort();
		
		System.out.println("Request handled by User-Service on port: " + port);
		
		return "User Service running on port " + port;
	}
	
	
	@GetMapping("/fail")
	public String fail(HttpServletRequest request) throws InterruptedException  {
	
		int attempt = counter.incrementAndGet();
		
//	    System.out.println("Attempt: " + attempt + "at" +  LocalTime.now());
		
		int port = request.getLocalPort();
		
		System.out.println("Attempt: " + attempt +
				           " | Port: " + port + 
				           " | Time: " + LocalTime.now());
		
		
		// Stimulate random slowness / instability
		if(Math.random() < 0.7) {
			 Thread.sleep(1500);
			 throw new RuntimeException("Random failure");
		}
		
		counter.set(0);
		return "Service recovered!";
	}
	
	@GetMapping("/user-config")
	public String config() {
		 return message;
	}
	
	
}
