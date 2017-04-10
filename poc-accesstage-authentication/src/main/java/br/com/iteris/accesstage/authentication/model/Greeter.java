package br.com.iteris.accesstage.authentication.model;

import java.text.MessageFormat;

import lombok.Getter;

public class Greeter {

    @Getter
    private String message;

    public Greeter(String name) {
        this.message = MessageFormat.format("Hello {0}!", name);
    }
}
