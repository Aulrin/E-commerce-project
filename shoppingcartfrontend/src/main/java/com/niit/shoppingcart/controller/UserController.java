package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopingcart.dao.UserDAO;
import com.niit.shopingcart.domain.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO  userDAO;
	
	@Autowired
	private User user;
	
	@Autowired
	HttpSession httpSession;
	
	@GetMapping("validate")
	public ModelAndView validate(@RequestParam("uname") String username, @RequestParam("psw") String password)
	
	{
		ModelAndView mv = new ModelAndView("home");
		
		user= userDAO.validate(username, password);
		
		if (user ==null)
		{
			mv.addObject("errorMessage", "Invalid credentials, pl try agin.");
			
		}
		else
		{
			httpSession.setAttribute("welcomeMessage", "Welcome Mr./Ms " + user.getName());
			if(user.getRole()=='A')
			{
				httpSession.setAttribute("isAdmin", true);
			}
		}
		return mv;
	}
}








