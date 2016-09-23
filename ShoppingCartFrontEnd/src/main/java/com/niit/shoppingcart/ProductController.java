/*package com.niit.shoppingcart;

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

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;


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
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String listProducts(Model model){
		model.addAttribute("product", new Product());	
		model.addAttribute("category", new Category());	
		model.addAttribute("supplier", new Supplier());	
		model.addAttribute("supplier", new Supplier());	
		model.addAttribute("supplier", new Supplier());	
		model.addAttribute("supplierList", this.supplierDAO.list());	
		return "product";	
	}
	
	
	@RequestMapping(value="product/add", method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product,@RequestParam("image") MultipartFile file){
	Category category=categoryDAO.getByName(product.getCategory().getName());
	Supplier supplier=supplierDAO.getByName(product.getSupplier().getName());
	product.setCategory(category);
	product.setSupplier(supplier);
	
	
		
		
		return "product";
		
	}
	
	@RequestMapping(value="product/remove", method=RequestMethod.POST)
	public String removeProduct(@PathVariable("id") String id, ModelMap model) throws Exception{
	try{
		productDAO.delete(product);
		model.addAttribute("message", "Successfuly added");
	}
	catch(Exception e){
	model.addAttribute("message", e.getMessage());
	e.printStackTrace();
	}
	
	return "product";
}
	
}
*/