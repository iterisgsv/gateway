package br.com.iteris.accesstage.transaction.cielo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "br.com.iteris.accesstage.transaction.cielo")
public class MockCieloApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockCieloApplication.class, args);
    }
}
