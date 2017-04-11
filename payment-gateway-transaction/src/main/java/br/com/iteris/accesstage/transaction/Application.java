package br.com.iteris.accesstage.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.iteris.accesstage.model.Greeter;
import br.com.iteris.accesstage.model.TransactionResponse;

@SpringBootApplication
@RibbonClient(name = "auth", configuration = AuthenticationConfiguration.class)
@EnableDiscoveryClient
@RestController
public class Application {

    @Autowired
    private RestTemplate restTemplate;

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(value = "/")
    public TransactionResponse create(@RequestParam String customerName) {
        Greeter greeter = this.restTemplate.getForObject("http://authentication/hello?name={name}", Greeter.class, customerName);
        return new TransactionResponse(greeter);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
