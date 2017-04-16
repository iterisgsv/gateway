package br.com.iteris.accesstage.model.authentication;

import br.com.iteris.accesstage.model.ReturnCode;
import br.com.iteris.accesstage.model.ReturnStatus;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Authentication {

    @JsonUnwrapped
    private ReturnStatus returnStatus;

    @JsonUnwrapped
    private AuthenticationInfo authentication;

    public Authentication(ReturnStatus returnStatus, AuthenticationInfo authentication) {
        this.returnStatus = returnStatus;
        this.authentication = authentication;
    }

    public Authentication() { }

    public boolean is(AuthenticationType authenticationType) {
        return authentication.is(authenticationType);
    }

    public String tokenRepresentation() {
        return authentication.token.toString();
    }

    public boolean unauthorized() {
        return returnStatus.is(ReturnCode.UNAUTHORIZED);
    }
}
