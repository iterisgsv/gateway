package br.com.iteris.accesstage.model;

import br.com.iteris.accesstage.model.primitives.CardNumber;
import br.com.iteris.accesstage.model.primitives.SecurityCode;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class CardInfo {

    @JsonUnwrapped
    private CardNumber cardNumber;

    @JsonUnwrapped
    private SecurityCode securityCode;

    public CardInfo(CardNumber cardNumber, SecurityCode securityCode) {
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
    }

    public CardInfo() { }
}
