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

	public Tree<Integer> parse(InputStream is) throws ParseException {
		lex = new LexicalAnalyzer(is, factoryTokens, simpleTokens);
		lex.nextToken();
		return P();
	}
	private Tree<Integer> OP(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "+" -> {
				assert lex.curToken().name().equals("+");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("OP"), token1);
			}
			case "*" -> {
				assert lex.curToken().name().equals("*");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("OP"), token1);
			}
			case "/" -> {
				assert lex.curToken().name().equals("/");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("OP"), token1);
			}
			case "-" -> {
				assert lex.curToken().name().equals("-");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("OP"), token1);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> B(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "id" -> {
				assert lex.curToken().name().equals("id");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				Tree<Integer> FORM2 = FORM(value1);
				Integer value2 = FORM2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("B"), token1, FORM2);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> NS(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "NS" -> {
				assert lex.curToken().name().equals("NS");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				assert lex.curToken().name().equals("id");
				Tree<Integer> token2 = new Tree(lex.curToken());
				Integer value2 = token2.val();
				lex.nextToken();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("NS"), token1, token2);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> AF(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "+" -> {
				Tree<Integer> OP1 = OP();
				Integer value1 = OP1.val();
				Tree<Integer> FORMM2 = FORMM(value1);
				Integer value2 = FORMM2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("AF"), OP1, FORMM2);
			}
			case "*" -> {
				Tree<Integer> OP1 = OP();
				Integer value1 = OP1.val();
				Tree<Integer> FORMM2 = FORMM(value1);
				Integer value2 = FORMM2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("AF"), OP1, FORMM2);
			}
			case "/" -> {
				Tree<Integer> OP1 = OP();
				Integer value1 = OP1.val();
				Tree<Integer> FORMM2 = FORMM(value1);
				Integer value2 = FORMM2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("AF"), OP1, FORMM2);
			}
			case "-" -> {
				Tree<Integer> OP1 = OP();
				Integer value1 = OP1.val();
				Tree<Integer> FORMM2 = FORMM(value1);
				Integer value2 = FORMM2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("AF"), OP1, FORMM2);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> FORM(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "id" -> {
				Tree<Integer> ATOM1 = ATOM();
				Integer value1 = ATOM1.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FORM"), ATOM1);
			}
			case "(" -> {
				Tree<Integer> F1 = F();
				Integer value1 = F1.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FORM"), F1);
			}
			case "number" -> {
				Tree<Integer> ATOM1 = ATOM();
				Integer value1 = ATOM1.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FORM"), ATOM1);
			}
			case "string" -> {
				Tree<Integer> ATOM1 = ATOM();
				Integer value1 = ATOM1.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FORM"), ATOM1);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> F(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "(" -> {
				assert lex.curToken().name().equals("(");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				Tree<Integer> FB2 = FB(value1);
				Integer value2 = FB2.val();
				assert lex.curToken().name().equals(")");
				Tree<Integer> token3 = new Tree(lex.curToken());
				Integer value3 = token3.val();
				lex.nextToken();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("F"), token1, FB2, token3);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> AI(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "id" -> {
				assert lex.curToken().name().equals("id");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				Tree<Integer> AI2 = AI(value1);
				Integer value2 = AI2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("AI"), token1, AI2);
			}
			case "]" -> {
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("AI"));
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> ES(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "(" -> {
				Tree<Integer> F1 = F();
				Integer value1 = F1.val();
				Tree<Integer> ES2 = ES(value1);
				Integer value2 = ES2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("ES"), F1, ES2);
			}
			case ")" -> {
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("ES"));
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> ATOM(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "id" -> {
				assert lex.curToken().name().equals("id");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("ATOM"), token1);
			}
			case "number" -> {
				assert lex.curToken().name().equals("number");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("ATOM"), token1);
			}
			case "string" -> {
				assert lex.curToken().name().equals("string");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("ATOM"), token1);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> P(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "(" -> {
				Tree<Integer> SF1 = SF();
				Integer value1 = SF1.val();
				Tree<Integer> P2 = P(value1);
				Integer value2 = P2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("P"), SF1, P2);
			}
			case "$" -> {
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("P"));
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> BS(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "id" -> {
				Tree<Integer> B1 = B();
				Integer value1 = B1.val();
				Tree<Integer> BS2 = BS(value1);
				Integer value2 = BS2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("BS"), B1, BS2);
			}
			case "]" -> {
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("BS"));
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> SF(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "(" -> {
				Tree<Integer> F1 = F();
				Integer value1 = F1.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("SF"), F1);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> DEFN(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "DEFN" -> {
				assert lex.curToken().name().equals("DEFN");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				assert lex.curToken().name().equals("id");
				Tree<Integer> token2 = new Tree(lex.curToken());
				Integer value2 = token2.val();
				lex.nextToken();
				assert lex.curToken().name().equals("[");
				Tree<Integer> token3 = new Tree(lex.curToken());
				Integer value3 = token3.val();
				lex.nextToken();
				Tree<Integer> AI4 = AI(value1, value2, value3);
				Integer value4 = AI4.val();
				assert lex.curToken().name().equals("]");
				Tree<Integer> token5 = new Tree(lex.curToken());
				Integer value5 = token5.val();
				lex.nextToken();
				Tree<Integer> FORM6 = FORM(value1, value2, value3, value4, value5);
				Integer value6 = FORM6.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("DEFN"), token1, token2, token3, AI4, token5, FORM6);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> FORMM(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "(" -> {
				Tree<Integer> FORM1 = FORM();
				Integer value1 = FORM1.val();
				Tree<Integer> FORMM2 = FORMM(value1);
				Integer value2 = FORMM2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FORMM"), FORM1, FORMM2);
			}
			case "id" -> {
				Tree<Integer> FORM1 = FORM();
				Integer value1 = FORM1.val();
				Tree<Integer> FORMM2 = FORMM(value1);
				Integer value2 = FORMM2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FORMM"), FORM1, FORMM2);
			}
			case "number" -> {
				Tree<Integer> FORM1 = FORM();
				Integer value1 = FORM1.val();
				Tree<Integer> FORMM2 = FORMM(value1);
				Integer value2 = FORMM2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FORMM"), FORM1, FORMM2);
			}
			case ")" -> {
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FORMM"));
			}
			case "string" -> {
				Tree<Integer> FORM1 = FORM();
				Integer value1 = FORM1.val();
				Tree<Integer> FORMM2 = FORMM(value1);
				Integer value2 = FORMM2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FORMM"), FORM1, FORMM2);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> LET(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "LET" -> {
				assert lex.curToken().name().equals("LET");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				assert lex.curToken().name().equals("[");
				Tree<Integer> token2 = new Tree(lex.curToken());
				Integer value2 = token2.val();
				lex.nextToken();
				Tree<Integer> BS3 = BS(value1, value2);
				Integer value3 = BS3.val();
				assert lex.curToken().name().equals("]");
				Tree<Integer> token4 = new Tree(lex.curToken());
				Integer value4 = token4.val();
				lex.nextToken();
				Tree<Integer> ES5 = ES(value1, value2, value3, value4);
				Integer value5 = ES5.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("LET"), token1, token2, BS3, token4, ES5);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> FB(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "+" -> {
				Tree<Integer> AF1 = AF();
				Integer value1 = AF1.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FB"), AF1);
			}
			case "*" -> {
				Tree<Integer> AF1 = AF();
				Integer value1 = AF1.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FB"), AF1);
			}
			case "LET" -> {
				Tree<Integer> LET1 = LET();
				Integer value1 = LET1.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FB"), LET1);
			}
			case "id" -> {
				Tree<Integer> GF1 = GF();
				Integer value1 = GF1.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FB"), GF1);
			}
			case "/" -> {
				Tree<Integer> AF1 = AF();
				Integer value1 = AF1.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FB"), AF1);
			}
			case "DEFN" -> {
				Tree<Integer> DEFN1 = DEFN();
				Integer value1 = DEFN1.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FB"), DEFN1);
			}
			case "-" -> {
				Tree<Integer> AF1 = AF();
				Integer value1 = AF1.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FB"), AF1);
			}
			case "NS" -> {
				Tree<Integer> NS1 = NS();
				Integer value1 = NS1.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("FB"), NS1);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

	private Tree<Integer> GF(Integer... values) throws ParseException {
		switch (lex.curToken().name()) {
			case "id" -> {
				assert lex.curToken().name().equals("id");
				Tree<Integer> token1 = new Tree(lex.curToken());
				Integer value1 = token1.val();
				lex.nextToken();
				Tree<Integer> FORMM2 = FORMM(value1);
				Integer value2 = FORMM2.val();
				// TODO Count value of this node
				return new Tree<Integer>(new NonTerminal("GF"), token1, FORMM2);
			}
			default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
		}

	}

}
