package com.parser.generator.lexic.factory;

import com.parser.generator.lexic.token.Token;

import java.util.regex.Pattern;

public class TokenRegexFactory {
    private final String name;
    private final Pattern pattern;

    public TokenRegexFactory(String name, String regex) {
        this.name = name;
        this.pattern = Pattern.compile(regex);
    }

    public String name() {
        return name;
    }

    public boolean check(String val) {
        return pattern.matcher(val).matches();
    }

    public Token createToken(String val) {
        if (!check(val)) {
            return null;
        }
        return new Token(name, val);
    }
}
