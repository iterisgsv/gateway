package br.com.iteris.accesstage.transaction.executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.iteris.accesstage.model.authentication.Authentication;
import br.com.iteris.accesstage.model.authentication.AuthenticationType;

@Service
public class CieloTransactionExecutor extends AbstractTransactionExecutor {

    @Autowired
    public CieloTransactionExecutor(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public boolean accepts(Authentication authentication) {
        return authentication.is(AuthenticationType.CIELO);
    }

    @Override
    public String getUrl() {
        return "http://transaction-cielo/";
    }
}
