package com.example.src.Filter;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "helloQueue")
public class RabbitHelloReceiver {

	@RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }

}
