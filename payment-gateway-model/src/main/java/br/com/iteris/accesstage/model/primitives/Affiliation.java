package br.com.iteris.accesstage.model.primitives;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;

public class Affiliation {

    @JsonUnwrapped
    private String affiliation;

    public Affiliation() { }

    public Affiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    @Override
    @JsonValue
    public String toString() {
        return affiliation;
    }
}
