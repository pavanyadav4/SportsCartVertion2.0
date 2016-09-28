package com.niit.shoppingcart;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.UserDetails;

@Controller
public class HomeController {

	/*
	 * @RequestMapping("/") public String homePage(){ return "Home" }
	 */

	@Autowired
	// to inject the object in the home controller automatically
	CategoryDAO categoryDAO;

	@Autowired
	UserDetailsDAO userDetailsDAO;

	@Autowired
	UserDetails userDetails;

	@Autowired
	ProductDAO productDAO;

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView m = new ModelAndView("Home");
		m.addObject("message", "Hi");
		// get all categories along with products
		// you have to integrate with the backend project
		List<Category> categoryList = categoryDAO.list();
		m.addObject("categoryList", categoryList);
		return m;
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("userDetails") UserDetails userDetails) {
		System.out.println("hi");
		ModelAndView mv = new ModelAndView("/Home");
		// if(userDetailsDAO.get(userDetails.getId())==null){
		userDetailsDAO.save(userDetails);
		mv.addObject("SuccessMessage", "You are successfully register");
		// }
		// else{
		// mv.addObject("failureMessage","user exist with this id");
		// }
		return mv;
	}

	@RequestMapping("/Registration")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("RegisterMsg", "you are in register page");
		mv.addObject("userDetails", userDetails);
		mv.addObject("userClickedRegisterHere", true);
		return mv;
	}

	@RequestMapping("/Login")
	public ModelAndView Login() {
		ModelAndView m = new ModelAndView("/Home");
		m.addObject("LoginMsg", "Login to access SportsZone");
		m.addObject("userDetails", userDetails);
		m.addObject("userClickedLoginHere", true);
		return m;
	}
	
	@RequestMapping("/About")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("RegisterMsg", "you are in register page");
		mv.addObject("userDetails", userDetails);
		mv.addObject("userClickedAboutHere", true);
		return mv;
	}
	
	@RequestMapping("/Home")
	public String getproductl(Model model){

		model.addAttribute("isClickedSportszone", true);	
		return "Home";
	}
	

	@RequestMapping("/productList")
	public String getproductlist(Model model){
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("isClickedProductList", true);	
		return "Home";
	}

}
