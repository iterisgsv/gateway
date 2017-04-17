package br.com.iteris.accesstage.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iteris.accesstage.authentication.repository.AuthenticationRepository;
import br.com.iteris.accesstage.model.ClientId;
import br.com.iteris.accesstage.model.ReturnStatus;
import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.authentication.AuthenticationInfo;

/**
 * Essa classe expõe um serviço de autenticação para a camada controller.
 *
 * @author iterisgsv
 */
@Service
public class AuthenticationService {

    private final AuthenticationRepository authenticationRepository;

    @Autowired
    public AuthenticationService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Recebe uma combinação de affiliation e token do cliente e retorna um objeto contendo informações para conexão
     * em um dos adquirentes possíveis (no momento, Rede ou Cielo).
     *
     * @param clientId
     *      Contem affiliation e token
     * @return
     *      Contém informações de status da tentativa de autenticação e, em caso de sucesso, os dados para autenticação
     *      em um cliente.
     */
    public Authentication authenticate(ClientId clientId) {
        ReturnStatus returnStatus = ReturnStatus.unauthorized();
        if (authenticationRepository.isValid(clientId)) {
            returnStatus = ReturnStatus.ok();
        }

        AuthenticationInfo authenticationInfo = authenticationRepository.findByClientId(clientId);
        return new Authentication(returnStatus, authenticationInfo);
    }
}
