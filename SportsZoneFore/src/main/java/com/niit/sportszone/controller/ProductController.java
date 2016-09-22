package com.niit.sportszone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.sportszone.dao.CategoryDAO;
import com.niit.sportszone.dao.ProductDAO;
import com.niit.sportszone.dao.SupplierDAO;
import com.niit.sportszone.model.Category;
import com.niit.sportszone.model.Product;
import com.niit.sportszone.model.Supplier;
import com.niit.sportszone.util.FileUtil;




@Controller
public class ProductController {

	@Autowired
	private Category category;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Supplier supplier;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Product product;

	@Autowired
	private ProductDAO productDAO;

	private String path = "D:\\sportszone\\img";

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("category", new Category());
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplierList", this.supplierDAO.list());
		return "product";
	}

	// for add and update product both
	@RequestMapping(value = "product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile file) {

		Category category = categoryDAO.getByName(product.getCategory().getName());

		Supplier supplier = supplierDAO.getByName(product.getSupplier().getName());

		product.setCategory(category);
		product.setSupplier(supplier);
		
		product.setCategory(category);
		product.setSupplier(supplier);
		productDAO.save(product);
		
		MultipartFile file1=product.getImage();
		
		FileUtil.upload(path, file1, product.getId()+".jpg");
		
		return "redirect:/products";
		
		//return "redirect:/uploadFile";

	}

	@RequestMapping(value = "product/remove/{id}", method = RequestMethod.POST)
	public String removeProduct(@PathVariable("id") String id, ModelMap model) throws Exception {
		try {
			productDAO.delete(product);
			model.addAttribute("message", "Successfuly added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/product";
	}
	
	@RequestMapping("product/edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model){
		System.out.println("editProduct");
		model.addAttribute("product", this.productDAO);
		model.addAttribute("listProducts", this.categoryDAO);
		model.addAttribute("supplierList", this.supplierDAO);
		return "product";
	}
	
	@RequestMapping("product/get/{id}")
	public String getSelectedProduct(@PathVariable("id") String id, Model model,
			RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute("selectedProduct", productDAO.get(id));
		return "product";
	}
	
	@RequestMapping(value="/backToHome",method=RequestMethod.GET)
	public String backToHome(@ModelAttribute("selectedProduct")
	final Object selectedProduct, final Model model) {
		
		model.addAttribute("selectedProduct", selectedProduct);
		//model.addAttribute("categoryList",this.categoryDAO.list());
		return "/Home";
	}
	
}
