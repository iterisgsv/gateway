package br.com.iteris.accesstage.model.primitives;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;

public class Token {

    @JsonUnwrapped
    private String token;

    public Token() { }

    public Token(String token) {
        this.token = token;
    }

    @Override
    @JsonValue
    public String toString() {
        return token;
    }
}
