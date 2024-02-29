package com.parser.generator;

import com.parser.generator.lexic.factory.TokenRegexFactory;
import com.parser.generator.lexic.token.SimpleToken;
import com.parser.generator.lexic.token.Symbol;
import com.parser.generator.lexic.token.Token;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArithmeticParser {
    private final static Map<String, NonTerminal> nts = Map.of(
            "E", new NonTerminal("E"),
            "E'", new NonTerminal("E'"),
            "T", new NonTerminal("T"),
            "T'", new NonTerminal("T'"),
            "F", new NonTerminal("F")
    );

    private final static Map<String, Token> ts = Map.of(
            "+", new Symbol("+"),
            "*", new Symbol("*"),
            "(", new Symbol("("),
            ")", new Symbol(")"),
            "n", new Token("n")
    );
    private final static List<Rule> rules = List.of(
            new Rule(nts.get("E"), nts.get("T"), nts.get("E'")),
            new Rule(nts.get("E'"), ts.get("+"), nts.get("T"), nts.get("E'")),
            new Rule(nts.get("E'"), LL1ParserGenerator.epsilon),
            new Rule(nts.get("T"), nts.get("F"), nts.get("T'")),
            new Rule(nts.get("T'"), ts.get("*"), nts.get("F"), nts.get("T'")),
            new Rule(nts.get("T'"), LL1ParserGenerator.epsilon),
            new Rule(nts.get("F"), ts.get("n")),
            new Rule(nts.get("F"), ts.get("("), nts.get("E") , ts.get(")"))
    );
    private final static List<SimpleToken> simpleTokens = List.of(
            (SimpleToken) ts.get("+"),
            (SimpleToken) ts.get("*"),
            (SimpleToken) ts.get("("),
            (SimpleToken) ts.get(")")
    );
    private final static List<TokenRegexFactory> factoryTokens = List.of(
            new TokenRegexFactory("n", "\\d+")
    );


    public static void main(String[] args) {
        LL1ParserGenerator arithmeticGenerator = new LL1ParserGenerator(
                rules, simpleTokens, factoryTokens
        );

        System.out.println("FIRST");
        Map<NonTerminal, Set<Token>> first = arithmeticGenerator.first();
        for (NonTerminal nt : first.keySet()) {
            System.out.print(nt.name() + ": ");
            for (Token token: first.get(nt)) {
                System.out.print(token.name() + ", ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("FOLLOW");
        Map<NonTerminal, Set<Token>> follow = arithmeticGenerator.follow();
        for (NonTerminal nt : follow.keySet()) {
            System.out.print(nt.name() + ": ");
            for (Token token: follow.get(nt)) {
                System.out.print(token.name() + ", ");
            }
            System.out.println();
        }
    }
}