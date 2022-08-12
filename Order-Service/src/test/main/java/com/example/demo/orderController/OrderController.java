package com.example.demo.orderController;


import org.apache.catalina.servlets.DefaultServlet.SortManager.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Common.TxResponse;
import com.example.demo.orderService.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
    private OrderService service;

    @PostMapping("/placeOrder/")
    public TxResponse placeOrder(@RequestBody Order order){
        return service.placeOrder(order);
    }

}