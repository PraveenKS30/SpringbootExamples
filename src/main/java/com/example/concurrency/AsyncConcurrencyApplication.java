package com.example.concurrency;

import com.example.concurrency.dao.User;
import com.example.concurrency.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@EnableAsync
@SpringBootApplication
public class AsyncConcurrencyApplication  {

	public static void main(String[] args) {
		SpringApplication.run(AsyncConcurrencyApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
