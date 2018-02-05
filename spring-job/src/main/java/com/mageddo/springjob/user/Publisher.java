package com.mageddo.springjob.user;


import com.mageddo.user.dao.UserRepository;
import com.mageddo.user.entity.UserEntity;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class Publisher {


	public static final String queueName = "user";
	public static final String exchange = "ex-user";

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private UserRepository userRepository;
	
	@Scheduled(fixedDelay = 60000)
	public void notifyUser(){
		logger.info("status=sending...");
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		for (int i = 0; i < 5000; i++) {
			for (UserEntity userEntity : userRepository.findAll()) {
				rabbitTemplate.convertAndSend(exchange, "", userEntity);
			}
		}
		logger.info("status=all-sent!, time={}s", stopWatch.getTime(TimeUnit.SECONDS));
	}
	
	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(exchange);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("");
	}

	@Bean
	SimpleRabbitListenerContainerFactory userFactory(ConnectionFactory connectionFactory) {
		final SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setMaxConcurrentConsumers(10);
		factory.setConnectionFactory(connectionFactory);
		return factory;
	}
}
