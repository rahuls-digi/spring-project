package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		//read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from sprig container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//check if they are same object
		boolean result= (theCoach==alphaCoach);
		
		System.out.println("\n pointing to the same object "+ "=" + result);
		
		System.out.println("\n memory loction for theCoach "+ "=" + theCoach);
		
		System.out.println("\n memory loction for aplhaCoach "+ "=" + alphaCoach);
		
		//close the context
		context.close();
	}

}
