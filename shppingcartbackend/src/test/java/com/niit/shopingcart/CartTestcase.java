package com.niit.shopingcart;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopingcart.dao.CartDAO;
import com.niit.shopingcart.domain.Cart;

public class CartTestcase {
private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CartDAO cartDAO;
	
	@Autowired
	private static Cart cart;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit"); 
		context.refresh();
		cartDAO = (CartDAO)context.getBean("cartDAO");
		cart = (Cart)context.getBean("cart");
	}
	@Test
	public void savecartTestCase()
	{
		cart = new Cart();
boolean status = 	cartDAO.save(cart);
	  assertEquals("save cart test case", true, status);
	}


}
