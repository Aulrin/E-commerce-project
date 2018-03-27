package com.niit.shopingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfiguration {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		context.getBean("user");
		System.out.println("Successfully created instance.");
	}

}