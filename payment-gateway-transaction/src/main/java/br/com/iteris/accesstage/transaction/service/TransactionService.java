package br.com.iteris.accesstage.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.transaction.request.TransactionRequest;
import br.com.iteris.accesstage.model.transaction.response.TransactionResponse;

@Service
public class TransactionService {

    private final AuthenticationService authenticationService;
    private TransactionCreatorService transactionCreatorService;

    @Autowired
    public TransactionService(AuthenticationService authenticationService, TransactionCreatorService transactionCreatorService) {
        this.authenticationService = authenticationService;
        this.transactionCreatorService = transactionCreatorService;
    }

    public TransactionResponse createTransaction(TransactionRequest request) {
        Authentication authentication = authenticationService.requestAuthentication(request);
        if (authentication == null || authentication.unauthorized()) {
            System.out.println("Unauthorized!!!");
            return TransactionResponse.error(request.getAmount());
        }

        return transactionCreatorService.create(request, authentication);
    }
}
