package com.siliconasiaworks.microserviceone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;


@Configuration
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceOneApplication.class, args);
		
	}

}

@RefreshScope
@RestController
class MessageRestController {
	@Value("${message}")
	private String message;
	@RequestMapping("/settings")
	String getMessage() throws Exception {
		return message;
	}


}

