package com.example.demo.paymentService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.paymentEntity.PaymentEntity;
import com.example.demo.paymentRepository.PaymentRepository;

public class PaymentService {

	@Autowired
	public PaymentRepository repo;
	
	//get all Farmer info
	public List<PaymentEntity> getPaymentInfo()   
	{  
	List<PaymentEntity> payment = new ArrayList<PaymentEntity>();  
	repo.findAll().forEach(payment1 -> payment.add(payment1));  
	return payment;  
	}
	
	//get Farmer by id
	public PaymentEntity getPaymentById(int id) {
		return repo.findById(id).get();
	}
	
	//post Farmer info
	public void addPaymentEntityInfo(PaymentEntity paymententity) {  
	repo.save(paymententity);  
	}  
	
	//deleting Farmer by id
	public void deletePaymentInfo(int id) {
		repo.deleteById(id);
	}
	
	//updating the Farmer
	public void updatePaymentEntityInfo(int id,PaymentEntity paymententity) {
		repo.save(paymententity);
	}
}
