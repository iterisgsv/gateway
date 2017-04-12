package br.com.iteris.accesstage.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iteris.accesstage.model.ReturnCode;
import br.com.iteris.accesstage.model.ReturnStatus;
import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.primitives.Amount;
import br.com.iteris.accesstage.model.primitives.DateTime;
import br.com.iteris.accesstage.model.primitives.Tid;
import br.com.iteris.accesstage.model.transaction.request.TransactionRequest;
import br.com.iteris.accesstage.model.transaction.response.TransactionInfo;
import br.com.iteris.accesstage.model.transaction.response.TransactionResponse;
import br.com.iteris.accesstage.model.transaction.response.TransactionResponseInfo;
import br.com.iteris.accesstage.transaction.entity.Transaction;
import br.com.iteris.accesstage.transaction.executors.TransactionExecutors;
import br.com.iteris.accesstage.transaction.repository.TransactionRepository;

@Service
public class TransactionCreatorService {

    private final TransactionExecutors transactionExecutors;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionCreatorService(TransactionExecutors transactionExecutors, TransactionRepository transactionRepository) {
        this.transactionExecutors = transactionExecutors;
        this.transactionRepository = transactionRepository;
    }

    public TransactionResponse create(TransactionRequest request, Authentication authentication) {
        ReturnStatus status = transactionExecutors.accept(request, authentication);
        System.out.println("Transaction accepted with status " + status.toString());

        TransactionInfo transactionInfo = buildTransactionInfo(status, request.getAmount());
        TransactionResponseInfo responseInfo = new TransactionResponseInfo(transactionInfo, new DateTime());
        TransactionResponse response = new TransactionResponse(status, responseInfo);

        Transaction transaction = new Transaction(response);
        transactionRepository.save(transaction);
        System.out.println("Transaction processed successfully");
        return response;
    }

    private TransactionInfo buildTransactionInfo(ReturnStatus status, Amount amount) {
        if (status.is(ReturnCode.OK)) {
            return new TransactionInfo(Tid.random(), amount);
        }

        return null;
    }
}
