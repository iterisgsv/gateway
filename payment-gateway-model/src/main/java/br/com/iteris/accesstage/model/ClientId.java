package br.com.iteris.accesstage.model;

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
}
