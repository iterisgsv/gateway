package br.com.iteris.accesstage.model.primitives;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Amount {

    @JsonUnwrapped
    private BigDecimal amount;

    public Amount() { }

    public Amount(BigDecimal amount) {
        this.amount = amount;
    }

}
