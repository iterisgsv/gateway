package br.com.iteris.accesstage.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import br.com.iteris.accesstage.transaction.configuration.AuthenticationConfiguration;


@SpringBootApplication(scanBasePackages = "br.com.iteris.accesstage.transaction")
@RibbonClient(name = "auth", configuration = AuthenticationConfiguration.class)
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "br.com.iteris.accesstage.transaction.repository")
public class Application {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
    }
}
