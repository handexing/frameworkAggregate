package org.handx.scanning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-scanning.xml");
		SequenceService sequenceService = (SequenceService) context.getBean("sequenceService");
		System.out.println(sequenceService.generate("IT"));
		System.out.println(sequenceService.generate("IT"));
	}

}
