package br.com.iteris.accesstage.transaction.executors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.iteris.accesstage.model.ReturnStatus;
import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.transaction.request.TransactionRequest;

public abstract class AbstractTransactionExecutor implements TransactionExecutor {

    private final RestTemplate restTemplate;

    public AbstractTransactionExecutor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public abstract String getUrl();

    @Override
    public ReturnStatus perform(TransactionRequest request, Authentication authentication) {
        System.out.println("Performing transaction using class " + getClass().getSimpleName());
        String url = getUrl();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", authentication.tokenRepresentation());

        HttpEntity<TransactionRequest> requestEntity = new HttpEntity<>(request, headers);
        ResponseEntity<ReturnStatus> exchange = restTemplate.exchange(url, HttpMethod.POST, requestEntity, ReturnStatus.class);
        return exchange.getBody();
    }
}
