package com.niit.shopingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopingcart.dao.CategoryDAO;
import com.niit.shopingcart.domain.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@Autowired
	private static Category category;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit"); 
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		category = (Category)context.getBean("category");
	}
	@Test
	public void saveCategoryTestCase()
	{
		category = new Category();
		category.setId("Women-001");
		category.setName("Women");
		category.setDescription("This is Women category");
	  boolean status = 	categoryDAO.save(category);
	  assertEquals("save category test case", true, status);
	}
	
	
	@Test
	public void updateCategoryTestCase()
	{
		category.setId("Mob-001");
		category.setName("Mobile");
		category.setDescription("This is new mobile category");
		boolean status = categoryDAO.update(category);
		assertEquals("update test case", true,status );
	}
	
	@Test
	public void getCategorySuccessTestCase()
	{
		
	category= categoryDAO.get("aul@gmail.com");
	
	assertNotNull("get category test case", category);
	}
	
	@Test
	public void getCategoryFailureTestCase()
	{
		
	category= categoryDAO.get("jai@gmail.com");
	
	assertNull("get category test case", category);
	}
	
	@Test
	public void deleteCategorySuccessTestCase()
	{
	boolean status = categoryDAO.delete("aul@gmail.com");
	assertEquals("delete category succss test case" , true, status);
	
	}
	
	@Test
	public void deleteCategoryFailureTestCase()
	{
	boolean status = categoryDAO.delete("aki@gmail.com");
	assertEquals("delete category failure test case" , false, status);
	}
	
	@Test
	public void getAllCategorysTestCase()
	{
	List<Category> categorys = categoryDAO.list();
	assertEquals("get all usres " , 5, categorys.size() );
	}
}
