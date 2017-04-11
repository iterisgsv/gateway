package br.com.iteris.accesstage.model;

import java.text.MessageFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Greeter {

    @Getter
    @Setter
    private String message;

    public Greeter(String name) {
        this.message = MessageFormat.format("Hello {0}!", name);
    }
}
