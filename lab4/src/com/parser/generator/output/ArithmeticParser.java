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

public class ArithmeticParser {
	private final static List<SimpleToken> simpleTokens = List.of(
		new Symbol("+", "+"),
		new Symbol("*", "*"),
		new Symbol("(", "("),
		new Symbol(")", ")")
	);
	private final static List<TokenRegexFactory> factoryTokens = List.of(
		new TokenRegexFactory("n", "\\d+")
	);
	LexicalAnalyzer lex;

	public Tree parse(InputStream is) throws ParseException {
		lex = new LexicalAnalyzer(is, factoryTokens, simpleTokens);
		lex.nextToken();
		return E();
	}
	private Tree EE() throws ParseException {
		switch (lex.curToken().name()) {
			case "+" -> {
				assert lex.curToken().name().equals("+");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				Tree T2 = T();
				Tree EE3 = EE();
				return new Tree(new NonTerminal("EE"), token1, T2, EE3);
			}
			case ")" -> {
				return new Tree(new NonTerminal("EE"));
			}
			case "$" -> {
				return new Tree(new NonTerminal("EE"));
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree TT() throws ParseException {
		switch (lex.curToken().name()) {
			case "*" -> {
				assert lex.curToken().name().equals("*");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				Tree F2 = F();
				Tree TT3 = TT();
				return new Tree(new NonTerminal("TT"), token1, F2, TT3);
			}
			case "+" -> {
				return new Tree(new NonTerminal("TT"));
			}
			case ")" -> {
				return new Tree(new NonTerminal("TT"));
			}
			case "$" -> {
				return new Tree(new NonTerminal("TT"));
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree T() throws ParseException {
		switch (lex.curToken().name()) {
			case "(" -> {
				Tree F1 = F();
				Tree TT2 = TT();
				return new Tree(new NonTerminal("T"), F1, TT2);
			}
			case "n" -> {
				Tree F1 = F();
				Tree TT2 = TT();
				return new Tree(new NonTerminal("T"), F1, TT2);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree E() throws ParseException {
		switch (lex.curToken().name()) {
			case "(" -> {
				Tree T1 = T();
				Tree EE2 = EE();
				return new Tree(new NonTerminal("E"), T1, EE2);
			}
			case "n" -> {
				Tree T1 = T();
				Tree EE2 = EE();
				return new Tree(new NonTerminal("E"), T1, EE2);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree F() throws ParseException {
		switch (lex.curToken().name()) {
			case "(" -> {
				assert lex.curToken().name().equals("(");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				Tree E2 = E();
				assert lex.curToken().name().equals(")");
				Tree token3 = new Tree(lex.curToken());
				lex.nextToken();
				return new Tree(new NonTerminal("F"), token1, E2, token3);
			}
			case "n" -> {
				assert lex.curToken().name().equals("n");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				return new Tree(new NonTerminal("F"), token1);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

}
