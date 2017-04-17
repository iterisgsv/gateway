package br.com.iteris.accesstage.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.iteris.accesstage.model.transaction.request.TransactionRequest;
import br.com.iteris.accesstage.model.transaction.response.TransactionResponse;
import br.com.iteris.accesstage.transaction.service.TransactionService;

/**
 * Classe que expõe um serviço REST de criação e efetivação de uma transação.
 *
 * @author iterisgsv
 */
@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Serviço de criação e efetivação de uma transação.
     *
     * @param request
     *      Objeto que contém as informações necessárias para criar e efetivar a transação
     *
     * @return Contém o resultado da tentativa de criar e efetivar a transação.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public TransactionResponse create(@RequestBody TransactionRequest request) {
        System.out.println("Received new transaction request");
        return transactionService.createTransaction(request);
    }
}
