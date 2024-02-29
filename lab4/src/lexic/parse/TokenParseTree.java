package lexic.parse;

import lexic.token.KeyWord;
import lexic.token.Symbol;
import lexic.token.Token;

import java.util.ArrayList;
import java.util.List;


public class TokenParseTree {
    private final TrieNode root = new TrieNode();

    public TokenParseTree(List<Token> tokens) {
        for (Token token : tokens) {
            insert(token);
        }
    }

    public static void main(String[] args) {
        ArrayList<Token> keyWordArrayList = new ArrayList<>();
        keyWordArrayList.add(new KeyWord("private"));
        keyWordArrayList.add(new KeyWord("protected"));
        keyWordArrayList.add(new KeyWord("public"));
        keyWordArrayList.add(new Symbol("COMMA", ","));
        TokenParseTree tpt = new TokenParseTree(keyWordArrayList);
        System.out.println("End");
    }

    public TrieNode root() {
        return root;
    }

    private void insert(Token token) {
        String value = token.value();
        TrieNode cur = root;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            cur.children().putIfAbsent(c, new TrieNode());
            cur = cur.children().get(c);
        }
        cur.setToken(token);
    }
}
