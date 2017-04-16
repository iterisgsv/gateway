package br.com.iteris.accesstage.model.transaction.response;

import javax.persistence.Embedded;

import br.com.iteris.accesstage.model.primitives.Amount;
import br.com.iteris.accesstage.model.primitives.DateTime;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

public class TransactionResponseInfo {

    @JsonUnwrapped
    @Embedded
    private TransactionInfo info;

    @JsonUnwrapped
    @Embedded
    private DateTime transactionDate;

    public TransactionResponseInfo(TransactionInfo info, DateTime transactionDate) {
        this.info = info;
        this.transactionDate = transactionDate;
    }

    @JsonCreator
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public static TransactionResponseInfo fromDate(@JsonProperty("transactionDate") String dateStr) {
        TransactionResponseInfo info = new TransactionResponseInfo();
        info.transactionDate = new DateTime(dateStr);
        return info;
    }

    public TransactionResponseInfo() { }

    public static TransactionResponseInfo from(Amount amount) {
        DateTime dateTime = new DateTime();
        TransactionInfo info = new TransactionInfo(null, amount);
        return new TransactionResponseInfo(info, dateTime);
    }
}
