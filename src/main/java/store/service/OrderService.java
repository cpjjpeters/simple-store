package store.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//@Service
public class OrderService {

    private   PaymentService paymentService;


    public OrderService(@Qualifier("stripe") PaymentService paymentService) {
        // Constructor injection of the payment service
        this.paymentService = paymentService;
    }
    public void placeOrder() {
        // Logic to place an order
//        var paymentService = new PaymentService();
        System.out.println("Placing order... " );
        paymentService.processPayment(10);
    }

    @PostConstruct
    public void init() {
        // This method will be called after the bean is constructed
        System.out.println("OrderService bean has been using PostConstruct.");
    }

    @PreDestroy
    public void cleanup() {
        // This method will be called before the bean is destroyed
        System.out.println("Cleaning up OrderService bean.");
    }
}
