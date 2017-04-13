package br.com.iteris.accesstage.transaction.cielo.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.iteris.accesstage.model.primitives.Token;

@Component
public class ValidTokens {

    private final List<Token> tokens;

    public ValidTokens() {
        List<Token> baseList = new ArrayList<>();
        baseList.add(new Token("CIELO1"));
        baseList.add(new Token("CIELO2"));
        baseList.add(new Token("CIELO3"));
        tokens = Collections.unmodifiableList(baseList);
    }

    public boolean isValid(Token token) {
        return tokens.contains(token);
    }
}
