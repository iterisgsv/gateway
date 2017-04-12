package br.com.iteris.accesstage.model.transaction.request;

import br.com.iteris.accesstage.model.primitives.Amount;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class TransactionInfo {

    @JsonUnwrapped
    private TransactionType transactionType;

    @JsonUnwrapped
    Amount amount;

    public TransactionInfo(TransactionType transactionType, Amount transactionAmount) {
        this.transactionType = transactionType;
        this.amount = transactionAmount;
    }

    public TransactionInfo() { }
}
