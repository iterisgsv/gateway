package br.com.iteris.accesstage.transaction.rede;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.iteris.accesstage.model.ReturnStatus;
import br.com.iteris.accesstage.model.primitives.Token;
import br.com.iteris.accesstage.model.transaction.request.TransactionRequest;

@RestController
public class Controller {

    private final ValidTokens validTokens;

    @Autowired
    public Controller(ValidTokens validTokens) {
        this.validTokens = validTokens;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ReturnStatus authorize(TransactionRequest transactionRequest, @RequestHeader("Authorization") Token token) {
        if (validTokens.isValid(token)) {
            return ReturnStatus.ok();
        }
        return ReturnStatus.unauthorized();
    }
}
