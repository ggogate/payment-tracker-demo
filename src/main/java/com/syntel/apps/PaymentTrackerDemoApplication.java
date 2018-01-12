package com.syntel.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.syntel.apps")
public class PaymentTrackerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentTrackerDemoApplication.class, args);
	}
}
