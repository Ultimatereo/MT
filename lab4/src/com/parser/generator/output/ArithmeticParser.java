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
		new Symbol(")", ")")
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
	private Tree<Integer> EE() throws ParseException {
		switch (lex.curToken().name()) {
			case ")" -> {
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("EE"));
			}
			case "$" -> {
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("EE"));
			}
			case "+" -> {
				assert lex.curToken().name().equals("+");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				Tree<Integer> T2 = T();
				Integer value2 = T2.val();
				Tree<Integer> EE3 = EE();
				Integer value3 = EE3.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("EE"), token1, T2, EE3);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> TT() throws ParseException {
		switch (lex.curToken().name()) {
			case ")" -> {
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("TT"));
			}
			case "*" -> {
				assert lex.curToken().name().equals("*");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				Tree<Integer> F2 = F();
				Integer value2 = F2.val();
				Tree<Integer> TT3 = TT();
				Integer value3 = TT3.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("TT"), token1, F2, TT3);
			}
			case "$" -> {
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("TT"));
			}
			case "+" -> {
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("TT"));
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> T() throws ParseException {
		switch (lex.curToken().name()) {
			case "(" -> {
				Tree<Integer> F1 = F();
				Integer value1 = F1.val();
				Tree<Integer> TT2 = TT();
				Integer value2 = TT2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("T"), F1, TT2);
			}
			case "n" -> {
				Tree<Integer> F1 = F();
				Integer value1 = F1.val();
				Tree<Integer> TT2 = TT();
				Integer value2 = TT2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("T"), F1, TT2);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> E() throws ParseException {
		switch (lex.curToken().name()) {
			case "(" -> {
				Tree<Integer> T1 = T();
				Integer value1 = T1.val();
				Tree<Integer> EE2 = EE();
				Integer value2 = EE2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("E"), T1, EE2);
			}
			case "n" -> {
				Tree<Integer> T1 = T();
				Integer value1 = T1.val();
				Tree<Integer> EE2 = EE();
				Integer value2 = EE2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("E"), T1, EE2);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> F() throws ParseException {
		switch (lex.curToken().name()) {
			case "(" -> {
				assert lex.curToken().name().equals("(");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				Tree<Integer> E2 = E();
				Integer value2 = E2.val();
				assert lex.curToken().name().equals(")");
				Tree<Integer> token3 = new Tree(lex.curToken());
				Integer value3 = token3.val();
				lex.nextToken();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("F"), token1, E2, token3);
			}
			case "n" -> {
				assert lex.curToken().name().equals("n");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("F"), token1);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

}
