package br.com.iteris.accesstage.authentication;

import org.springframework.stereotype.Repository;

import br.com.iteris.accesstage.model.authentication.AuthenticationInfo;
import br.com.iteris.accesstage.authentication.model.ValidAuthentications;
import br.com.iteris.accesstage.model.ClientId;

@Repository
public class AuthenticationRepository {

    private ValidAuthentications validAuthentications = new ValidAuthentications();

    public boolean isValid(ClientId clientId) {
        return validAuthentications.contains(clientId);
    }

    public AuthenticationInfo findByClientId(ClientId clientId) {
        return this.validAuthentications.find(clientId);
    }
}
