package com.funnyy.component.queue.queueredis;

import com.funnyy.component.queue.queueredis.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QueueRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Config.class, args);
	}
}
