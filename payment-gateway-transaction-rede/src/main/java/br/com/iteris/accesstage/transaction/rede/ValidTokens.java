package br.com.iteris.accesstage.transaction.rede;

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
        baseList.add(new Token("REDE1"));
        baseList.add(new Token("REDE2"));
        baseList.add(new Token("REDE3"));
        tokens = Collections.unmodifiableList(baseList);
    }

    public boolean isValid(Token token) {
        return tokens.contains(token);
    }
}
