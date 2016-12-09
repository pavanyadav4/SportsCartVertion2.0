package com.niit.shoppingcart;

public class TestCaseProduct {

	/*@Autowired
	ProductDAO productDAO;	//instance of ProductDAO created...
	
	@Autowired
	Product product;		//instance of Product created...
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	Category category;
	
	AnnotationConfigApplicationContext context;		//instance of AnnotationConfigApplicationContext created...
	
	//Initialize test case...
	@Before
	public void init(){		//init is just a method to initialize the instances...
		
		context = new AnnotationConfigApplicationContext();		//object of AnnotationConfigApplicationContext created...
		context.scan("com.niit");		//scan base package of the application...
		context.refresh();		//referesh the application...
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");	
		category = (Category) context.getBean("category");
		supplier = (Supplier) context.getBean("supplier");
		
	}
	
	//@Test
	public void productListTestCase(){		// list operation is used to check the list in database table...
		
		//List<Product> list = productDAO.list();
		//int rowCount = list.size();
		//assertEquals(3, rowCount);		//instead of using these three lines we can use just a single line as follows...
		
		assertEquals(productDAO.list().size(), 4);
		
	}
	
	@Test
	public void productAddTestCase(){		// add operation is used to save/add data in database...
		
		product.setId("PRO001");
		product.setName("PRO_name_001");
		product.setDescription("This is product001 description...");
		product.setPrice(41500);
		
		category.setId("CTG002");
		product.setCategory(category);
		
		supplier.setId("SUP001");
		product.setSupplier(supplier);
		
		
		
		//boolean flag = productDAO.save(product);
		//assertEquals(flag, true);		//instead of using these two lines we can use just a single line as follows...
		
		assertEquals(productDAO.save(product), true);
				
	}
	
	//@Test
	public void productUpdateTestCase(){
		
		product.setId("PRO002");
		product.setName("PRO_name_002");
		product.setDescription("This is product002 description...");
		product.setPrice(11500);
		
		assertEquals(productDAO.update(product), true);
	}
	
	//@Test
	public void productDeleteTestCase(){
		
		product.setId("");
		
		assertEquals(productDAO.delete(product), true);
	}

	//@Test
	public void productGetTestCase(){		// get operation is used to get/fetch data from database...
		
		//product = productDAO.get("PRO001");
		//assertEquals("PRO_name_001", product.getName());		//instead of using these three lines we can use just a single line as follows...
		
		//assertEquals(productDAO.get("PRO001").getName(), "PRO_name_001");
		
		System.out.println("Perfect Match...");
	}*/
	
}
