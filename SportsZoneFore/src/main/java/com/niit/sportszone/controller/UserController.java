package com.niit.sportszone.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.sportszone.dao.CartDAO;
import com.niit.sportszone.dao.CategoryDAO;
import com.niit.sportszone.dao.ProductDAO;
import com.niit.sportszone.dao.SupplierDAO;
import com.niit.sportszone.dao.UserDetailsDAO;
import com.niit.sportszone.model.Cart;
import com.niit.sportszone.model.Category;
import com.niit.sportszone.model.Product;
import com.niit.sportszone.model.Supplier;
import com.niit.sportszone.model.UserDetails;

@Controller
public class UserController {

	Logger log=LoggerFactory.getLogger(UserController.class);
	
	// when the user click login
	// based on the credentials, I want find whether he is admin or not
	// if he is admin, I want to navigate to adminHome page
	// if he is user, I want to navigate to home page
	// if the user does not exist with this credetials, I want to give error
	// message

	@Autowired
	UserDetailsDAO userDetailsDAO;

	@Autowired
	UserDetails userDetails;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Cart cart;

	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDAO productDAO;
	
	
	
	@RequestMapping(value="Login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,HttpSession session)
	{
		log.debug("Start of the method login");
		log.info("userID is{} password is {}",email,password);
		
		ModelAndView mv= new ModelAndView("/Home");
		boolean isValidUser=userDetailsDAO.isValidUser(email,password);
		if(isValidUser == true)
		{
			userDetails = userDetailsDAO.get(email);
			session.setAttribute("loggedInUser", userDetails.getName());
			session.setAttribute("loggedInUserID", userDetails.getEmail());
			session.setAttribute("userDetails", userDetails);
			
			if(userDetails.getRole().equals("ROLE_ADMIN")){
				mv.addObject("isAdmin",true);
				mv.addObject("adminName",userDetails.getName());
				session.setAttribute("supplier", supplier);
				session.setAttribute("supplierList", supplierDAO.list());
				
				session.setAttribute("category", category);
				session.setAttribute("categoryDAO", categoryDAO.list());
				
				session.setAttribute("product", product);
				session.setAttribute("productDAO", productDAO);
				
			}
		else
		{
			mv.addObject("isAdmin", "false");
			mv.addObject("suceessmsg","success msg");
			cart=cartDAO.getCartByCustomerId(email);
			mv.addObject("cart", "cart");
			//Fetch the cart list based on user ID
/*			List<Cart> cartList=cartDAO.list(userID);
			mv.addObject("cartList", cartList);
			mv.addObject("cartsize", cartList.size());*/
			
		}
		} else{
			
			mv.addObject("InvalidCredentials", "true");
		mv.addObject("errorMessage", "Invalid Credentials");
	}
		return mv;
	}
	
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session)
	{
		
		ModelAndView mv= new ModelAndView("/home");
		
		session.invalidate();
		session=request.getSession(true);
		session.setAttribute("category",category);
		session.setAttribute("categoryList",categoryDAO.list());
		
		mv.addObject("logoutMessage","You successfully logged out");
		mv.addObject("loggedOut","true");
		
		return mv;	
	}
}
