package com.example.demo.paymentRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.paymentEntity.PaymentEntity;

public interface PaymentRepository extends MongoRepository<PaymentEntity, Integer> {

}
