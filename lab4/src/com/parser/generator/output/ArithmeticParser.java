package com.parser.generator.output;

import com.parser.generator.lexic.LexicalAnalyzer;
import com.parser.generator.lexic.factory.TokenRegexFactory;
import com.parser.generator.lexic.token.*;
import com.parser.generator.rule.NonTerminal;
import com.parser.generator.utils.Tree;

import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

public class ArithmeticParser {
	private final static List<SimpleToken> simpleTokens = List.of(
		new Symbol("+", "+"),
		new Symbol("*", "*"),
		new Symbol("(", "("),
		new Symbol(")", ")"),
		new KeyWord("fib")
	);
	private final static List<TokenRegexFactory> factoryTokens = List.of(
		new TokenRegexFactory("n", "\\d+")
	);
	LexicalAnalyzer lex;

	public Tree<Integer> parse(InputStream is) throws ParseException {
		lex = new LexicalAnalyzer(is, factoryTokens, simpleTokens);
		lex.nextToken();
		return E();
	}
	private Tree<Integer> EE(Integer... values) throws ParseException {
		int acc = values[0];
		switch (lex.curToken().name()) {
			case "$", ")" -> {
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("EE"));
				t.val = acc;
				return t;
			}
            case "+" -> {
				assert lex.curToken().name().equals("+");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				Tree<Integer> T2 = T(value1);
				Integer value2 = T2.val();
				int addRes = acc + value2;
				Tree<Integer> EE3 = EE(addRes);
				Integer value3 = EE3.val();
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("EE"), token1, T2, EE3);
				t.val = value3;
				return t;
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> TT(Integer... values) throws ParseException {
		int acc = values[0];
		switch (lex.curToken().name()) {
			case "$", ")", "+" -> {
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("TT"));
				t.val = acc;
				return t;
			}
            case "*" -> {
				assert lex.curToken().name().equals("*");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				Tree<Integer> F2 = F(value1);
				Integer value2 = F2.val();
				int mulRes = acc * value2;
				Tree<Integer> TT3 = TT(mulRes);
				Integer value3 = TT3.val();
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("TT"), token1, F2, TT3);
				t.val = acc;
				return t;
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> T(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "n", "FIB", "(" -> {
				Tree<Integer> F1 = F();
				Integer value1 = F1.val();
				Tree<Integer> TT2 = TT(value1);
				Integer value2 = TT2.val();
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("T"), F1, TT2);
				t.val = value2;
				return t;
			}
            default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> E(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "n", "FIB", "(" -> {
				Tree<Integer> T1 = T();
				Integer value1 = T1.val();
				Tree<Integer> EE2 = EE(value1);
				Integer value2 = EE2.val();
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("E"), T1, EE2);
				t.val = value2;
				return t;
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> F(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "n" -> {
				assert lex.curToken().name().equals("n");
				Token token = lex.curToken();
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("F"), token1);
				t.val = Integer.parseInt(token.value());
				return t;
			}
			case "FIB" -> {
				assert lex.curToken().name().equals("FIB");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				assert lex.curToken().name().equals("(");
				Tree<Integer> token2 = new Tree(lex.curToken());
				Integer value2 = token2.val();
				lex.nextToken();
				Tree<Integer> E3 = E(value1, value2);
				Integer value3 = E3.val();
				assert lex.curToken().name().equals(")");
				Tree<Integer> token4 = new Tree(lex.curToken());
				Integer value4 = token4.val();
				lex.nextToken();
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("F"), token1, token2, E3, token4);
				t.val = fib(value3);
				return t;
			}
			case "(" -> {
				assert lex.curToken().name().equals("(");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				Tree<Integer> E2 = E(value1);
				Integer value2 = E2.val();
				assert lex.curToken().name().equals(")");
				Tree<Integer> token3 = new Tree(lex.curToken());
				Integer value3 = token3.val();
				lex.nextToken();
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("F"), token1, E2, token3);
				t.val = value2;
				return t;
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Integer fib(Integer n) {
		if (n <= 1) {
			return n;
		}
		int fib = 1;
		int prevFib = 1;
		for (int i = 2; i < n; i++) {
			int temp = fib;
			fib += prevFib;
			prevFib = temp;
		}
		return fib;
	}

}
