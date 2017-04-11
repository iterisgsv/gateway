package br.com.iteris.accesstage.model.primitives;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Token token1 = (Token) o;
        return Objects.equals(token, token1.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
