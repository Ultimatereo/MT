package lexic.token.parse;

import lexic.token.token.Token;
import lexic.token.token.TokenEnum;

public class TokenParseTree {
    private final TrieNode root = new TrieNode();

    public TokenParseTree() {
        for (TokenEnum tokenEnum : TokenEnum.values()) {
            insert(tokenEnum.token());
        }
    }

    public static void main(String[] args) {
        TokenParseTree tpt = new TokenParseTree();
        System.out.println("End");
    }

    public TrieNode root() {
        return root;
    }

    private void insert(Token token) {
        if (token == TokenEnum.END.token()) {
            return;
        }
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
