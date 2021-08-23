package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		//load the spring configuration file
		
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("beanscope-applicationContext2.xml");
				
				//retrieve bean from spring container
				
				Coach theCoach = context.getBean("myCoach",Coach.class);
				
				Coach alphaCoach = context.getBean("myCoach",Coach.class);
				
				//check if they are same
				boolean result =(theCoach == alphaCoach);
				
				System.out.println("\n pointing to the same object" + result);
				
				System.out.println("\n memory location for theCoach"+theCoach);
				
				System.out.println("\n memory location for alphaCoach"+alphaCoach );
				
				context.close();
				
			
				
	}

}
