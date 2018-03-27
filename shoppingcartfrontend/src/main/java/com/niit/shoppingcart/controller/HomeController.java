package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopingcart.dao.CategoryDAO;
import com.niit.shopingcart.domain.Category;

@Controller
public class HomeController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;
	
	@Autowired
	private HttpSession httpSession;
	
	@GetMapping("/")
	public ModelAndView home() {

		ModelAndView mv = new ModelAndView("home");
		List<Category> categories = categoryDAO.list();
		httpSession.setAttribute("categories", categories);
		return mv;

	}

	@GetMapping("/login")
	public ModelAndView login() {

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedLogin", true);
		return mv;

	}

	@GetMapping("/register")
	public ModelAndView registration() {

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedRegister", true);
		return mv;

	}

}
