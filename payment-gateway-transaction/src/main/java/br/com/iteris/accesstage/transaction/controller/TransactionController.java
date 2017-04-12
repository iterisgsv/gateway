package br.com.iteris.accesstage.transaction.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.iteris.accesstage.model.transaction.request.TransactionRequest;
import br.com.iteris.accesstage.model.transaction.response.TransactionResponse;
import br.com.iteris.accesstage.transaction.service.TransactionService;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public TransactionResponse create(@RequestBody TransactionRequest request) {
        System.out.println("Received new transaction request");
        return transactionService.createTransaction(request);
    }
}
