package br.com.iteris.accesstage.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Classe Application usada para inicializar o servidor de descoberta de serviços. Esse servidor é usado para registro
 * e localiação de serviços usando a biblioteca Netflix Eureka.
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplication.class, args);
    }
}
