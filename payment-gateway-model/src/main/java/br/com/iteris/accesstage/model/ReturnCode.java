package br.com.iteris.accesstage.model;

import java.util.Optional;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReturnCode {
    OK("00"),
    UNAUTHORIZED("01"),
    NOK("99");

    private final String code;

    ReturnCode(String code) {
        this.code = code;
    }

    @JsonValue
    public String representation() {
        return code;
    }

    public static ReturnCode fromRepresentation(String representation) {
        Optional<ReturnCode> first = Stream.of(values())
            .filter(code -> code.representation().equalsIgnoreCase(representation))
            .findFirst();

        if (first.isPresent()) {
            return first.get();
        }

        return null;
    }
}
