package store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import store.service.NotificationManager;
import store.service.OrderService;
import store.service.PayPalPaymentService;
import store.service.StripePaymentService;

@SpringBootApplication
public class SimpleStoreApplication {
    public static void main(String[] args) {
       ApplicationContext context =  SpringApplication.run(SimpleStoreApplication.class, args);
        var orderService = context.getBean(OrderService.class);
        orderService.placeOrder();

//        var manager = context.getBean( NotificationManager.class);
//        manager.notifyUser("the message", "the recipient");

    }


//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }
}