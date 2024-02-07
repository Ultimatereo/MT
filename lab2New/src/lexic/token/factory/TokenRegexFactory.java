package lexic.token.factory;

import lexic.token.token.Token;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenRegexFactory {
    private final Pattern pattern;
    private final Function<String, Token> tokenGenerator;

    public TokenRegexFactory(String regex, Function<String, Token> tokenGenerator) {
        this.pattern = Pattern.compile(regex);
        this.tokenGenerator = tokenGenerator;
    }

    public Token createToken(String val) {
        Matcher matcher = pattern.matcher(val);
        if (matcher.matches()) {
            return tokenGenerator.apply(val);
        }
        return null;
    }
}
