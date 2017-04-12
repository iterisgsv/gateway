package br.com.iteris.accesstage.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.iteris.accesstage.model.ClientId;
import br.com.iteris.accesstage.model.ReturnStatus;
import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.transaction.request.TransactionRequest;
import br.com.iteris.accesstage.model.transaction.response.TransactionResponse;
import br.com.iteris.accesstage.transaction.executors.TransactionExecutors;

@Service
public class TransactionService {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Autowired
    private TransactionExecutors transactionExecutors;

    public TransactionResponse createTransaction(TransactionRequest request) {
        ClientId clientId = request.getClientId();
        Authentication authentication = requestAuthentication(clientId);

        ReturnStatus status = transactionExecutors.accept(request, authentication);

        return TransactionResponse.error(request.getAmount());
    }

    private Authentication requestAuthentication(ClientId clientId) {
        return this.restTemplate.postForObject("http://authentication/", clientId, Authentication.class);
    }
}
