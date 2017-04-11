package br.com.iteris.accesstage.model.transaction.response;

import br.com.iteris.accesstage.model.ReturnStatus;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class TransactionResponse {

    @JsonUnwrapped
    private ReturnStatus returnStatus;

    @JsonUnwrapped
    private TransactionResponseInfo transaction;

    public TransactionResponse(ReturnStatus returnStatus, TransactionResponseInfo transaction) {
        this.returnStatus = returnStatus;
        this.transaction = transaction;
    }

    public TransactionResponse() { }
}
