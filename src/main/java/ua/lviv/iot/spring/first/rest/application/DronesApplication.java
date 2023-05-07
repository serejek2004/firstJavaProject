package ua.lviv.iot.spring.first.rest.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "ua.lviv.iot.spring.first.rest")
@SpringBootApplication
public class DronesApplication {
    public static void main(final String[] args) {
        SpringApplication.run(DronesApplication.class, args);
    }
}
