package br.com.iteris.accesstage.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.iteris.accesstage.model.Greeter;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@RestController
public class Application {

    @RequestMapping(value = "/hello")
    public Greeter hello(@RequestParam String name) {
        System.out.println("Received call with param " + name);
        return new Greeter(name);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
