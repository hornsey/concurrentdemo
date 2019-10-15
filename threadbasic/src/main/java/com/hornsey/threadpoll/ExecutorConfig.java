package com.hornsey.threadpoll;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author hornsey
 * @create 2019/10/14 20:03
 */
@Configuration
public class ExecutorConfig {

	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(10);
		threadPoolTaskExecutor.setMaxPoolSize(20);
		threadPoolTaskExecutor.setKeepAliveSeconds(1200);
		threadPoolTaskExecutor.setQueueCapacity(20);
		threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return threadPoolTaskExecutor;
	}

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	}
}
