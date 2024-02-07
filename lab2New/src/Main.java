import lexic.LexicalAnalyzer;
import lexic.token.token.Token;
import lexic.token.token.TokenEnum;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        String test = "public inline Int.fun<T>(a: (List<Int?>, T) -> Int, aboba: Int = 1000, biba: String = \"aboba\") -> Unit";
        testLexic(test);
//        testParse(test);
    }

    private static void testLexic(String test) throws ParseException {
        InputStream is = new ByteArrayInputStream(StandardCharsets.UTF_8.encode(test).array());
        LexicalAnalyzer la = new LexicalAnalyzer(is);
        while (true) {
            la.nextToken();
            Token token = la.curToken();
            System.out.println("Parsed " + token + ": " + token.value());
            if (token == TokenEnum.END.token()) {
                break;
            }
        }
    }

    private static void testParse(String test) throws IOException {
        Parser p = new Parser();
        File dotFile = new File("graph.dot");
        parseAnsSaveIfComplete(p, test, dotFile);
        File pngFile = new File("graph.png");
        DotToPngConverter.convertDotToPng(dotFile.getPath(), pngFile.getPath());
    }

    private static void parseAnsSaveIfComplete(Parser p, String test, File filePath) throws IOException {
        try {
            Tree t = p.parse(new ByteArrayInputStream(StandardCharsets.UTF_8.encode(test).
                    array()));
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write("digraph ParserResult {\n");
                t.writeUsing(writer);
                writer.write("}");
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
