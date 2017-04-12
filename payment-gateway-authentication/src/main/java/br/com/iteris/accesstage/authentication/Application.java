package br.com.iteris.accesstage.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.ClientId;

@EnableCircuitBreaker
@EnableDiscoveryClient
@RestController
@SpringBootApplication(scanBasePackages = "br.com.iteris.accesstage.authentication")
public class Application {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Authentication hello(@RequestBody ClientId clientId) {
        return authenticationService.authenticate(clientId);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
