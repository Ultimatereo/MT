import lexic.LexicalAnalyzer;
import lexic.token.token.TokenEnum;

import java.io.InputStream;
import java.text.ParseException;

public class Parser {
    LexicalAnalyzer lex;


    Tree S() throws ParseException {
        return null;
//        switch (lex.curToken()) {
//            TokenEnum.FUN.token() {
//            default -> throw new IllegalStateException("Unexpected value: " + lex.curToken());
//        }
    }

    Tree parse(InputStream is) throws ParseException {
        lex = new LexicalAnalyzer(is);
        lex.nextToken();
        return S();
    }
}
