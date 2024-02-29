package com.parser.generator;

import com.parser.generator.lexic.factory.TokenRegexFactory;
import com.parser.generator.lexic.token.SimpleToken;
import com.parser.generator.lexic.token.Token;

import java.io.File;
import java.util.*;

public class LL1ParserGenerator implements ParserGenerator {
    public static final Token epsilon = new Token("ε", "");
    private static final Token end = new Token("$", "");
    private final List<Rule> rules;
    private final List<SimpleToken> simpleTokens;
    private final List<TokenRegexFactory> factoryTokens;

    public Map<NonTerminal, Set<Token>> first() {
        return first;
    }

    public Map<NonTerminal, Set<Token>> follow() {
        return follow;
    }

    private final Map<NonTerminal, Set<Token>> first = new HashMap<>();
    private final Map<NonTerminal, Set<Token>> follow = new HashMap<>();

    public LL1ParserGenerator(List<Rule> rules, List<SimpleToken> simpleTokens, List<TokenRegexFactory> factoryTokens) {
        this.rules = rules;
        this.simpleTokens = simpleTokens;
        this.factoryTokens = factoryTokens;
        createFirst();
        createFollow();
        checkLL1Grammar();
    }

    private void createFollow() {
        NonTerminal S = rules.getFirst().leftPart();
        follow.put(S, new HashSet<>());
        follow.get(S).add(end);
        boolean change = true;
        while (change) {
            change = false;
            for (Rule rule : rules) {
                for (int i = 0; i < rule.rightPart().size(); i++) {
                    if (rule.rightPart().get(i) instanceof NonTerminal B) {
                        follow.putIfAbsent(B, new HashSet<>());
                        int oldSize = follow.get(B).size();
                        List<Element> afterB = rule.rightPart().subList(i + 1, rule.rightPart().size());

                        Set<Token> s = createFirst(afterB);
                        if (s.contains(epsilon)) {
                            s.remove(epsilon);
                            s.addAll(follow.getOrDefault(rule.leftPart(), new HashSet<>()));
                        }
                        follow.get(B).addAll(s);
                        int newSize = follow.get(B).size();
                        if (newSize > oldSize) {
                            change = true;
                        }
                    }
                }
            }
        }
    }

    private void createFirst() {
        boolean change = true;
        while (change) {
            change = false;
            for (Rule rule : rules) {
                NonTerminal nt = rule.leftPart();
                first.putIfAbsent(nt, new HashSet<>());
                int oldSize = first.get(nt).size();
                Set<Token> newTokens = createFirst(rule.rightPart());
                first.get(nt).addAll(newTokens);
                int newSize = first.get(nt).size();
                if (newSize > oldSize) {
                    change = true;
                }
            }
        }

    }

    private Set<Token> createFirst(List<Element> elements) {
        Set<Token> s = new HashSet<>();
        if (elements.isEmpty()) {
            s.add(epsilon);
            return s;
        }
        Element f = elements.getFirst();
        if (f instanceof Token) {
            s.add((Token) f);
            return s;
        }
        s = new HashSet<>(first.getOrDefault((NonTerminal) f, new HashSet<>()));
        if (s.contains(epsilon)) {
            if (elements.size() > 1) {
                s.remove(epsilon);
                s.addAll(createFirst(elements.subList(1, elements.size())));
            }
        }
        return s;
    }


    @Override
    public void generate(File directory) {
        // TODO
    }

    private void checkLL1Grammar() {
// TODO
    }
}
