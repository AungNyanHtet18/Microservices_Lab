package com.dev.anh.api_gateway;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class RateLimiterConfig {

	@Bean
	KeyResolver userKeyResolver() {
	   return exchange -> Mono.just("global-user");
	}
	
	@Bean
	RedisRateLimiter redisRateLimiter() {
	   return new RedisRateLimiter(1, 1); 
	}
}
