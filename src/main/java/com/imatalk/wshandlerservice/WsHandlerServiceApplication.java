package com.imatalk.wshandlerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WsHandlerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsHandlerServiceApplication.class, args);
	}

}
