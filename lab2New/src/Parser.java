import lexic.LexicalAnalyzer;

import java.io.InputStream;
import java.text.ParseException;

public class Parser {
    LexicalAnalyzer lex;

    //
//    Tree S() throws ParseException {
//        switch (lex.curToken()) {
//            case TokenEnum.LPAREN:
//                // (
//                lex.nextToken();
//                // S
//                Tree sub = S();
//                // )
//                if (lex.curToken() != TokenEnum.RPAREN) {
//                    throw new ParseException(") expected at position " + lex.curPos(), lex.curPos());
//                }
//                lex.nextToken();
//                // S ’
//                Tree cont = SPrime();
//                return new Tree("S", new Tree("("), sub, new Tree(")"), cont);
//            case TokenEnum.RPAREN:
//            case TokenEnum.END:
//                // eps
//                return new Tree("S");
//            default:
//                throw new AssertionError();
//        }
//    }
//
//    Tree SPrime() throws ParseException {
//        switch (lex.curToken()) {
//            case TokenEnum.LPAREN:
//                // S
//                Tree sub = S();
//                // S ’
//                Tree cont = SPrime();
//                return new Tree("S’", sub, cont);
//            case TokenEnum.RPAREN:
//            case TokenEnum.END:
//                // eps
//                return new Tree("S’");
//            default:
//                throw new AssertionError();
//        }
//    }
//
    Tree parse(InputStream is) throws ParseException {
        return null;
//        lex = new LexicalAnalyzer(is);
//        lex.nextToken();
//        return S();
    }
}
