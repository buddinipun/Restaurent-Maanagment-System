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

import com.aptota.app.dao.MaterialDao;
import com.aptota.app.model.Item;
import com.aptota.app.model.RowMaterial;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.CategoryService;
import com.aptota.app.service.ItemService;
import com.aptota.app.service.MaterialService;

@Controller
@RequestMapping("/row-material")
public class MaterialController {
	
	
	
	@Autowired
	MaterialService materialservice;
	
	
	 @RequestMapping("material/create")
	    public String addCustomer(HttpServletRequest request, Model model) {
	    
					
			       List<RowMaterial> materils= materialservice.getAllRowMatrials();
			        
			        model.addAttribute("addmaterial", new RowMaterial()); 
		            model.addAttribute("summary",materils);
			        return "item/add_material";
	    }
	 
	 
	 
	  @RequestMapping(value = "material/material.reg", method = RequestMethod.POST)
	    public ModelAndView addCategory( 
			    		@ModelAttribute("addmaterial") @Validated RowMaterial material,
			            BindingResult bindingResult, HttpServletRequest request,
			            Model model, RedirectAttributes redirectAttributes) {
		 
		  ModelAndView modelAndView = new ModelAndView();
		   Response response = materialservice.saveRowMaterial(material);
	       
	        if (response.getResCode() == 200) {
	            try {
	            	
	            
	                redirectAttributes.addFlashAttribute("insertStatus", "Success");
	                modelAndView.setViewName("redirect:create");
	                System.out.println("modelAndView is : " + modelAndView.getViewName());
	            } catch (Exception e) {
	            	
	            	redirectAttributes.addFlashAttribute("ErrinsertStatus", "Error in Row Material creation is : " + e.getMessage());
	 	            modelAndView.setViewName("redirect:create");
	            }
	            return modelAndView;
	        } else if (response.getResCode() == 300) {
	        		
		   	        redirectAttributes.addFlashAttribute("ErrinsertStatus", "Error in Row Material creation is : " + response.getResDes());
		            modelAndView.setViewName("redirect:create");
	            
	            return modelAndView;
	        } else {
	            try {
	            	
	            	redirectAttributes.addFlashAttribute("ErrinsertStatus", "Failed");
	                redirectAttributes.addFlashAttribute("ErrinsertStatus", "Fails");
	                modelAndView.setViewName("redirect:create");
	                
	            } catch (Exception e) {
	               
	            }
	            return modelAndView;
	        }
		  
		 
		  
		  
	  }
	  
}
