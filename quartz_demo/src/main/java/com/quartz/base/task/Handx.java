package com.quartz.base.task;

import org.apache.log4j.Logger;

public class Handx {

	public final Logger log = Logger.getLogger(this.getClass());

	public void run() {
		log.debug("run=========================");
	}
}
