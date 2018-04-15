package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopingcart.dao.CartDAO;
import com.niit.shopingcart.dao.CategoryDAO;
import com.niit.shopingcart.dao.ProductDAO;
import com.niit.shopingcart.domain.Cart;
import com.niit.shopingcart.domain.Category;
import com.niit.shopingcart.domain.Product;

@Controller
public class CartController {
	Logger log = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private Cart cart;
	@Autowired
	private Product product;
	@Autowired
	private HttpSession httpSession;

	@GetMapping("/cart/add/{productID}")
	public ModelAndView addToCart(@PathVariable String productID)

	{
		ModelAndView mv = new ModelAndView("redirect:/");
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		if (loggedInUserID == null) {
			mv.addObject("errorMessage", "Please login to add any product to cart");
			return mv;
		}
		// get the other details of product from productDAO.get()
		product = productDAO.get(productID);
		cart.setEmailID(loggedInUserID);
		cart.setPrice(product.getPrice());
		cart.setProductID(productID);
		cart.setProductName(product.getName());
		cart.setQuantity(1);
		cart.setId(); // to set a random number.
		if (cartDAO.save(cart)) {
			mv.addObject("successMessage", "The product add to cart successfully");
		} else {
			mv.addObject("errorMessage", "Could not add the product to cart..please try after some time");
		}
		return mv;
	}

	// get my cart details
	@GetMapping("/mycart")
	public ModelAndView getMyCartDetails() {
		log.debug("Starting of the method getMyCartDetails");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedMyCart", true);
		// it will return all the products which are added to cart
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		log.info("Logged in user id : " + loggedInUserID);
		if (loggedInUserID == null) {
			mv.addObject("errorMessage", "Please login to see your cart details");
			return mv;
		}
		else
		{
			List<Cart> carts= cartDAO.list(loggedInUserID);
			if (carts==null)
			{
				mv.addObject("noItems", "Your cart is empty");
			}
			else
			{
				mv.addObject("cartDetails", true);
				mv.addObject("cartList", carts);
				mv.addObject("cartSize", carts.size());
				log.debug("No of products in cart"+ carts.size());
				log.debug("Ending of the method getMyCartDetails");
			}
		}return mv;
	}

	@RequestMapping(value = "/deleteFromCart", method = RequestMethod.POST)
	public ModelAndView deleteFromCart(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("redirect:/mycart");
		String loggedInUser = (String) httpSession.getAttribute("loggedInUser");
		cartDAO.delete(id);
		List<Cart> cartList = cartDAO.list(loggedInUser);
		int cartSize = cartList.size();
		httpSession.setAttribute("cartSize", cartSize);
		mv.addObject("cartList", cartList);
		mv.addObject("deleteCartSuccess", true);

		return mv;
	}

	@RequestMapping(value = "/checkout")
	public ModelAndView checkout() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("checkoutClicked", true);
		String loggedInUser = (String) httpSession.getAttribute("loggedInUser");
		List<Cart> cartReview = cartDAO.list(loggedInUser);
		httpSession.setAttribute("cartReview", cartReview);
		int cartsum = cart.getPrice();
		for (Cart a : cartReview) {
			cartsum = cartsum + a.getPrice();
		}
		httpSession.setAttribute("cartsum", cartsum);
		int total = cartsum+100;
		httpSession.setAttribute("total", total);
		return mv;
	}
}