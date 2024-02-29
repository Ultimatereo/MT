package com.parser.generator.output;

import com.parser.generator.lexic.LexicalAnalyzer;
import com.parser.generator.lexic.factory.TokenRegexFactory;
import com.parser.generator.lexic.token.*;
import com.parser.generator.rule.NonTerminal;
import com.parser.generator.utils.Tree;

import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

public class KotlinFunParser {
	private final static List<SimpleToken> simpleTokens = List.of(
		new Symbol(":", ":"),
		new KeyWord("fun"),
		new Symbol("(", "("),
		new Symbol(")", ")"),
		new Symbol(",", ",")
	);
	private final static List<TokenRegexFactory> factoryTokens = List.of(
		new TokenRegexFactory("name", "[a-zA-Z_][a-zA-Z0-9_]*")
	);
	LexicalAnalyzer lex;

	public Tree<Integer> parse(InputStream is) throws ParseException {
		lex = new LexicalAnalyzer(is, factoryTokens, simpleTokens);
		lex.nextToken();
		return S();
	}
	private Tree<Integer> RT(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case ":" -> {
				assert lex.curToken().name().equals(":");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				Tree<Integer> T2 = T(value1);
				Integer value2 = T2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("RT"), token1, T2);
			}
			case "$" -> {
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("RT"));
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> S(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "FUN" -> {
				assert lex.curToken().name().equals("FUN");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				Tree<Integer> FN2 = FN(value1);
				Integer value2 = FN2.val();
				assert lex.curToken().name().equals("(");
				Tree<Integer> token3 = new Tree(lex.curToken());
				Integer value3 = token3.val();
				lex.nextToken();
				Tree<Integer> FA4 = FA(value1, value2, value3);
				Integer value4 = FA4.val();
				assert lex.curToken().name().equals(")");
				Tree<Integer> token5 = new Tree(lex.curToken());
				Integer value5 = token5.val();
				lex.nextToken();
				Tree<Integer> RT6 = RT(value1, value2, value3, value4, value5);
				Integer value6 = RT6.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("S"), token1, FN2, token3, FA4, token5, RT6);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> T(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "name" -> {
				assert lex.curToken().name().equals("name");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("T"), token1);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> FN(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "name" -> {
				assert lex.curToken().name().equals("name");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FN"), token1);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> FAC(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case ")" -> {
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FAC"));
			}
			case "," -> {
				assert lex.curToken().name().equals(",");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				assert lex.curToken().name().equals("name");
				Tree<Integer> token2 = new Tree(lex.curToken());
				Integer value2 = token2.val();
				lex.nextToken();
				assert lex.curToken().name().equals(":");
				Tree<Integer> token3 = new Tree(lex.curToken());
				Integer value3 = token3.val();
				lex.nextToken();
				Tree<Integer> T4 = T(value1, value2, value3);
				Integer value4 = T4.val();
				Tree<Integer> FAC5 = FAC(value1, value2, value3, value4);
				Integer value5 = FAC5.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FAC"), token1, token2, token3, T4, FAC5);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> FA(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "name" -> {
				assert lex.curToken().name().equals("name");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				assert lex.curToken().name().equals(":");
				Tree<Integer> token2 = new Tree(lex.curToken());
				Integer value2 = token2.val();
				lex.nextToken();
				Tree<Integer> T3 = T(value1, value2);
				Integer value3 = T3.val();
				Tree<Integer> FAC4 = FAC(value1, value2, value3);
				Integer value4 = FAC4.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FA"), token1, token2, T3, FAC4);
			}
			case ")" -> {
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FA"));
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

}
