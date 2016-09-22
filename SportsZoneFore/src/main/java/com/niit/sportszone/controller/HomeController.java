package com.niit.sportszone.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.sportszone.dao.CategoryDAO;
import com.niit.sportszone.dao.UserDetailsDAO;
import com.niit.sportszone.model.Category;
import com.niit.sportszone.model.UserDetails;

@Controller
public class HomeController {

	Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@Autowired
	UserDetails userDetails;

	// If you want to navigate to other page with out carrying the data.

	/*
	 * @RequestMapping("/") public String home(){
	 * 
	 * return "Home"; }
	 */

	// If you want navigate to other page with carrying the data.

	@RequestMapping("/")
	public ModelAndView home(HttpSession session) {
		log.debug("Starting of the method onLoad");
		ModelAndView mv = new ModelAndView("Home");
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());
		mv.addObject("message", "Thank you for visiting this url");

		// Get all the categories along with products
		// you have to integrate front project to backend project
		List<Category> categoryList = categoryDAO.list();
		mv.addObject("categoryList", categoryList);
		System.out.println("Size:" + categoryList.size());
		log.debug("Ending of the method onLoad");

		return mv;
	}
	// SPA-Single Page Application

	@Autowired
	UserDetailsDAO userDetailsDAO;

	@RequestMapping(value = "/Registration")
	public ModelAndView register(@ModelAttribute UserDetails userDetails) {
		ModelAndView mv = new ModelAndView("/Registration");

		/*
		 * if(userDetailsDAO.get(userDetails.getEmail() )== null){
		 * userDetailsDAO.save(userDetails);
		 * System.out.println("regitration secessful");
		 * mv.addObject("alert","Registered sucessfully"); } else{
		 * mv.addObject("alert","you have already registered");
		 * return("Home.jsp"); }
		 */
		mv.addObject("RegisterMsg", "you are in register page");
		mv.addObject("userDetails", userDetails);
		mv.addObject("userClickRegisterHere",true);
		return mv;
	}

	@RequestMapping(value = "Registration", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute UserDetails userDetails) {
		
		ModelAndView mv=new ModelAndView("/Home");
		
		userDetailsDAO.save(userDetails);
		mv.addObject("SuccessMessage","You are successfully register");
		System.out.println("At Home controller");
		return mv;

	}

	@RequestMapping(value = "/Login"/*, method = RequestMethod.GET*/)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("/Login");
		mv.addObject("LoginMsg", "you are in login page");
		mv.addObject("userDetails", userDetails);
		mv.addObject("userClickLoginHere", "true");
		return mv;

	}

/*	@RequestMapping(value = "/Admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Admin Page!");
		model.setViewName("admin");

		return model;

	}*/
	
}
