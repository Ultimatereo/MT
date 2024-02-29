package com.parser.generator.output;

import com.parser.generator.lexic.LexicalAnalyzer;
import com.parser.generator.lexic.factory.TokenRegexFactory;
import com.parser.generator.lexic.token.KeyWord;
import com.parser.generator.lexic.token.SimpleToken;
import com.parser.generator.lexic.token.Symbol;
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

	public Tree parse(InputStream is) throws ParseException {
		lex = new LexicalAnalyzer(is, factoryTokens, simpleTokens);
		lex.nextToken();
		return S();
	}
	private Tree RT() throws ParseException {
		switch (lex.curToken().name()) {
			case ":" -> {
				assert lex.curToken().name().equals(":");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				Tree T2 = T();
				return new Tree(new NonTerminal("RT"), token1, T2);
			}
			case "$" -> {
				return new Tree(new NonTerminal("RT"));
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree S() throws ParseException {
		switch (lex.curToken().name()) {
			case "FUN" -> {
				assert lex.curToken().name().equals("FUN");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				Tree FN2 = FN();
				assert lex.curToken().name().equals("(");
				Tree token3 = new Tree(lex.curToken());
				lex.nextToken();
				Tree FA4 = FA();
				assert lex.curToken().name().equals(")");
				Tree token5 = new Tree(lex.curToken());
				lex.nextToken();
				Tree RT6 = RT();
				return new Tree(new NonTerminal("S"), token1, FN2, token3, FA4, token5, RT6);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree T() throws ParseException {
		switch (lex.curToken().name()) {
			case "name" -> {
				assert lex.curToken().name().equals("name");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				return new Tree(new NonTerminal("T"), token1);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree FN() throws ParseException {
		switch (lex.curToken().name()) {
			case "name" -> {
				assert lex.curToken().name().equals("name");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				return new Tree(new NonTerminal("FN"), token1);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree FAC() throws ParseException {
		switch (lex.curToken().name()) {
			case ")" -> {
				return new Tree(new NonTerminal("FAC"));
			}
			case "," -> {
				assert lex.curToken().name().equals(",");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				assert lex.curToken().name().equals("name");
				Tree token2 = new Tree(lex.curToken());
				lex.nextToken();
				assert lex.curToken().name().equals(":");
				Tree token3 = new Tree(lex.curToken());
				lex.nextToken();
				Tree T4 = T();
				Tree FAC5 = FAC();
				return new Tree(new NonTerminal("FAC"), token1, token2, token3, T4, FAC5);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree FA() throws ParseException {
		switch (lex.curToken().name()) {
			case "name" -> {
				assert lex.curToken().name().equals("name");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				assert lex.curToken().name().equals(":");
				Tree token2 = new Tree(lex.curToken());
				lex.nextToken();
				Tree T3 = T();
				Tree FAC4 = FAC();
				return new Tree(new NonTerminal("FA"), token1, token2, T3, FAC4);
			}
			case ")" -> {
				return new Tree(new NonTerminal("FA"));
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

}
