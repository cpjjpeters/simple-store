package store.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("stripe")
@Primary
public class StripePaymentService implements PaymentService {

    @Value("${stripe.apiUrl}")
    private String stripeApiUrl;
    @Value("${stripe.enabled}")
    private boolean enabled;

    @Value("${stripe.timeout:3000}")
    private int timeout;

    @Value("${stripe.supported-currencies}")
    private List <String> supportedCurrencies;

    @Override
    public void processPayment(double amount) {
        // Logic to process payment using Stripe
        // This could involve creating a charge, handling webhooks, etc.
        System.out.println("Processing payment with Stripe...");
        System.out.println("Amount: " + amount);
        System.out.println("Stripe API URL: " + stripeApiUrl);
        System.out.println("Enabled: " + enabled);
        System.out.println("Timeout: " + timeout);
        System.out.println("Supported Currencies: " + supportedCurrencies);
    }
}
