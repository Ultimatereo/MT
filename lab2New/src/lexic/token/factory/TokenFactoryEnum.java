package lexic.token.factory;

import lexic.token.token.Name;
import lexic.token.token.Value;

public enum TokenFactoryEnum {
    NAME_FACTORY(new TokenRegexFactory("[a-zA-Z_][a-zA-Z0-9_]*", Name::new)),
    VALUE_FACTORY(new TokenRegexFactory("[0-9]+[lLfF]?|\"[a-zA-Z_][a-zA-Z0-9_]*\"|'.'", Value::new));

    private final TokenRegexFactory tokenFactory;

    TokenFactoryEnum(TokenRegexFactory tokenFactory) {
        this.tokenFactory = tokenFactory;
    }

    public TokenRegexFactory tokenFactory() {
        return tokenFactory;
    }
}
