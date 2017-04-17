package br.com.iteris.accesstage.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * <p>
 * Classe Application que sobe um gateway (através da biblioteca Netflix Zuul) para expor os microserviços da
 * aplicação.
 * </p>
 *
 * <p>
 * Durante a inicialização, esse servidor se registra no servidor de descoberta e usa o mesmo para descobrir os
 * microserviços que devem ser expostos.
 * </p>
 *
 * @author iterisgsv
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }
}
