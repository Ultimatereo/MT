package com.parser.generator;

import com.parser.generator.lexic.factory.TokenRegexFactory;
import com.parser.generator.lexic.token.SimpleToken;
import com.parser.generator.lexic.token.Symbol;
import com.parser.generator.lexic.token.Token;
import com.parser.generator.rule.NonTerminal;
import com.parser.generator.rule.Rule;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArithmeticMain {
    private final static Map<String, NonTerminal> nts = Map.of(
            "E", new NonTerminal("E"),
            "E'", new NonTerminal("EE"),
            "T", new NonTerminal("T"),
            "T'", new NonTerminal("TT"),
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

    private final static List<Rule> notLL1Rules = List.of(
            new Rule(nts.get("E"), nts.get("E"), ts.get("+"), nts.get("T")),
            new Rule(nts.get("E"), nts.get("T")),
            new Rule(nts.get("T"), nts.get("T"), ts.get("*"), nts.get("F")),
            new Rule(nts.get("T"), nts.get("F")),
            new Rule(nts.get("F"), ts.get("("), nts.get("E"), ts.get(")")),
            new Rule(nts.get("F"), ts.get("n"))
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
                rules, simpleTokens, factoryTokens, "Integer"
        );

        System.out.println("FIRST");
        Map<NonTerminal, Set<Token>> first = arithmeticGenerator.first();
        printTokens(first);
        System.out.println("FOLLOW");
        Map<NonTerminal, Set<Token>> follow = arithmeticGenerator.follow();
        printTokens(follow);
        Map<NonTerminal, Map<Token, Rule>> ntRules = arithmeticGenerator.ntRules();
        printNTRules(ntRules);
        try {
            LL1ParserGenerator wrongArithmeticGenerator = new LL1ParserGenerator(notLL1Rules, simpleTokens, factoryTokens, "Integer");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        arithmeticGenerator.generate("Arithmetic");
    }

    private static void printTokens(Map<NonTerminal, Set<Token>> first) {
        for (NonTerminal nt : first.keySet()) {
            System.out.print(nt.name() + ": ");
            for (Token token : first.get(nt)) {
                System.out.print(token.name() + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printNTRules(Map<NonTerminal, Map<Token, Rule>> ntRules) {
        for (Map.Entry<NonTerminal, Map<Token, Rule>> entry : ntRules.entrySet()) {
            NonTerminal nt = entry.getKey();
            Map<Token, Rule> ruleMap = entry.getValue();

            System.out.println(nt);
            for (Map.Entry<Token, Rule> ruleEntry : ruleMap.entrySet()) {
                Token token = ruleEntry.getKey();
                Rule rule = ruleEntry.getValue();
                System.out.println("\tToken: " + token);
                System.out.println("\tRule: " + rule);
            }
            System.out.println();
        }
    }
}