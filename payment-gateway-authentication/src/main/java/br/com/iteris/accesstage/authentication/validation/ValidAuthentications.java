package br.com.iteris.accesstage.authentication.validation;

import java.util.HashMap;
import java.util.Map;

import br.com.iteris.accesstage.model.ClientId;
import br.com.iteris.accesstage.model.authentication.AuthenticationInfo;
import br.com.iteris.accesstage.model.primitives.Token;

import static br.com.iteris.accesstage.model.authentication.AuthenticationType.CIELO;
import static br.com.iteris.accesstage.model.authentication.AuthenticationType.REDE;

public class ValidAuthentications {
    private Map<ClientId, AuthenticationInfo> clientIds = new HashMap<>();

    public ValidAuthentications() {
        clientIds.put(ClientId.from("12345", "1343234123"), new AuthenticationInfo(REDE, new Token("REDE1")));
        clientIds.put(ClientId.from("12346", "2345244565"), new AuthenticationInfo(REDE, new Token("REDE2")));
        clientIds.put(ClientId.from("12347", "9876574728"), new AuthenticationInfo(REDE, new Token("REDE3")));
        clientIds.put(ClientId.from("12348", "2452345213"), new AuthenticationInfo(CIELO, new Token("CIELO1")));
        clientIds.put(ClientId.from("12349", "4325554592"), new AuthenticationInfo(CIELO, new Token("CIELO2")));
        clientIds.put(ClientId.from("12350", "8658473676"), new AuthenticationInfo(CIELO, new Token("CIELO3")));
    }

    public boolean contains(ClientId clientId) {
        return clientIds.containsKey(clientId);
    }

    public AuthenticationInfo find(ClientId clientId) {
        return clientIds.get(clientId);
    }
}
