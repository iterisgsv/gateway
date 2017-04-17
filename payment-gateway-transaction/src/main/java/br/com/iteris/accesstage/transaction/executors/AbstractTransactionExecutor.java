package br.com.iteris.accesstage.transaction.executors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.iteris.accesstage.model.ReturnStatus;
import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.transaction.request.TransactionRequest;

/**
 * Classe abstrata de efetivação de transação em uma adquirente.
 *
 * @author iterisgsv
 */
public abstract class AbstractTransactionExecutor implements TransactionExecutor {

    private final RestTemplate restTemplate;

    public AbstractTransactionExecutor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Define a URL do microserviço de efetivação de transação.
     *
     * @return a URL do microserviço de efetivação de transação.
     */
    public abstract String getUrl();

    /**
     * Efetiva uma transação em um adquirente. Para tanto, esse método delega a efetivação para um microserviço cuja
     * localização é retornada pelo método <code>getURL()</code>.
     *
     * @param request
     *      Dados da transação a ser efetivada no adquirente
     * @param authentication
     *      Dados de autenticação aos sistemas da adquirente.
     *
     * @return resultado da tentativa de autenticação.
     */
    @Override
    public ReturnStatus perform(TransactionRequest request, Authentication authentication) {
        System.out.println("Performing transaction using class " + getClass().getSimpleName());
        String url = getUrl();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", authentication.tokenRepresentation());

        HttpEntity<TransactionRequest> requestEntity = new HttpEntity<>(request, headers);
        ResponseEntity<ReturnStatus> exchange = restTemplate.exchange(url, HttpMethod.POST, requestEntity, ReturnStatus.class);
        return exchange.getBody();
    }
}
