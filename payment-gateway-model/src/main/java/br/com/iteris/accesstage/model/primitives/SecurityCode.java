package br.com.iteris.accesstage.model.primitives;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;

public class SecurityCode {

    @JsonUnwrapped
    private String securityCode;

    public SecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public SecurityCode() { }

    @Override
    @JsonValue
    public String toString() {
        return securityCode;
    }
}
