package br.com.iteris.accesstage.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.transaction.request.TransactionRequest;
import br.com.iteris.accesstage.model.transaction.response.TransactionResponse;

/**
 * Serviço de criação de transação
 *
 * @author iterisgsv
 */
@Service
public class TransactionService {

    private final AuthenticationService authenticationService;
    private TransactionCreatorService transactionCreatorService;

    @Autowired
    public TransactionService(AuthenticationService authenticationService, TransactionCreatorService transactionCreatorService) {
        this.authenticationService = authenticationService;
        this.transactionCreatorService = transactionCreatorService;
    }

    /**
     * Esse método se autentica, visando obter os dados de autenticação em uma adquirente, e registra uma transação,
     * retornando o resultado do processo.
     *
     * @param request
     *      Dados para registro da transação
     *
     * @return Retorno da tentativa de criação da transação
     */
    public TransactionResponse createTransaction(TransactionRequest request) {
        Authentication authentication = authenticationService.requestAuthentication(request);
        if (authentication == null || authentication.unauthorized()) {
            System.out.println("Unauthorized!!!");
            return TransactionResponse.error(request.getAmount());
        }

        return transactionCreatorService.create(request, authentication);
    }
}
