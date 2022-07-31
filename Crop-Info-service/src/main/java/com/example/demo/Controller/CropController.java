package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CropEntity;
import com.example.demo.repository.CropRepository;

@RestController
@RequestMapping("/crop")


public class CropController {
	@Autowired
	private CropRepository repository;
	
	@PostMapping("/addCrop")
	public String saveCrop(@RequestBody CropEntity crop) {
repository.save(crop);
		return "Successfully crop is adaded with id:";
		
	}
	@GetMapping("/findAll")
public List<CropEntity> getCrop(){
		return repository.findAll();
	}
@GetMapping("/findAll/{id}")
	public Optional<CropEntity> getCrop(@PathVariable int id) {
		return repository.findById(id);
	}
	@PutMapping("/updateCrop")
	public CropEntity updateCrop(@RequestBody CropEntity crop) {
	return repository.save(crop);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDealer(@PathVariable int id) {
		repository.deleteById(id);
		return "Crop deleted";
		
	}
	
	
	
}
