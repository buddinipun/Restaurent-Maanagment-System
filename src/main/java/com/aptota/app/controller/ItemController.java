package com.aptota.app.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.aptota.app.model.Item;
import com.aptota.app.model.ItemType;
import com.aptota.app.model.RowMaterial;
import com.aptota.app.model.response.AjaxResponse;
import com.aptota.app.model.response.GetItemMaterials;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.CategoryService;
import com.aptota.app.service.ItemService;
import com.aptota.app.service.MaterialService;

@Controller
@RequestMapping("/menu-item")
public class ItemController {
	
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	MaterialService materialservice;
	
	@Autowired
	ItemService itemService;
	
	
	 @RequestMapping("item/create")
	    public String addItem(HttpServletRequest request, Model model) {
	    
					
			        List<Item> items= itemService.getAllMenuItems();
			        List<ItemType> types= categoryService.getAllCategories();
			        
			        model.addAttribute("summary",types);
		            model.addAttribute("additem", new Item()); 
		            
			        model.addAttribute("items",items);
			        return "item/add_item";
	    }
	 
	 @RequestMapping("item/row-material")
	    public String addItemRowMaterial(HttpServletRequest request, Model model) {
	    
					
		 			List<RowMaterial> materils= materialservice.getAllRowMatrials();
		 			model.addAttribute("materils",materils);
			        return "item/item_materials";
	    }
	 
	  @RequestMapping(value = "item/menuItem.reg", method = RequestMethod.POST)
	    public ModelAndView addCategory( 
			    		@ModelAttribute("additem") @Validated Item item,
			            BindingResult bindingResult, HttpServletRequest request,
			            Model model, RedirectAttributes redirectAttributes) {
		 
		  ModelAndView modelAndView = new ModelAndView();
		   Response response = itemService.saveMenuItem(item);
	       
	        if (response.getResCode() == 200) {
	            try {
	            	
	            
	                redirectAttributes.addFlashAttribute("insertStatus", "Success");
	                modelAndView.setViewName("redirect:create");
	                System.out.println("modelAndView is : " + modelAndView.getViewName());
	            } catch (Exception e) {
	            	
	            	redirectAttributes.addFlashAttribute("ErrinsertStatus", "Error in Menu Item creation is : " + e.getMessage());
	 	            modelAndView.setViewName("redirect:create");
	            }
	            return modelAndView;
	        } else if (response.getResCode() == 300) {
	        		
		   	        redirectAttributes.addFlashAttribute("ErrinsertStatus", "Error in Menu Item creation is : " + response.getResDes());
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
	  
	  @RequestMapping(value = "/searchItem", method = RequestMethod.GET)
	    public ResponseEntity<List<String>> searchItem(@RequestParam(value = "term") String q) {
	        System.out.println("Testing String" + q);
	        return new ResponseEntity<List<String>>(itemService.serachItem(q), HttpStatus.OK);
	    }
	  
	  @RequestMapping(value = "/getItemById", method = RequestMethod.GET)
	    public @ResponseBody
	    AjaxResponse getcustomerbyNic(@RequestParam(value = "menuItemPicker") String itemName,
	                                  HttpServletRequest request) throws JSONException, ParseException {
	        System.out.println("within getcustomerbyNic");
	        AjaxResponse ajaxResponse = null;
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (!(auth instanceof AnonymousAuthenticationToken)) {
	            if (auth != null) {
	                UserDetails userDetails = (UserDetails) auth.getPrincipal();
	                Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) auth.getAuthorities();
	              //  System.out.println("success");
	                Response response = itemService.getItemByName(itemName);

	                if (response.getResCode() == 200) {
	                    System.out.println("response.getResCode() == 200");
	                    ajaxResponse = new AjaxResponse("success", (Item) response.getResponse());
	                    return ajaxResponse;
	                } else {
	                    System.out.println("response.getResCode() == 300");
	                    ajaxResponse = new AjaxResponse("Fails", new Item());
	                }


	            } else System.out.println("auth null");



	        } else System.out.println("AnonymousAuthenticationToken");
	        return ajaxResponse;
	    }
	  
	  
	  @RequestMapping(value = "/getItemByName", method = RequestMethod.GET)
	    public @ResponseBody
	    AjaxResponse getItemByName(@RequestParam(value = "menuItemPicker") String name,
	                                  HttpServletRequest request) throws JSONException, ParseException {
	        System.out.println("within getItemByName");
	        AjaxResponse ajaxResponse = null;
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (!(auth instanceof AnonymousAuthenticationToken)) {
	            if (auth != null) {
	                UserDetails userDetails = (UserDetails) auth.getPrincipal();
	                Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) auth.getAuthorities();
	              //  System.out.println("success");
	                Response response = itemService.getItemByName(name);

	                if (response.getResCode() == 200) {
	                    ajaxResponse = new AjaxResponse("success", (Item) response.getResponse());
	                    return ajaxResponse;
	                } else {
	                    System.out.println("response.getResCode() == 300");
	                    ajaxResponse = new AjaxResponse("Fails", new Item());
	                }


	            } else System.out.println("auth null");



	        } else System.out.println("AnonymousAuthenticationToken");
	        return ajaxResponse;
	    }
	  
	  
	  @RequestMapping(value = "/item/setMaterials.do", method = RequestMethod.GET)
		public @ResponseBody AjaxResponse createNewOrder(@RequestParam(value = "jsonString") JSONArray jsonString, @RequestParam(value = "menuItemId") Integer menuItemId,
				HttpServletRequest request) throws JSONException, ParseException {
			AjaxResponse ajaxResponse = new AjaxResponse(null,false);
	        
			Response response2 = null;
			
						if (menuItemId != 0) 
						{	
						response2 = itemService.saveItemMaterials(jsonString, menuItemId);
						ajaxResponse = new AjaxResponse("Successfully saved Item Materials " , response2 , true);
					
						} else {
						ajaxResponse = new AjaxResponse("Null value forTotal Quotgation value" , false);
						}	
				
			return ajaxResponse;

		}
	  
	  
	  
	  @RequestMapping(value = "/item/getItemMaterials", method = RequestMethod.GET)
		public @ResponseBody AjaxResponse getItemMaterials(@RequestParam(value = "itemId") int itemId, 
			HttpServletRequest request) throws JSONException, ParseException {
			AjaxResponse ajaxResponse = new AjaxResponse(null,false);
	        
			Response response = null;
		
						if (itemId != 0) 
						{	
						response = itemService.getItemMaterials(itemId);
						System.out.println(response.getResDes());
						ajaxResponse = new AjaxResponse("Successfully saved Item Materials " , (List<GetItemMaterials>)response.getResponse());
					
						} else {
						ajaxResponse = new AjaxResponse("Null value forTotal Quotgation value" , new ArrayList<>());
						}	
				
			return ajaxResponse;

		}
}
