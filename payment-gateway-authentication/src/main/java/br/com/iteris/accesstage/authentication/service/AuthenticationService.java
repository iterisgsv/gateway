package br.com.iteris.accesstage.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iteris.accesstage.authentication.repository.AuthenticationRepository;
import br.com.iteris.accesstage.model.ClientId;
import br.com.iteris.accesstage.model.ReturnStatus;
import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.authentication.AuthenticationInfo;

@Service
public class AuthenticationService {

    private final AuthenticationRepository authenticationRepository;

    @Autowired
    public AuthenticationService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    public Authentication authenticate(ClientId clientId) {
        ReturnStatus returnStatus = ReturnStatus.unauthorized();
        if (authenticationRepository.isValid(clientId)) {
            returnStatus = ReturnStatus.ok();
        }

        AuthenticationInfo authenticationInfo = authenticationRepository.findByClientId(clientId);
        return new Authentication(returnStatus, authenticationInfo);
    }
}
