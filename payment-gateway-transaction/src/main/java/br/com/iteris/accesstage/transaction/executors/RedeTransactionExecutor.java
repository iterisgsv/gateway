package br.com.iteris.accesstage.transaction.executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.authentication.AuthenticationType;

/**
 * Classe que define como efetivar uma transação para a adquirente Rede.
 *
 * @author iterisgsv
 */
@Service
public class RedeTransactionExecutor extends AbstractTransactionExecutor {

    @Autowired
    public RedeTransactionExecutor(RestTemplate restTemplate) {
        super(restTemplate);
    }

    /**
     * Verifica se a autenticação recebida é referente à Rede.
     *
     * @param authentication
     *      Dados de autenticação
     *
     * @return
     *      True caso autenticação for referente à Rede, false caso contrário.
     */
    @Override
    public boolean accepts(Authentication authentication) {
        return authentication.is(AuthenticationType.REDE);
    }

    /**
     * Retorna a URL do microserviço de efetivação de transação na Rede.
     *
     * @return a URL do microserviço de efetivação de transação na Rede.
     */
    @Override
    public String getUrl() {
        return "http://transaction-rede/";
    }
}
