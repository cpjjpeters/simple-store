package store.configuration;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import store.service.OrderService;
import store.service.PayPalPaymentService;
import store.service.PaymentService;
import store.service.StripePaymentService;

/* carlpeters created on 22/12/2024 inside the package - ipeters.resttemplate_demo.configuration */
@Configuration
@EnableAutoConfiguration
//@ComponentScan("ipeters.resttemplate_demo.*;")
//@EnableJpaRepositories(basePackages = "ipeters.resttemplate_demo")
public class ApplicationConfig {
//    @Bean
//    public CustomerMapper customerMapper() {
//        return Mappers.getMapper(CustomerMapper.class);
//    }

    @Value("${orderservice.type:stripe}")
    private String orderserviceType;

    @Bean
    public PaymentService paymentService() {
        if (orderserviceType.equalsIgnoreCase("paypal")) {
            return new PayPalPaymentService();
        } else if (orderserviceType.equalsIgnoreCase("stripe")) {
            return new StripePaymentService();
        } else {
            throw new IllegalArgumentException("Invalid order service type: " + orderserviceType);
        }
    }
    @Bean
    public OrderService orderService() {
        return new OrderService(paymentService());
    }
}
