package br.com.iteris.accesstage.model.transaction.response;

import javax.persistence.Embedded;

import br.com.iteris.accesstage.model.ReturnStatus;
import br.com.iteris.accesstage.model.primitives.Amount;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class TransactionResponse {

    @JsonUnwrapped
    @Embedded
    private ReturnStatus returnStatus;

    @JsonUnwrapped
    @Embedded
    private TransactionResponseInfo transaction;

    public TransactionResponse(ReturnStatus returnStatus, TransactionResponseInfo transaction) {
        this.returnStatus = returnStatus;
        this.transaction = transaction;
    }

    public TransactionResponse() { }

    public static TransactionResponse error(Amount amount) {
        ReturnStatus nok = ReturnStatus.nok();
        TransactionResponseInfo from = TransactionResponseInfo.from(amount);
        return new TransactionResponse(nok, from);
    }
}
