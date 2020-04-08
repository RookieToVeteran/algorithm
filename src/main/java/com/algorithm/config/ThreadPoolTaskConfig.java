package com.algorithm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: algorithm
 * @description: 连接池配置
 * @author: pengpeng.wang.o
 * @create: 2020-03-26
 **/
@Configuration
public class ThreadPoolTaskConfig {

	/**
	 * 核心线程数
	 */
	private static final Integer CORE_POOL_SIZE = 4;
	/**
	 * 最大线程数
	 */
	private static final Integer MAX_POOL_SIZE  = 10;
	/**
	 * 队列容量
	 */
	private static final Integer QUEUE_CAPACITY  = 100 ;
	/**
	 * 线程活跃时间
	 */
	private static final Integer KEEP_ALIVE_SECOND = 30;
	/**
	 * 自定义线程名称
	 */
	private static final String THREAD_NAME = "capacity-task-";


	/**
	 * 产能服务
	 * @return
	 */
	@Bean(value = "capacityExecutor")
	public Executor executor(){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(CORE_POOL_SIZE);
		executor.setMaxPoolSize(MAX_POOL_SIZE);
		executor.setQueueCapacity(QUEUE_CAPACITY);
		executor.setKeepAliveSeconds(KEEP_ALIVE_SECOND);
		executor.setThreadGroupName(THREAD_NAME);
		executor.initialize();
		return executor;
	}



}
