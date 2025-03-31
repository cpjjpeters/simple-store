package store.configuration;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
//import org.flywaydb.core.Flyway;

import javax.sql.DataSource;

//@Configuration
public class FlywayConfig {
//
//    @Bean
//    @Order(1)
//    public FlywayMigrationStrategy flywayMigrationStrategy() {
//        return flyway -> {
//            flyway.migrate();
//        };
//    }
//
//    @Bean(initMethod = "migrate")
//    public Flyway flyway() {
//        return Flyway.configure()
//                .dataSource(dataSource())
//                .load();
//    }

    @Bean
    public DataSource dataSource() {
        // Configure your DataSource here
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:simplestoredb")
                .username("sa")
                .password("")
                .build();
    }
}