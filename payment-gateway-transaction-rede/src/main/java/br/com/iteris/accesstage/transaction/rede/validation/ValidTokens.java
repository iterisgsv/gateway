package br.com.iteris.accesstage.transaction.rede.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.iteris.accesstage.model.primitives.Token;

/**
 * Armazena em memória os tokens de autenticação válidos para esse módulo.
 *
 * @author iterisgsv
 */
@Component
public class ValidTokens {

    private final List<Token> tokens;

    public ValidTokens() {
        List<Token> baseList = new ArrayList<>();
        baseList.add(new Token("REDE1"));
        baseList.add(new Token("REDE2"));
        baseList.add(new Token("REDE3"));
        tokens = Collections.unmodifiableList(baseList);
    }

    /**
     * Verifica se o token recebido das camadas superiores é válido ou não.
     *
     * @param token
     *      Token a ser validado.
     *
     * @return True caso o token for válido, false caso contário.
     */
    public boolean isValid(Token token) {
        return tokens.contains(token);
    }
}
