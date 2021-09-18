package com.andynordevelop.miraiexwrapper.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class ScheduleConfiguration implements SchedulingConfigurer {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		logger.info("setting up executor");
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(6);
		threadPoolTaskScheduler.setThreadNamePrefix("MiraiexThread-");
		threadPoolTaskScheduler.initialize();

		taskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
	}
}
