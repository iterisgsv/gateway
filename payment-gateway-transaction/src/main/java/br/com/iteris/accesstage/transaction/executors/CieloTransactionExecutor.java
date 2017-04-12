package br.com.iteris.accesstage.transaction.executors;

import org.springframework.stereotype.Service;

import br.com.iteris.accesstage.model.ReturnStatus;
import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.authentication.AuthenticationType;
import br.com.iteris.accesstage.model.transaction.request.TransactionRequest;

@Service
public class CieloTransactionExecutor implements TransactionExecutor {

    @Override
    public boolean accepts(Authentication authentication) {
        return authentication.is(AuthenticationType.CIELO);
    }

    @Override
    public ReturnStatus perform(TransactionRequest request, Authentication authentication) {
        return ReturnStatus.nok();
    }
}
