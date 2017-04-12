package br.com.iteris.accesstage.transaction.executors;

import br.com.iteris.accesstage.model.ReturnStatus;
import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.transaction.request.TransactionRequest;

public interface TransactionExecutor {

    boolean accepts(Authentication authentication);

    ReturnStatus perform(TransactionRequest request, Authentication authentication);
}
