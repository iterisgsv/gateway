package br.com.iteris.accesstage.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.iteris.accesstage.model.ClientId;
import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.transaction.request.TransactionRequest;

@Service
public class AuthenticationService {

    private final RestTemplate restTemplate;

    @Autowired
    public AuthenticationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Authentication requestAuthentication(TransactionRequest request) {
        System.out.println("Requesting authentication...");
        ClientId clientId = request.getClientId();
        return this.restTemplate.postForObject("http://authentication/", clientId, Authentication.class);
    }
}
