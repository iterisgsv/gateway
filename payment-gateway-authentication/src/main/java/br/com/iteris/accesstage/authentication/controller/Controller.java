package br.com.iteris.accesstage.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.iteris.accesstage.authentication.service.AuthenticationService;
import br.com.iteris.accesstage.model.ClientId;
import br.com.iteris.accesstage.model.authentication.Authentication;

@RestController
public class Controller {

    private final AuthenticationService authenticationService;

    @Autowired
    public Controller(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Authentication hello(@RequestBody ClientId clientId) {
        return authenticationService.authenticate(clientId);
    }
}
