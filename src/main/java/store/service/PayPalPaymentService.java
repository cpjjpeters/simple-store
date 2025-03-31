package store.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/* carlpeters created on 28/03/2025 inside the package - store.service */
//@Service("paypal")
public class PayPalPaymentService  implements PaymentService{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment with PayPal...");
        System.out.println("Amount: " + amount);
    }
}
