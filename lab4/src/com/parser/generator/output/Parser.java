package com.parser.generator.output;

import com.parser.generator.lexic.LexicalAnalyzer;
import com.parser.generator.lexic.factory.TokenRegexFactory;
import com.parser.generator.lexic.token.SimpleToken;
import com.parser.generator.lexic.token.Symbol;
import com.parser.generator.lexic.token.Token;
import com.parser.generator.rule.NonTerminal;
import com.parser.generator.utils.Tree;

import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

public class Parser {
    private final static List<SimpleToken> simpleTokens = List.of(
            new Symbol("+"),
            new Symbol("*"),
            new Symbol("("),
            new Symbol(")")
    );
    private final static List<TokenRegexFactory> factoryTokens = List.of(
            new TokenRegexFactory("n", "\\d+")
    );

    LexicalAnalyzer lex;

    Tree parse(InputStream is) throws ParseException {
        lex = new LexicalAnalyzer(is, factoryTokens, simpleTokens);
        lex.nextToken();
        return E();
    }

    private Tree E() throws ParseException {
        switch (lex.curToken().name()) {
            case "(", "n" -> {
                Tree T1 = T();
                assert lex.curToken().name().equals("+");
                Tree token2 = new Tree(new Token("+", "+"));
                lex.nextToken();
                Tree E12 = E1();
                return new Tree(new NonTerminal("E"), T1, E12);
            }
            default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
        }
    }

    private Tree E1() throws ParseException  {
        return null;
    }

    private Tree T() throws ParseException  {
        return null;
    }
}
