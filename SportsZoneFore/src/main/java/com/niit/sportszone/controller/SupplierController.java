package com.niit.sportszone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.niit.sportszone.dao.SupplierDAO;
import com.niit.sportszone.model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	@RequestMapping(value = "/suppliers", method = RequestMethod.GET)
	public String listSuppliers(Model model) {
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		return "supplier";
	}

	@RequestMapping(value = "/supplier/add", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier) {
		// check if the record exist with this id
		// if exist, display error message to the admin record already exist
		// else save the record
		ModelAndView mv = new ModelAndView();
		if (supplierDAO.get(supplier.getId()) == null) {
			supplierDAO.save(supplier);
		} else {
			mv.addObject("errorMessage", "The record exist with this id"
					+ supplier.getId());
		}
		return "redirect:/suppliers";
	}

	@RequestMapping(value = "/supplier/update", method = RequestMethod.POST)
	public String updateSupplier(@ModelAttribute("supplier") String id) {
		// check if the record exist with this id
		// if exist, display error message to the admin record already exist
		// else save the record
		ModelAndView mv = new ModelAndView();
		if (supplierDAO.get(supplier.getId()) != null) {
			supplierDAO.update(supplier);
			mv.addObject("message", "successfully updated");
		} else {
			mv.addObject("errorMessage", "No record exist with this id"
					+ supplier.getId());
		}
		return "redirect:/suppliers";
	}

	@RequestMapping("/supplier/remove/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id)
			throws Exception {
		// if id exist in supplier delete it
		// else display error message
		boolean flag = supplierDAO.delete(supplier);
		ModelAndView mv = new ModelAndView("supplier");
		String msg = "The operation is successfully done";
		if (flag == false) {
			msg = "The operation  could not success";
		}
		mv.addObject("msg", msg);
		return mv;
	}

}