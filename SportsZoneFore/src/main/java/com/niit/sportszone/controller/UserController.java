package com.niit.sportszone.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.sportszone.dao.CategoryDAO;
import com.niit.sportszone.dao.UserDetailsDAO;
import com.niit.sportszone.model.Category;
import com.niit.sportszone.model.UserDetails;


@Controller
public class UserController {

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

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value="id") String id,
			@RequestParam(value="password") String password,HttpSession session)
	{
		ModelAndView mv= new ModelAndView("home");
		String msg;
		userDetails=userDetailsDAO.isValidUser(id,password);
		if(userDetails== null)
		{
			msg="Invalid user...please try again";	
		}
		else
		{
			//find out whether the user is admin or not
			if(userDetails.getRole().equals("ROLE_ADMIN")){
				mv=new ModelAndView("adminHome");
			}
			else
			{
				mv.addObject("WelcomeMsg", userDetails.getName());
			}

			session.setAttribute("welcomeMsg", userDetails.getName());
			session.setAttribute("userID", userDetails.getId());
		}
		
		return mv;
	}
	
	@Autowired
	Category category;
	
	
	@Autowired
	CategoryDAO categoryDAO;
	
	
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
