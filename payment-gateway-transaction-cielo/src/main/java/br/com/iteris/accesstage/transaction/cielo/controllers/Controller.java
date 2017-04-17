package br.com.iteris.accesstage.transaction.cielo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.iteris.accesstage.model.ReturnStatus;
import br.com.iteris.accesstage.model.primitives.Token;
import br.com.iteris.accesstage.model.transaction.request.TransactionRequest;
import br.com.iteris.accesstage.transaction.cielo.validation.ValidTokens;

/**
 * Expõe um microserviço que simula a efetivação de uma transação nos sistemas da Rede.
 *
 * @author iterisgsv
 */
@RestController
public class Controller {

    private final ValidTokens validTokens;

    @Autowired
    public Controller(ValidTokens validTokens) {
        this.validTokens = validTokens;
    }

    /**
     * <p>
     * Serviço REST que recebe dados de uma transação e um header de autenticação e retorna o status de uma efetivação
     * simulada de transação no adquirente Cielo.
     * </p>
     * <p>
     * O que ocorre na verdade é que o serviço apenas verifica se o header de autenticação possui conteúdo aceitável.
     * Caso possuir, o serviço retorna sucesso. Caso contrário, o sistema retorna erro de autenticação.
     * </p>
     *
     * @param transactionRequest
     *      Requisição para efetivação da transação
     * @param token
     *      Header de autenticação
     *
     * @return Status da efetivação da transação
     *
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ReturnStatus authorize(TransactionRequest transactionRequest, @RequestHeader("Authorization") Token token) {
        if (validTokens.isValid(token)) {
            return ReturnStatus.ok();
        }
        return ReturnStatus.unauthorized();
    }
}
