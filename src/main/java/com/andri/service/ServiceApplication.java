package com.andri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.andri.service.schedule.Stock.service.Schedule_Run;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class ServiceApplication {
	int i = 0;
	@Autowired
	public Schedule_Run data;

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@Scheduled(fixedRate = 60*60*1000)
	void schedule() {
		System.out.println("test +" + i++);
		data.GetStockDataNormal();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	//@Bean
//	public void doSomethingAfterStartup() {
	//	data.Sotckdata();
	//}

}
