package com.quartz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 简单的定时任务service
 * @author handx 908716835@qq.com
 * @date 2017年5月7日 下午5:28:12
 *
 */

public class TaskService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public void run() {
		logger.info("==========run===========");
	}
}
