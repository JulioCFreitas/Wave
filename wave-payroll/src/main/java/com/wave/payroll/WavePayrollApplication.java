package com.wave.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "wave-worker")
@EnableFeignClients
@SpringBootApplication
public class WavePayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(WavePayrollApplication.class, args);
	}

}
