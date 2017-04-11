package br.com.iteris.accesstage.model.transaction.request;

import br.com.iteris.accesstage.model.card.CardInfo;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Transaction {

    @JsonUnwrapped
    private TransactionInfo transactionInfo;

    @JsonUnwrapped
    private CardInfo cardInfo;

    public Transaction() { }

    public Transaction(TransactionInfo transactionInfo, CardInfo cardInfo) {
        this.transactionInfo = transactionInfo;
        this.cardInfo = cardInfo;
    }
}
