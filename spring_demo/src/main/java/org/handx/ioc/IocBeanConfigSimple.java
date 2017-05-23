package org.handx.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocBeanConfigSimple {

	@Test
	public void testIoc() {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc.xml");
		SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator");
		System.out.println(generator.toString());
	}
}
