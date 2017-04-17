package br.com.iteris.accesstage.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import br.com.iteris.accesstage.transaction.configuration.RibbonConfiguration;

/**
 * <p>
 * Classe Application usada para subir a aplicação de transação. Essa aplicação expõe um microserviço de registro de
 * transações que coordena o acesso aos outros microserviços.
 * </p>
 *
 * <p>
 * Durante a inicialização, esse microserviço se registra automaticamente no servidor de descoberta.
 * </p>
 *
 * @author iterisgsv
 */
@SpringBootApplication(scanBasePackages = "br.com.iteris.accesstage.transaction")
@RibbonClient(name = "services", configuration = RibbonConfiguration.class)
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "br.com.iteris.accesstage.transaction.repository")
public class TransactionApplication {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }
}
