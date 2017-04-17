package br.com.iteris.accesstage.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Classe Application usada para subir a aplicação de autenticação. Essa aplicação expõe um microserviço que recebe
 * um clientId e retorna os dados de autenticação específicos para um cliente.
 * </p>
 *
 * <p>
 * Durante a inicialização, esse microserviço se registra automaticamente no servidor de descoberta.
 * </p>
 *
 * @author iterisgsv
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@RestController
@SpringBootApplication(scanBasePackages = "br.com.iteris.accesstage.authentication")
public class AuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }
}
