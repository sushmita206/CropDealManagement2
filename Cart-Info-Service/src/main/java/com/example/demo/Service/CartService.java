package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CartRepository;

import com.example.demo.entity.CartEntity;

@Service
public class CartService {

	@Autowired
	public CartRepository repo;
	
	//get all Farmer info
	public List<CartEntity> getCartEntityInfo()   
	{  
	List<CartEntity> cartentity = new ArrayList<CartEntity>();  
	repo.findAll().forEach(cartentity1 -> cartentity.add(cartentity1));  
	return cartentity;  
	}
	
	//get Farmer by id
	public CartEntity getcartentityById(int id) {
		return repo.findById(id).get();
	}
	
	//post Farmer info
	public void addCartEntityInfo(CartEntity cartentity) {  
	repo.save(cartentity);  
	}  
	
	//deleting Farmer by id
	public void deleteCartEntityInfo(int id) {
		repo.deleteById(id);
	}
	
	//updating the Farmer
	public void updateCartEntityInfo(int id,CartEntity cartentity) {
		repo.save(cartentity);
	}

}