package com.iqmsoft;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	private static final Logger logger = LoggerFactory.getLogger(SimpleController.class);
	
	private AtomicInteger a = new AtomicInteger(0);
	
	private ConcurrentHashMap<String, String> c = new ConcurrentHashMap<>();
	
	@RequestMapping("/start")
	public void start() throws InterruptedException {
		a.getAndIncrement();
        c.put("one", "oneall");	
		log();
		
	}
	
	@RequestMapping("/startTask")
	public void start(@RequestParam(value="name") String task) throws InterruptedException {
		
		a.getAndIncrement();
		c.put("two", "twoall");	
		log();
		
	}
	
	private synchronized void log() throws InterruptedException {
		
		logger.info("Concurrent: {}", c.toString());
		
		logger.info("Start: {}", Thread.currentThread().getName());
		TimeUnit.SECONDS.sleep(10);
		logger.info("Stop: {}", Thread.currentThread().getName());
		
		logger.info("Atomic: {}", a.get());
		
	}
}
