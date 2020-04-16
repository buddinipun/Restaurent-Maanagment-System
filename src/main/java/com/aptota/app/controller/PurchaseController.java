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
import com.aptota.app.model.Item;
import com.aptota.app.model.ItemType;
import com.aptota.app.model.RowMaterial;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.CategoryService;
import com.aptota.app.service.ItemService;
import com.aptota.app.service.MaterialService;
import com.aptota.app.service.PurchaseService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	MaterialService materialService;
	
	@Autowired
	PurchaseService purchasdeService;
	
	 @RequestMapping("row-material/update")
	    public String addCustomer(HttpServletRequest request, Model model) {
	    
					
			       
			        List<RowMaterial> materials = materialService.getAllRowMatrials();
			        
			        model.addAttribute("summary",materials);
		            model.addAttribute("updatePurchase", new RowMaterial()); 
		            
			       
			        return "purchase/row_material";
	    }
	 
	 
	 
	  @RequestMapping(value = "row-material/material.purchase", method = RequestMethod.POST)
	    public ModelAndView addCategory( 
			    		@ModelAttribute("additem") @Validated RowMaterial material,
			            BindingResult bindingResult, HttpServletRequest request,
			            Model model, RedirectAttributes redirectAttributes) {
		 
		  ModelAndView modelAndView = new ModelAndView();
		  Response response = purchasdeService.RowMaterialPurchase(material);
	       
	        if (response.getResCode() == 200) {
	            try {
	            	
	            
	                redirectAttributes.addFlashAttribute("insertStatus", "Success");
	                modelAndView.setViewName("redirect:update");
	                System.out.println("modelAndView is : " + modelAndView.getViewName());
	            } catch (Exception e) {
	            	
	            	redirectAttributes.addFlashAttribute("ErrinsertStatus", "Error in Menu Item creation is : " + e.getMessage());
	 	            modelAndView.setViewName("redirect:update");
	            }
	            return modelAndView;
	        } else if (response.getResCode() == 300) {
	        		
		   	        redirectAttributes.addFlashAttribute("ErrinsertStatus", "Error in Menu Item creation is : " + response.getResDes());
		            modelAndView.setViewName("redirect:update");
	            
	            return modelAndView;
	        } else {
	            try {
	            	
	            	redirectAttributes.addFlashAttribute("ErrinsertStatus", "Failed");
	                redirectAttributes.addFlashAttribute("ErrinsertStatus", "Fails");
	                modelAndView.setViewName("redirect:update");
	                
	            } catch (Exception e) {
	               
	            }
	            return modelAndView;
	        }
		  
		 
		  
		  
	  }
	  
}
