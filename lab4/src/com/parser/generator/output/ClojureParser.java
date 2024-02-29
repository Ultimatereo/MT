package com.parser.generator.output;

import com.parser.generator.lexic.LexicalAnalyzer;
import com.parser.generator.lexic.factory.TokenRegexFactory;
import com.parser.generator.lexic.token.*;
import com.parser.generator.rule.NonTerminal;
import com.parser.generator.utils.Tree;

import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

public class ClojureParser {
	private final static List<SimpleToken> simpleTokens = List.of(
		new KeyWord("ns"),
		new KeyWord("defn"),
		new Symbol("(", "("),
		new Symbol(")", ")"),
		new Symbol("*", "*"),
		new Symbol("+", "+"),
		new Symbol("-", "-"),
		new Symbol("/", "/"),
		new KeyWord("let"),
		new Symbol("[", "["),
		new Symbol("]", "]")
	);
	private final static List<TokenRegexFactory> factoryTokens = List.of(
		new TokenRegexFactory("string", "\"(~[\"\\r\\n])*\""),
		new TokenRegexFactory("number", "\\d+"),
		new TokenRegexFactory("id", "[a-zA-Z][a-zA-Z0-9-]*")
	);
	LexicalAnalyzer lex;

	public Tree parse(InputStream is) throws ParseException {
		lex = new LexicalAnalyzer(is, factoryTokens, simpleTokens);
		lex.nextToken();
		return P();
	}
	private Tree OP() throws ParseException {
		switch (lex.curToken().name()) {
			case "+" -> {
				assert lex.curToken().name().equals("+");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				return new Tree(new NonTerminal("OP"), token1);
			}
			case "*" -> {
				assert lex.curToken().name().equals("*");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				return new Tree(new NonTerminal("OP"), token1);
			}
			case "/" -> {
				assert lex.curToken().name().equals("/");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				return new Tree(new NonTerminal("OP"), token1);
			}
			case "-" -> {
				assert lex.curToken().name().equals("-");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				return new Tree(new NonTerminal("OP"), token1);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree B() throws ParseException {
		switch (lex.curToken().name()) {
			case "id" -> {
				assert lex.curToken().name().equals("id");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				Tree FORM2 = FORM();
				return new Tree(new NonTerminal("B"), token1, FORM2);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree NS() throws ParseException {
		switch (lex.curToken().name()) {
			case "NS" -> {
				assert lex.curToken().name().equals("NS");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				assert lex.curToken().name().equals("id");
				Tree token2 = new Tree(lex.curToken());
				lex.nextToken();
				return new Tree(new NonTerminal("NS"), token1, token2);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree AF() throws ParseException {
		switch (lex.curToken().name()) {
			case "+" -> {
				Tree OP1 = OP();
				Tree FORMM2 = FORMM();
				return new Tree(new NonTerminal("AF"), OP1, FORMM2);
			}
			case "*" -> {
				Tree OP1 = OP();
				Tree FORMM2 = FORMM();
				return new Tree(new NonTerminal("AF"), OP1, FORMM2);
			}
			case "/" -> {
				Tree OP1 = OP();
				Tree FORMM2 = FORMM();
				return new Tree(new NonTerminal("AF"), OP1, FORMM2);
			}
			case "-" -> {
				Tree OP1 = OP();
				Tree FORMM2 = FORMM();
				return new Tree(new NonTerminal("AF"), OP1, FORMM2);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree FORM() throws ParseException {
		switch (lex.curToken().name()) {
			case "id" -> {
				Tree ATOM1 = ATOM();
				return new Tree(new NonTerminal("FORM"), ATOM1);
			}
			case "(" -> {
				Tree F1 = F();
				return new Tree(new NonTerminal("FORM"), F1);
			}
			case "number" -> {
				Tree ATOM1 = ATOM();
				return new Tree(new NonTerminal("FORM"), ATOM1);
			}
			case "string" -> {
				Tree ATOM1 = ATOM();
				return new Tree(new NonTerminal("FORM"), ATOM1);
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
				Tree FB2 = FB();
				assert lex.curToken().name().equals(")");
				Tree token3 = new Tree(lex.curToken());
				lex.nextToken();
				return new Tree(new NonTerminal("F"), token1, FB2, token3);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree AI() throws ParseException {
		switch (lex.curToken().name()) {
			case "id" -> {
				assert lex.curToken().name().equals("id");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				Tree AI2 = AI();
				return new Tree(new NonTerminal("AI"), token1, AI2);
			}
			case "]" -> {
				return new Tree(new NonTerminal("AI"));
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree ES() throws ParseException {
		switch (lex.curToken().name()) {
			case "(" -> {
				Tree F1 = F();
				Tree ES2 = ES();
				return new Tree(new NonTerminal("ES"), F1, ES2);
			}
			case ")" -> {
				return new Tree(new NonTerminal("ES"));
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree ATOM() throws ParseException {
		switch (lex.curToken().name()) {
			case "id" -> {
				assert lex.curToken().name().equals("id");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				return new Tree(new NonTerminal("ATOM"), token1);
			}
			case "number" -> {
				assert lex.curToken().name().equals("number");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				return new Tree(new NonTerminal("ATOM"), token1);
			}
			case "string" -> {
				assert lex.curToken().name().equals("string");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				return new Tree(new NonTerminal("ATOM"), token1);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree P() throws ParseException {
		switch (lex.curToken().name()) {
			case "(" -> {
				Tree SF1 = SF();
				Tree P2 = P();
				return new Tree(new NonTerminal("P"), SF1, P2);
			}
			case "$" -> {
				return new Tree(new NonTerminal("P"));
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree BS() throws ParseException {
		switch (lex.curToken().name()) {
			case "id" -> {
				Tree B1 = B();
				Tree BS2 = BS();
				return new Tree(new NonTerminal("BS"), B1, BS2);
			}
			case "]" -> {
				return new Tree(new NonTerminal("BS"));
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree SF() throws ParseException {
		switch (lex.curToken().name()) {
			case "(" -> {
				Tree F1 = F();
				return new Tree(new NonTerminal("SF"), F1);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree DEFN() throws ParseException {
		switch (lex.curToken().name()) {
			case "DEFN" -> {
				assert lex.curToken().name().equals("DEFN");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				assert lex.curToken().name().equals("id");
				Tree token2 = new Tree(lex.curToken());
				lex.nextToken();
				assert lex.curToken().name().equals("[");
				Tree token3 = new Tree(lex.curToken());
				lex.nextToken();
				Tree AI4 = AI();
				assert lex.curToken().name().equals("]");
				Tree token5 = new Tree(lex.curToken());
				lex.nextToken();
				Tree FORM6 = FORM();
				return new Tree(new NonTerminal("DEFN"), token1, token2, token3, AI4, token5, FORM6);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree FORMM() throws ParseException {
		switch (lex.curToken().name()) {
			case "(" -> {
				Tree FORM1 = FORM();
				Tree FORMM2 = FORMM();
				return new Tree(new NonTerminal("FORMM"), FORM1, FORMM2);
			}
			case "id" -> {
				Tree FORM1 = FORM();
				Tree FORMM2 = FORMM();
				return new Tree(new NonTerminal("FORMM"), FORM1, FORMM2);
			}
			case "number" -> {
				Tree FORM1 = FORM();
				Tree FORMM2 = FORMM();
				return new Tree(new NonTerminal("FORMM"), FORM1, FORMM2);
			}
			case ")" -> {
				return new Tree(new NonTerminal("FORMM"));
			}
			case "string" -> {
				Tree FORM1 = FORM();
				Tree FORMM2 = FORMM();
				return new Tree(new NonTerminal("FORMM"), FORM1, FORMM2);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree LET() throws ParseException {
		switch (lex.curToken().name()) {
			case "LET" -> {
				assert lex.curToken().name().equals("LET");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				assert lex.curToken().name().equals("[");
				Tree token2 = new Tree(lex.curToken());
				lex.nextToken();
				Tree BS3 = BS();
				assert lex.curToken().name().equals("]");
				Tree token4 = new Tree(lex.curToken());
				lex.nextToken();
				Tree ES5 = ES();
				return new Tree(new NonTerminal("LET"), token1, token2, BS3, token4, ES5);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree FB() throws ParseException {
		switch (lex.curToken().name()) {
			case "+" -> {
				Tree AF1 = AF();
				return new Tree(new NonTerminal("FB"), AF1);
			}
			case "*" -> {
				Tree AF1 = AF();
				return new Tree(new NonTerminal("FB"), AF1);
			}
			case "LET" -> {
				Tree LET1 = LET();
				return new Tree(new NonTerminal("FB"), LET1);
			}
			case "id" -> {
				Tree GF1 = GF();
				return new Tree(new NonTerminal("FB"), GF1);
			}
			case "/" -> {
				Tree AF1 = AF();
				return new Tree(new NonTerminal("FB"), AF1);
			}
			case "DEFN" -> {
				Tree DEFN1 = DEFN();
				return new Tree(new NonTerminal("FB"), DEFN1);
			}
			case "-" -> {
				Tree AF1 = AF();
				return new Tree(new NonTerminal("FB"), AF1);
			}
			case "NS" -> {
				Tree NS1 = NS();
				return new Tree(new NonTerminal("FB"), NS1);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree GF() throws ParseException {
		switch (lex.curToken().name()) {
			case "id" -> {
				assert lex.curToken().name().equals("id");
				Tree token1 = new Tree(lex.curToken());
				lex.nextToken();
				Tree FORMM2 = FORMM();
				return new Tree(new NonTerminal("GF"), token1, FORMM2);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

}
