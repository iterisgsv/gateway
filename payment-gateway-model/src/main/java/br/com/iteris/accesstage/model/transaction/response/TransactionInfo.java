package br.com.iteris.accesstage.model.transaction.response;

import br.com.iteris.accesstage.model.primitives.Amount;
import br.com.iteris.accesstage.model.primitives.Tid;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class TransactionInfo {

    @JsonUnwrapped
    private Tid tid;

    @JsonUnwrapped
    private Amount amount;

    public TransactionInfo(Tid tid, Amount amount) {
        this.tid = tid;
        this.amount = amount;
    }

    public TransactionInfo() { }
}
