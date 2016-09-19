package com.niit.sportszone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.sportszone.dao.SupplierDAO;
import com.niit.sportszone.model.Supplier;

@Controller
public class SupplierController {
	
	private SupplierDAO supplierDAO;
	
	@Autowired(required=true)
	@Qualifier(value="supplierDAO")
	public void setSupplierDAO(SupplierDAO ps)
	{
		this.supplierDAO=ps;
	}
	
	@RequestMapping(value="/suppliers", method=RequestMethod.GET)
	public String listSuppliers(Model model)
	{
		model.addAttribute("supplier",new Supplier());
		model.addAttribute("supplierList",this.supplierDAO.list());
		return "supplier";
	}
	
	//for add and update supplier both
	@RequestMapping(value="/supplier/add", method=RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier)
	{
		supplierDAO.save(supplier);
		return "supplier";
	}
	
	@RequestMapping("supplier/edit/{id}")
	public ModelAndView editSupplier(@ModelAttribute("supplier") Supplier supplier)
	{
		//check whether supplier exist with id or not.
		//if does not exist , give error message
		// if it is exist, you can update the existing supplier.
		ModelAndView mv= new ModelAndView();
		
		if(supplierDAO.get(supplier.getId()) !=null)
		{
			supplierDAO.update(supplier);
			mv.addObject("message","Successfully updated");
		}
		else
		{
			mv.addObject("errorMessage","Could update the record");
		}
		
		return mv;
	}
	
	@RequestMapping("supplier/remove/{id}")
	public String removeSupplier(@PathVariable("id") Supplier id, ModelMap model)throws Exception
	{
		
		try{
			supplierDAO.delete(id);
			model.addAttribute("message","Successfully Added");
		}
		catch(Exception e){
			model.addAttribute("message",e.getMessage());
			e.printStackTrace();
		}
		//redirectAttrs.addFlashAttributes(arg0, arg1))
		return "redirect:/suppliers";
		
	}
	
	
}
