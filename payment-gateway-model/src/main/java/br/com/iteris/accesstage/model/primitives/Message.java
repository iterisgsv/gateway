package br.com.iteris.accesstage.model.primitives;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;

public class Message {

    @JsonUnwrapped
    private String message;

    public Message() { }

    public Message(String message) {
        this.message = message;
    }

    @Override
    @JsonValue
    public String toString() {

        return message;
    }

}
