package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopingcart.dao.CategoryDAO;
import com.niit.shopingcart.dao.ProductDAO;
import com.niit.shopingcart.domain.Category;
import com.niit.shopingcart.domain.Product;

@Controller
public class HomeController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;

	@GetMapping("/")
	public ModelAndView home(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("home");
		// we need to fetch all the categories
		// Autowire CategoryDAO and category
		List<Category> categories = categoryDAO.list();
		List<Product> products = productDAO.list();
		// add the data to mv
		httpSession.setAttribute("categories", categories);
		httpSession.setAttribute("products",products);
		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedLogin", true);
		return mv;
	}

	@GetMapping("/logout")
	public ModelAndView logout() {
		// at the time of login, we add user id in http session
		// at the time of logout, we need to remove user id from http session.
		ModelAndView mv = new ModelAndView("home");
		httpSession.removeAttribute("isLoggedIn");
		httpSession.removeAttribute("welcomeMessage");
		httpSession.removeAttribute("loggedInUserID");
		mv.addObject("logoutMessage", "You are successfully logged out");
		return mv;
	}

	@RequestMapping("/registration")
	public ModelAndView registration() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedRegister", true);
		return mv;
	}
}