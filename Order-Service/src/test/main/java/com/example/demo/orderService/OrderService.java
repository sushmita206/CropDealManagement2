package com.example.demo.orderService;

public class OrderService {
	@Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate template;

    public TxResponse placeOrder(Order order){
    	orderRepository.save(order);
        Payment paymentReq = new Payment();
        paymentReq.setOrderId(order.getId());
        paymentReq.setAmount(order.getQuantity()*order.getPrice());
        //restTemplate
        Payment paymentRes =
                template.postForObject("http://localhost:9100/payment/doPay/",
                paymentReq, Payment.class);
        TxResponse txResponse = new TxResponse();
        txResponse.setOrder(order);
        txResponse.setStatus(paymentRes.getPaymentStatus());
        txResponse.setAmount(paymentRes.getAmount());
        txResponse.setTxId(paymentRes.getTxId());
        return txResponse;
    

}
