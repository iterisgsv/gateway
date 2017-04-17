package br.com.iteris.accesstage.transaction.executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.authentication.AuthenticationType;

/**
 * Classe que define como efetivar uma transação para a adquirente Cielo.
 *
 * @author iterisgsv
 */
@Service
public class CieloTransactionExecutor extends AbstractTransactionExecutor {

    @Autowired
    public CieloTransactionExecutor(RestTemplate restTemplate) {
        super(restTemplate);
    }

    /**
     * Verifica se a autenticação recebida é referente à Cielo.
     *
     * @param authentication
     *      Dados de autenticação
     *
     * @return
     *      True caso autenticação for referente à Cielo, false caso contrário.
     */
    @Override
    public boolean accepts(Authentication authentication) {
        return authentication.is(AuthenticationType.CIELO);
    }

    /**
     * Retorna a URL do microserviço de efetivação de transação na Cielo.
     *
     * @return a URL do microserviço de efetivação de transação na Cielo.
     */
    @Override
    public String getUrl() {
        return "http://transaction-cielo/";
    }
}
