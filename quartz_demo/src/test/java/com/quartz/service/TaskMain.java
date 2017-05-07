package com.quartz.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 测试定时任务 TaskService
 * @author handx 908716835@qq.com
 * @date 2017年5月7日 下午5:28:38
 *
 */

public class TaskMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-quartz.xml");
		context.getBean("scheduler");
	}
}
