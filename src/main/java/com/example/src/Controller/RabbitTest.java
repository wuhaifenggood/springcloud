package com.example.src.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.src.Filter.RabbitHelloSender;
import com.example.src.Filter.fanout.FanoutSender;
import com.example.src.Filter.topic.TopicSender;

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

	@Autowired
    private RabbitHelloSender helloSender1;
	
	@Autowired
	private TopicSender topicSender;
	
	@Autowired
	private FanoutSender fanoutSender;
    
    @PostMapping("/hello")
    public void hello() {
        helloSender1.send();
    }
    
    @PostMapping("/topicTest")
    public void topicTest() {
    	topicSender.send();
    }
    
    @PostMapping("/fanoutTest")
    public void fanoutTest() {
    	fanoutSender.send();
    }

}
