package com.aptota.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aptota.app.model.ItemType;
import com.aptota.app.model.RestaurentTable;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.CategoryService;

@Controller
@RequestMapping("/menu-Category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/category/create")
	public String menuCategorypageLoad(HttpServletRequest request, Model model) {
		
		List<ItemType> types= categoryService.getAllCategories();
		model.addAttribute("summary",types);
		model.addAttribute("addcategory", new ItemType());
		return "item/menu_category";
	}
	
	
	  @RequestMapping(value = "category/menuCategory.reg", method = RequestMethod.POST)
	    public ModelAndView addCategory( 
	    		@ModelAttribute("addcategory") @Validated ItemType type,
	            BindingResult bindingResult, HttpServletRequest request,
	            Model model, RedirectAttributes redirectAttributes) {
		 
		  ModelAndView modelAndView = new ModelAndView();
		   
	       Response response = categoryService.saveCategory(type);
	       
	        if (response.getResCode() == 200) {
	            try {
//	                
//	                Response responseusers = userDao.getAllWebUsers();
	            	List<ItemType> types= categoryService.getAllCategories();
	                
	            	model.addAttribute("summary",types);
	                redirectAttributes.addFlashAttribute("insertStatus", "Success");
	                modelAndView.setViewName("redirect:create");
	                System.out.println("modelAndView is : " + modelAndView.getViewName());
	            } catch (Exception e) {
	            	 redirectAttributes.addFlashAttribute("ErrinsertStatus", "Error in table creation is : " + e.getMessage());
	 	            modelAndView.setViewName("redirect:create");
	            }
	            return modelAndView;
	        } else if (response.getResCode() == 300) {
	        	List<ItemType> types= categoryService.getAllCategories();
	            
	            redirectAttributes.addFlashAttribute("ErrinsertStatus", "Error in table creation is : " + response.getResDes());
	            modelAndView.setViewName("redirect:create");
	            
	            return modelAndView;
	        } else {
	            try {
	            	List<ItemType> types= categoryService.getAllCategories();
	                
	                redirectAttributes.addFlashAttribute("ErrinsertStatus", "Failed");
	                redirectAttributes.addFlashAttribute("ErrinsertStatus", "Fails");
	                modelAndView.setViewName("redirect:create");
	                
	            } catch (Exception e) {
	               
	            }
	            return modelAndView;
	        }
		  
		 
		  
		  
	  }

}
