package br.com.iteris.accesstage.model;

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
}
