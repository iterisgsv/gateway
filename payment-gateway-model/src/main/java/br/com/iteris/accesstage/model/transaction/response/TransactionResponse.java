package br.com.iteris.accesstage.model.transaction.response;

import br.com.iteris.accesstage.model.ReturnStatus;
import br.com.iteris.accesstage.model.primitives.Amount;
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

    public static TransactionResponse error(Amount amount) {
        ReturnStatus nok = ReturnStatus.nok();
        TransactionResponseInfo from = TransactionResponseInfo.from(amount);
        return new TransactionResponse(nok, from);
    }
}
