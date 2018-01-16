package com.iqmsoft;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	private static final Logger logger = LoggerFactory.getLogger(SimpleController.class);
	
	@RequestMapping("/start")
	public void start() throws InterruptedException {
		log();
	}
	
	@RequestMapping("/startTask")
	public void start(@RequestParam(value="name") String task) throws InterruptedException {
		log();
	}
	
	private void log() throws InterruptedException {
		logger.info("Start: {}", Thread.currentThread().getName());
		TimeUnit.SECONDS.sleep(10);
		logger.info("Stop: {}", Thread.currentThread().getName());
	}
}
