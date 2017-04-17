package br.com.iteris.accesstage.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.iteris.accesstage.authentication.service.AuthenticationService;
import br.com.iteris.accesstage.model.ClientId;
import br.com.iteris.accesstage.model.authentication.Authentication;

/**
 * Classe criada para expor um serviço REST.
 *
 * @author iterisgsv
 */
@RestController
public class Controller {

    private final AuthenticationService authenticationService;

    @Autowired
    public Controller(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * Serviço REST de autenticação. Esse serviço recebe uma combinação de affiliation e token do cliente e retorna um
     * objeto contendo informações para conexão em um dos adquirentes possíveis (no momento, Rede ou Cielo).
     *
     * @param clientId
     *      Entrada do serviço. Contem affiliation e token
     * @return
     *      Retorno do serviço. Contém informações de status da tentativa de autenticação e, em caso de sucesso, os
     *      dados para autenticação em um cliente.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Authentication authenticate(@RequestBody ClientId clientId) {
        return authenticationService.authenticate(clientId);
    }
}
