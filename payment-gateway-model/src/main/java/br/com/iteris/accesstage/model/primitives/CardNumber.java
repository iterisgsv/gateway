package br.com.iteris.accesstage.model.primitives;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;

public class CardNumber {

    @JsonUnwrapped
    private String cardNumber;

    public CardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CardNumber() { }

    @Override
    @JsonValue
    public String toString() {
        return cardNumber;
    }
}
