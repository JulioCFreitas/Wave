package com.wave.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WaveWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaveWorkerApplication.class, args);
	}

}
