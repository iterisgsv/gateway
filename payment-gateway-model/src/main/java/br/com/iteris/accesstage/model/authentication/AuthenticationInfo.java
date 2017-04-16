package br.com.iteris.accesstage.model.authentication;

import br.com.iteris.accesstage.model.primitives.Token;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class AuthenticationInfo {

    @JsonUnwrapped
    private AuthenticationType authenticationType;

    @JsonUnwrapped
    Token token;

    public AuthenticationInfo(AuthenticationType authenticationType, Token token) {
        this.authenticationType = authenticationType;
        this.token = token;
    }

    public AuthenticationInfo() { }

    public boolean is(AuthenticationType authenticationType) {
        return this.authenticationType.equals(authenticationType);
    }
}
