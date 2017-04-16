package br.com.iteris.accesstage.model.primitives;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Tid {

    @JsonUnwrapped
    private String tid;

    public Tid() { }

    public Tid(String tid) {
        this.tid = tid;
    }

    public static Tid random() {
        return new Tid(UUID.randomUUID().toString());
    }
}
