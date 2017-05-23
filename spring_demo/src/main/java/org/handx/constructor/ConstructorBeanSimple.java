package org.handx.constructor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorBeanSimple {

	@Test
	public void testConstructorBean() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-constructor.xml");
		Product battery = (Product) context.getBean("battery");
		Product disc = (Product) context.getBean("disc");
		System.out.println(battery.toString());
		System.out.println(disc.toString());
	}

}
