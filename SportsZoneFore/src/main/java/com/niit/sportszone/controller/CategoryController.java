package com.niit.sportszone.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.niit.sportszone.dao.CategoryDAO;
import com.niit.sportszone.model.Category;


@Controller
@RequestMapping("/manageCategories")
public class CategoryController {

	private static Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	
	
	@RequestMapping(value="/categories", method = RequestMethod.GET)
	public String listCategories(Model model){
		log.debug("Start of the method listCategories");
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("category", category);
		log.debug("End of the method listCategory");
		return "category";
	}
	
	
	//saveOrUpdate-> If it is exist, it will override else will create new record
	//save=>if it is exist, will give error. Else it will create new record
	//update->if it is does not exist will give error. Else it will update.
	
	//you have only save method
	// check if the record exist or not
	
	//if the record exist, give error message to admin "The record exist wit this id"
	//else create the record.
	
	
	@RequestMapping(value="/category/add", method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category)
	{	
		ModelAndView mv = new ModelAndView();
		if (categoryDAO.get(category.getId()) == null) {
			log.debug("Starting of the method add category");
			categoryDAO.save(category);
		log.debug("Ending of the method addcategory");
		} else {
			mv.addObject("errorMessage", "The record exist with this id"
					+ category.getId());
		}
		return "category";
		
	}
	
	//categoryDAO.saveOrUpdate
	
	@RequestMapping("category/remove/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") Category id)throws Exception {
		
		boolean flag=categoryDAO.delete(id);
		ModelAndView mv=new ModelAndView("category");
		String msg="Successfully done the operation";
		if(flag!=true)
		{
			msg="the operation could not success";
		}
		mv.addObject("msg",msg);
		
		return mv;
		
	}
	
	@RequestMapping("category/edit/{id}")
	public ModelAndView editCategory(@ModelAttribute("category") Category category)
	{
		//check whether category exist with id or not.
		//if does not exist , give error message
		// if it is exist, you can update the existing category.
		ModelAndView mv= new ModelAndView();
		
		if(categoryDAO.get(category.getId()) !=null)
		{
			categoryDAO.update(category);
			mv.addObject("message","Successfully updated");
		}
		else
		{
			mv.addObject("errorMessage","Couldnot update the record");
		}
		
		return mv;
	}
	
	
}


