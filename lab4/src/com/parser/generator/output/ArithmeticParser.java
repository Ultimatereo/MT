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
	private Tree<Integer> E(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "FIB", "(", "n" -> {
				Tree<Integer> T1 = T();
				Tree<Integer> EE2 = EE();
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("E"), T1, EE2);
				return t;
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> EE(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "+" -> {
				assert lex.curToken().name().equals("+");
				Tree<Integer> token1 = new Tree(lex.curToken());
				lex.nextToken();
				Tree<Integer> T2 = T();
				Tree<Integer> EE3 = EE();
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("EE"), token1, T2, EE3);
				return t;
			}
			case ")", "$" -> {
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("EE"));
				return t;
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> T(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "FIB", "(", "n" -> {
				Tree<Integer> F1 = F();
				Tree<Integer> TT2 = TT();
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("T"), F1, TT2);
				return t;
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> TT(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case ")", "+", "$" -> {
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("TT"));
				return t;
			}
			case "*" -> {
				assert lex.curToken().name().equals("*");
				Tree<Integer> token1 = new Tree(lex.curToken());
				lex.nextToken();
				Tree<Integer> F2 = F();
				Tree<Integer> TT3 = TT();
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("TT"), token1, F2, TT3);
				return t;
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> F(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "FIB" -> {
				assert lex.curToken().name().equals("FIB");
				Tree<Integer> token1 = new Tree(lex.curToken());
				lex.nextToken();
				assert lex.curToken().name().equals("(");
				Tree<Integer> token2 = new Tree(lex.curToken());
				lex.nextToken();
				Tree<Integer> E3 = E();
				assert lex.curToken().name().equals(")");
				Tree<Integer> token4 = new Tree(lex.curToken());
				lex.nextToken();
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("F"), token1, token2, E3, token4);
				return t;
			}
			case "n" -> {
				assert lex.curToken().name().equals("n");
				Tree<Integer> token1 = new Tree(lex.curToken());
				lex.nextToken();
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("F"), token1);
				return t;
			}
			case "(" -> {
				assert lex.curToken().name().equals("(");
				Tree<Integer> token1 = new Tree(lex.curToken());
				lex.nextToken();
				Tree<Integer> E2 = E();
				assert lex.curToken().name().equals(")");
				Tree<Integer> token3 = new Tree(lex.curToken());
				lex.nextToken();
				Tree<Integer> t = new Tree<Integer>(new NonTerminal("F"), token1, E2, token3);
				return t;
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

}
