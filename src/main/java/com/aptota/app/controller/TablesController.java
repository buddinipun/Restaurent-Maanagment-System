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

import com.aptota.app.model.RestaurentTable;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.TableService;

@Controller
@Validated
@RequestMapping("/Reaturent")
public class TablesController {
	
	@Autowired
	TableService tableService;
	
	  @RequestMapping("table/create")
	    public String addCustomer(HttpServletRequest request, Model model) {
	    
		    List<RestaurentTable> tables= tableService.getAllTables();
		    System.out.println("1" + tables);
	        model.addAttribute("addTable", new RestaurentTable());
	        model.addAttribute("summary",tables);
	        return "table/table";
	    }
	  
	  
	  
	  @RequestMapping(value = "table/table.reg", method = RequestMethod.POST)
	    public ModelAndView tableRegister( 
	    		@ModelAttribute("addTable") @Validated RestaurentTable table,
	            BindingResult bindingResult, HttpServletRequest request,
	            Model model, RedirectAttributes redirectAttributes) {
		 
		  ModelAndView modelAndView = new ModelAndView();
		   table.setStatus("A");
		   List<RestaurentTable> tables= tableService.getAllTables();
	       Response response = tableService.saveTable(table);
	       
	        if (response.getResCode() == 200) {
	            try {
//	                
//	                Response responseusers = userDao.getAllWebUsers();
	                
	                model.addAttribute("summary",tables);
	                redirectAttributes.addFlashAttribute("insertStatus", "Success");
	                modelAndView.setViewName("redirect:create");
	                System.out.println("modelAndView is : " + modelAndView.getViewName());
	            } catch (Exception e) {
	            	 redirectAttributes.addFlashAttribute("ErrinsertStatus", "Error in table creation is : " + e.getMessage());
	 	            modelAndView.setViewName("redirect:create");
	            }
	            return modelAndView;
	        } else if (response.getResCode() == 300) {

	            redirectAttributes.addFlashAttribute("ErrinsertStatus", "Error in table creation is : " + response.getResDes());
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
