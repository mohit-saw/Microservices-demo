package com.siliconasiaworks.microservicetwo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceTwoApplication.class, args);
	}

}

@RefreshScope
@RestController
class MessageRestController {
	@Value("${message}")
	private String message;
	@Value("${spring.application.name}")
	private String appName;
	@RequestMapping("/message")
	String getMessage() throws Exception {
		return message+" from "+appName;
	}


}