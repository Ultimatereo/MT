package com.parser.generator;

import com.parser.generator.lexic.factory.TokenRegexFactory;
import com.parser.generator.lexic.token.KeyWord;
import com.parser.generator.lexic.token.SimpleToken;
import com.parser.generator.lexic.token.Symbol;
import com.parser.generator.lexic.token.Token;
import com.parser.generator.rule.Element;
import com.parser.generator.rule.NonTerminal;
import com.parser.generator.rule.Rule;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LL1ParserGenerator implements ParserGenerator {
    private final static String dirPath = "D:\\KT\\MT\\lab4\\src\\com\\parser\\generator\\output\\";
    private static final String imports = """
            package com.parser.generator.output;
                        
            import com.parser.generator.lexic.LexicalAnalyzer;
            import com.parser.generator.lexic.factory.TokenRegexFactory;
            import com.parser.generator.lexic.token.SimpleToken;
            import com.parser.generator.lexic.token.Token;
            import com.parser.generator.lexic.token.Symbol;
            import com.parser.generator.lexic.token.Token;
            import com.parser.generator.rule.NonTerminal;
            import com.parser.generator.utils.Tree;
                        
            import java.io.InputStream;
            import java.text.ParseException;
            import java.util.List;
            
            """;
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
    private final Map<NonTerminal, Map<Token, Rule>> ntRules = new HashMap<>();
    public Map<NonTerminal, Map<Token, Rule>> ntRules() {
        return ntRules;
    }

    public LL1ParserGenerator(List<Rule> rules, List<SimpleToken> simpleTokens, List<TokenRegexFactory> factoryTokens) {
        this.rules = rules;
        this.simpleTokens = simpleTokens;
        this.factoryTokens = factoryTokens;
        createFirst();
        createFollow();
        createNTRules();
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
    public void generate(String generatorName) {
        StringBuilder code = new StringBuilder(imports);
        generateClass(code, generatorName);
        String fileName = dirPath + generatorName + "Parser.java";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(code.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateClass(StringBuilder code, String generatorName) {
        code.append("public class ").append(generatorName).append("Parser {\n");
        generateSimpleTokens(code);
        generateFactoryTokens(code);
        code.append("\tLexicalAnalyzer lex;\n\n");
        generateParseFunction(code);
        for (NonTerminal nt : ntRules.keySet()) {
            generateFunction(code, nt, ntRules.get(nt));
        }
        code.append("}\n");
    }

    private void generateFunction(StringBuilder code, NonTerminal nt, Map<Token, Rule> tokenRuleMap) {
        code.append("\tprivate Tree ").append(nt.name()).append("() throws ParseException {\n");
        code.append("\t\tswitch (lex.curToken().name()) {\n");
        for (Token token: tokenRuleMap.keySet()) {
            code.append("\t\t\tcase \"").append(token.name()).append("\" -> {\n");
            generateRule(code, tokenRuleMap.get(token));
            code.append("\t\t\t}\n");
        }
        code.append("\t\t\tdefault -> throw new IllegalStateException(\"Unexpected value: \" + lex.curToken());\n");
        code.append("\t\t}\n\n");
        code.append("\t}\n\n");
    }

    private void generateRule(StringBuilder code, Rule rule) {
        if (rule.rightPart().getFirst().equals(epsilon)) {
            String rc = "return new Tree(new NonTerminal(\""+ rule.leftPart().name() +"\"));\n";
            code.append("\t\t\t\t").append(rc);
            return;
        }
        List<String> commands = new ArrayList<>();
        List<String> nodes = new ArrayList<>();
        int counter = 0;
        for (Element element: rule.rightPart()) {
            counter++;
            if (element instanceof NonTerminal) {
                String var = element.name() + counter;
                nodes.add(var);
                String command = "Tree " + var + " = " + element.name() + "();\n";
                commands.add(command);
            } else {
                Token token = (Token) element;
                String var = "token" + counter;
                nodes.add(var);
                String c1 = "assert lex.curToken().name().equals(\"" + element.name() + "\");\n";
                String c2 = "Tree " + var + " = " + "new Tree(lex.curToken());\n";
                String c3 = "lex.nextToken();\n";
                commands.add(c1);
                commands.add(c2);
                commands.add(c3);
            }
        }
        String rc = "return new Tree(new NonTerminal(\""+ rule.leftPart().name() +"\")"+ getNodes(nodes)  + ");\n";
        commands.add(rc);
        for (String c : commands) {
            code.append("\t\t\t\t").append(c);
        }
    }

    private String getNodes(List<String> nodes) {
        StringBuilder sb = new StringBuilder();
        for (String node: nodes) {
            sb.append(", ").append(node);
        }
        return sb.toString();
    }

    private void generateParseFunction(StringBuilder code) {
        code.append("\tpublic Tree parse(InputStream is) throws ParseException {\n");
        code.append("\t\tlex = new LexicalAnalyzer(is, factoryTokens, simpleTokens);\n");
        code.append("\t\tlex.nextToken();\n");
        code.append("\t\treturn ").append(rules.get(0).leftPart().name()).append("();\n");
        code.append("\t}\n");
    }

    private void generateFactoryTokens(StringBuilder code) {
        code.append("\tprivate final static List<TokenRegexFactory> factoryTokens = List.of(\n");
        for (TokenRegexFactory tokenRegexFactory: factoryTokens) {
            code.append("\t\tnew TokenRegexFactory(\"").append(tokenRegexFactory.name()).append("\", \"")
                    .append(doubleDashes(tokenRegexFactory.regex())).append("\"),\n");
        }
        deleteCommaIfNeeded(code);
        code.append("\t);\n");
    }

    private StringBuilder doubleDashes(String regex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < regex.length(); i++) {
            char c = regex.charAt(i);
            if (c == '\\') {
                sb.append("\\\\");
            } else {
                sb.append(c);
            }
        }
        return sb;
    }

    private void generateSimpleTokens(StringBuilder code) {
        code.append("\tprivate final static List<SimpleToken> simpleTokens = List.of(\n");
        for (SimpleToken token: simpleTokens) {
            if (token instanceof Symbol) {
                code.append("\t\tnew Symbol(\"").append(token.name()).append("\", \"")
                        .append(token.value()).append("\"),\n");
            } else if (token instanceof KeyWord) {
                code.append("\t\tnew KeyWord(\"").append(token.value()).append("\"),\n");
            } else {
                throw new IllegalArgumentException("Unknown subclass of SimpleToken! " + token.getClass());
            }
        }
        deleteCommaIfNeeded(code);
        code.append("\t);\n");
    }

    private static void deleteCommaIfNeeded(StringBuilder code) {
        if (code.length() > 1 && code.charAt(code.length() - 2) == ',') {
            code.deleteCharAt(code.length() - 2);
        }
    }

    private void createNTRules() {
        for (Rule rule : rules) {
            Set<Token> s = new HashSet<>(createFirst(rule.rightPart()));
            if (s.contains(epsilon)) {
                s.remove(epsilon);
                s.addAll(follow.get(rule.leftPart()));
            }
            for (Token token : s) {
                ntRules.putIfAbsent(rule.leftPart(), new HashMap<>());
                if (ntRules.get(rule.leftPart()).containsKey(token)) {
                    throw new IllegalArgumentException(
                            "There are two rules starting with token '" + token.name() + "': " +
                                    ntRules.get(rule.leftPart()).get(token).toString() + " and " +
                                    rule
                    );
                }
                ntRules.get(rule.leftPart()).put(token, rule);
            }
        }
    }
}
