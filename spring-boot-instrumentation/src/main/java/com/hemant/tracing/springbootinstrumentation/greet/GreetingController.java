package com.hemant.tracing.springbootinstrumentation.greet;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class GreetingController {
      
    private static final Logger logger = LoggerFactory.getLogger(GreetingService.class);
  
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
      
    private GreetingService greetingService;
 
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
  
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) throws InterruptedException {
        logger.info("Before Service Method Call");
        this.greetingService.doSomeWorkNewSpan();
        logger.info("After Service Method Call");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
