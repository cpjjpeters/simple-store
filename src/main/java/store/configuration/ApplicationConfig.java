package store.configuration;

import org.mapstruct.factory.Mappers;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
}
