package br.com.iteris.accesstage.authentication.model;

import br.com.iteris.accesstage.model.authentication.AuthenticationType;
import br.com.iteris.accesstage.model.primitives.Token;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class AuthenticationInfo {

    @JsonUnwrapped
    private AuthenticationType authenticationType;

    @JsonUnwrapped
    private Token token;

    public AuthenticationInfo(AuthenticationType authenticationType, Token token) {
        this.authenticationType = authenticationType;
        this.token = token;
    }

    public AuthenticationInfo() { }

}
