package br.com.iteris.accesstage.model;

import java.util.Objects;

import br.com.iteris.accesstage.model.primitives.Affiliation;
import br.com.iteris.accesstage.model.primitives.Token;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class ClientId {

    @JsonUnwrapped
    private Affiliation affiliation;

    @JsonUnwrapped
    private Token token;

    public ClientId(Affiliation affiliation, Token token) {
        this.affiliation = affiliation;
        this.token = token;
    }

    public ClientId() { }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ClientId clientId = (ClientId) o;
        return Objects.equals(affiliation, clientId.affiliation) &&
            Objects.equals(token, clientId.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(affiliation, token);
    }

    public static ClientId from(String affiliationStr, String tokenStr) {
        Affiliation affiliation = new Affiliation(affiliationStr);
        Token token = new Token(tokenStr);
        return new ClientId(affiliation, token);
    }
}
