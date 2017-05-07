package com.quartz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public void run() {
		logger.info("==========run===========");
	}
}
