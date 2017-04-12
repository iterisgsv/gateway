package br.com.iteris.accesstage.transaction.executors;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iteris.accesstage.model.ReturnStatus;
import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.transaction.request.TransactionRequest;

@Service
public class TransactionExecutors {

    private final List<TransactionExecutor> executors;

    @Autowired
    public TransactionExecutors(List<TransactionExecutor> executors) {
        this.executors = executors;
    }

    public ReturnStatus accept(TransactionRequest request, Authentication authentication) {
        Stream<TransactionExecutor> executorStream = executors.stream().filter(executorAccepts(authentication));
        Optional<TransactionExecutor> executor = executorStream.findFirst();
        return executor.map(perform(request, authentication)).orElse(ReturnStatus.nok());
    }

    private Function<TransactionExecutor, ReturnStatus> perform(TransactionRequest request, Authentication authentication) {
        return transactionExecutor -> transactionExecutor.perform(request, authentication);
    }

    private Predicate<? super TransactionExecutor> executorAccepts(Authentication authentication) {
        return transactionExecutor -> transactionExecutor.accepts(authentication);
    }
}
