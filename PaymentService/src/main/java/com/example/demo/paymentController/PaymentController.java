package com.example.demo.paymentController;

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

import com.example.demo.paymentEntity.PaymentEntity;
import com.example.demo.paymentService.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	public PaymentService paymentService;
	
	@GetMapping("/findAll")
	public List<PaymentEntity> getPaymentInfoService(){
		return paymentService.getPaymentInfo();
	}
	
	@GetMapping("/findAll/{id}")  
	public PaymentEntity getPaymentInfoById(@PathVariable("id") int id)   
	{  
		return paymentService.getPaymentById(id);
	} 
	
	@PostMapping("/addPayment")  
	public PaymentEntity addFarmerInfo(@RequestBody PaymentEntity paymententity)   
	{  
		paymentService.addPaymentEntityInfo(paymententity); 
		return paymententity;  
	}
	
	@PutMapping("/updatePayment/{id}")  
	public PaymentEntity updatePaymentInfo(@PathVariable("id") int id,@RequestBody PaymentEntity paymententity)   
	{  
		paymentService.updatePaymentEntityInfo(id,paymententity);
	return paymententity;  
	}  
	
	@DeleteMapping("/deletePayment/{id}")  
	public void deletePaymentInfo(@PathVariable("id") int id)   
	{  
		paymentService.deletePaymentInfo(id);  
	}  
}

