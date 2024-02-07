import lexic.LexicalAnalyzer;
import lexic.token.token.TokenEnum;

import java.io.InputStream;
import java.text.ParseException;
import java.util.Objects;

public class Parser {
    LexicalAnalyzer lex;

    private Tree S() throws ParseException {
        TokenEnum startToken = lex.curToken();
        lex.nextToken();
        switch (startToken) {
            case TokenEnum.INLINE, TokenEnum.INFIX, TokenEnum.PUBLIC,
                    TokenEnum.PRIVATE, TokenEnum.PROTECTED, TokenEnum.INTERNAL,
                    TokenEnum.OPEN -> {
                Tree sub = S();
                return new Tree("S", new Tree("M", new Tree(startToken.token().value())), sub);
            }
            case TokenEnum.FUN -> {
//                Tree subG = G();
                Tree subFN = FN();
                assert lex.curToken() == TokenEnum.LPAREN;
                lex.nextToken();
                Tree subFA = FA();
                assert lex.curToken() == TokenEnum.RPAREN;
                lex.nextToken();
                Tree subRT = RT();
                return new Tree("S",
                        new Tree("fun"),
//                        subG,
                        subFN,
                        new Tree("("),
                        subFA,
                        new Tree(")"),
                        subRT);
            }
            default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
        }
    }

    private Tree FA() throws ParseException {
        TokenEnum startToken = lex.curToken();
        String name = startToken.token().value();
        lex.nextToken();
        if (Objects.requireNonNull(startToken) == TokenEnum.NAME) {
            assert lex.curToken() == TokenEnum.COLON;
            lex.nextToken();
            Tree subT = T();
            Tree subFAC = FAC();
            return new Tree("FA",
                    new Tree(name),
                    new Tree(":"),
                    subT,
                    subFAC);
        }
        return new Tree("FA");
    }

    private Tree FAC() throws ParseException {
        TokenEnum startToken = lex.curToken();
        lex.nextToken();
        if (Objects.requireNonNull(startToken) == TokenEnum.COMMA) {
            TokenEnum token = lex.curToken();
            String name = token.token().value();
            assert lex.curToken() == TokenEnum.NAME;
            lex.nextToken();
            assert lex.curToken() == TokenEnum.COLON;
            lex.nextToken();
            Tree subT = T();
            Tree subFAC = FAC();
            return new Tree("FAC",
                    new Tree(","),
                    new Tree(name),
                    new Tree(":"),
                    subT,
                    subFAC);
        }
        return new Tree("FAC");
    }

    private Tree FN() throws ParseException {
        TokenEnum startToken = lex.curToken();
        lex.nextToken();
        if (Objects.requireNonNull(startToken) == TokenEnum.NAME) {
            return new Tree("FN", new Tree(startToken.token().value()));
        }
        throw new IllegalStateException("Unexpected value: " + lex.curToken());
    }

    private Tree RT() throws ParseException {
        TokenEnum startToken = lex.curToken();
        lex.nextToken();
        if (Objects.requireNonNull(startToken) == TokenEnum.COLON) {
            Tree sub = T();
            assert lex.curToken() == TokenEnum.END;
            return new Tree("RT", new Tree(":"), sub);
        }
        assert lex.curToken() == TokenEnum.END;
        return new Tree("RT");
    }

    private Tree T() throws ParseException {
        TokenEnum startToken = lex.curToken();
        lex.nextToken();
        if (Objects.requireNonNull(startToken) == TokenEnum.NAME) {
            return new Tree("T", new Tree(startToken.token().value()));
        }
        throw new IllegalStateException("Unexpected value: " + lex.curToken());
    }

    Tree parse(InputStream is) throws ParseException {
        lex = new LexicalAnalyzer(is);
        lex.nextToken();
        return S();
    }
}
