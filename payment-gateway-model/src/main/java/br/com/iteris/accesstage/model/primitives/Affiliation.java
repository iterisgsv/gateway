package br.com.iteris.accesstage.model.primitives;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Affiliation that = (Affiliation) o;
        return Objects.equals(affiliation, that.affiliation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(affiliation);
    }
}
