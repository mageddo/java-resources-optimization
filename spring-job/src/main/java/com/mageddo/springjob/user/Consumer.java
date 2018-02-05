package com.mageddo.springjob.user;

import com.mageddo.user.entity.UserEntity;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final AtomicInteger counter = new AtomicInteger(0);
	private StopWatch stopWatch = new StopWatch();

	public Consumer() {
		stopWatch.start();
	}

	@RabbitListener(containerFactory = "userFactory", queues = Publisher.queueName)
	public void consume(UserEntity userEntity){
		logger.info("name={}", userEntity.getName());
		if(counter.incrementAndGet() >= 10_000){
			logger.info("consume-time={}", stopWatch.getTime(TimeUnit.SECONDS));
			stopWatch = new StopWatch();
			stopWatch.start();
			counter.set(0);
		}
	}
}
