package br.com.iteris.accesstage.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.authentication.AuthenticationInfo;
import br.com.iteris.accesstage.model.ClientId;
import br.com.iteris.accesstage.model.ReturnStatus;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    public Authentication authenticate(ClientId clientId) {
        ReturnStatus returnStatus = ReturnStatus.unauthorized();
        if (authenticationRepository.isValid(clientId)) {
            returnStatus = ReturnStatus.ok();
        }

        AuthenticationInfo authenticationInfo = authenticationRepository.findByClientId(clientId);
        return new Authentication(returnStatus, authenticationInfo);
    }
}
