package br.com.iteris.accesstage.model.primitives;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Tid {

    @JsonUnwrapped
    private String tid;

    public Tid() { }

    public Tid(String tid) {
        this.tid = tid;
    }
}
