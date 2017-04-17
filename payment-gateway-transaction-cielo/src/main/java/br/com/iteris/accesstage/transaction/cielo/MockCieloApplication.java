package br.com.iteris.accesstage.transaction.cielo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * Essa classe sobe uma aplicação que expõe um microserviço. Esse microserviço simula uma conexão ao adquirente Cielo
 * para efetivação de uma transação.
 * </p>
 *
 * <p>Durante a inicialização, essa aplicação se registra ao servidor de descoberta.</p>
 *
 * @author iterisgsv
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "br.com.iteris.accesstage.transaction.cielo")
public class MockCieloApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockCieloApplication.class, args);
    }
}
