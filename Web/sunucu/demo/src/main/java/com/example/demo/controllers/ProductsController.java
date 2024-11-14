package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.services.CategoryRepository;
import com.example.demo.services.ProductsRepository;

@Controller
@RequestMapping("")
public class ProductsController {
	@Autowired
	private ProductsRepository repo;
	@Autowired
    private CategoryRepository categoryRepository;

    @GetMapping({"/"})
    public String showHomePage(Model model) {
        List<Category> categories = categoryRepository.findAll();
        List<Product> products = repo.findAll();
        model.addAttribute("category", categories);
        model.addAttribute("products", products);
        return "products/index";
    }
    
    @GetMapping("/category/{categoryId}/products")
    public String showProductsByCategory(@PathVariable int categoryId, Model model) {
    	List<Category> categories = categoryRepository.findAll();
    	List<Product> products = repo.findByKategori(categoryId);
        model.addAttribute("products", products);
        model.addAttribute("category", categories);
        return "products/index";
    }
	
	@GetMapping("/search")
    public String searchProduct(@RequestParam("keyword") String keyword, Model model) {
		List<Category> categories = categoryRepository.findAll();
        List<Product> products = repo.findByUrunAdiContaining(keyword);
        model.addAttribute("products", products);
        model.addAttribute("category", categories);
        if (keyword != null && !keyword.isEmpty()) {
        	products = repo.findByUrunAdiContaining(keyword);
        	if (products.isEmpty()) {
                System.out.println("Ürün bulunamadı.");
                products = repo.findAll();
                model.addAttribute("products", products);
                model.addAttribute("category", categories);
            }
        }
        return "products/index";
    }
}
