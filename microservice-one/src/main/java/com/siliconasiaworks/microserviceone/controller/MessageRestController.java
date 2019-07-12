package com.siliconasiaworks.microserviceone.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Message Rest controller exposes the dev setting to the user.
 */
@RefreshScope
@RestController
public class MessageRestController {
	@Value("${message}")
	private String message;
	@RequestMapping("/settings")
	String getMessage() throws Exception {
		return message;
	}


}
