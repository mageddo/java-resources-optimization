package com.mageddo.springjob.user;

import com.mageddo.user.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@RabbitListener(containerFactory = "userFactory", queues = Publisher.queueName)
	public void consume(UserEntity userEntity){
		logger.info("name={}", userEntity.getName());
	}
}
