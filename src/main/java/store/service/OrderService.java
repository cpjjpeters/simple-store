package store.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private   PaymentService paymentService;

    public OrderService(@Qualifier("stripe") PaymentService paymentService) {
        // Constructor injection of the payment service
        this.paymentService = paymentService;
    }
    public void placeOrder() {
        // Logic to place an order
//        var paymentService = new PaymentService();
        paymentService.processPayment(10);


    }
}
