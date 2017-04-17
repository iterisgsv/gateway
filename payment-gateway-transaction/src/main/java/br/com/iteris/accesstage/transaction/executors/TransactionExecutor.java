package br.com.iteris.accesstage.transaction.executors;

import br.com.iteris.accesstage.model.ReturnStatus;
import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.transaction.request.TransactionRequest;

/**
 * Define as operações necessárias para efetivar uma transação em um adquirente.
 *
 * @author iterisgsv
 */
public interface TransactionExecutor {

    /**
     * Valida se os dados de autenticação recebidos são referentes ao adquirente ao qual uma implementação se refere.
     *
     * @param authentication
     *      Dados de autenticação
     *
     * @return True caso os dados recebidos se referirem ao adquirente que a implementação trata, false caso contrário.
     */
    boolean accepts(Authentication authentication);

    /**
     * Efetiva uma transação no cliente e retorna o resultado.
     *
     * @param request
     *      Dados da transação a ser efetivada no adquirente
     * @param authentication
     *      Dados de autenticação aos sistemas da adquirente.
     *
     * @return
     *      Resultado da tentativa de efetivação da autenticação
     */
    ReturnStatus perform(TransactionRequest request, Authentication authentication);
}
