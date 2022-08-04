

package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CartService;
import com.example.demo.entity.CartEntity;




@RestController
@RequestMapping("/cartController")
public class CartController {
	
	@Autowired
	public CartService entityService;
	
	@GetMapping("/findAll")
	public List<CartEntity> getEntityInfoService(){
		return entityService.getCartEntityInfo();
	}
	
	@GetMapping("/findAll/{id}")  
	public CartEntity getEntityInfoById(@PathVariable("id") int id)   
	{  
		return entityService.getcartentityById(id);
	} 
	
	@PostMapping("/addCart")  
	public CartEntity addCartEntityInfo(@RequestBody CartEntity cartentity)   
	{  
		entityService.addCartEntityInfo(cartentity); 
		return cartentity;  
	}
	
	@PutMapping("/updateCart/{id}")  
	public CartEntity updateCartEntityInfo(@PathVariable("id") int id,@RequestBody CartEntity cartentity)   
	{  
		entityService.updateCartEntityInfo(id,cartentity);
	return cartentity;  
	}  
	
	@DeleteMapping("/deleteCart/{id}")  
	public void deleteCartInfo(@PathVariable("id") int id)   
	{  
		entityService.deleteCartEntityInfo(id);  
	}  

}