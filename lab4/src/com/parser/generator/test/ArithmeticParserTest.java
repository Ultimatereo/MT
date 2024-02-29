package com.parser.generator.test;

import com.parser.generator.output.ArithmeticParser;
import com.parser.generator.utils.DotToPngConverter;
import com.parser.generator.utils.Tree;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

public class ArithmeticParserTest {
    public static void main(String[] args) {
        String[] tests =
                {
                        "1+",
                        "1+2",
                        "(1 + 2) * 3",
                        "(1 + 2) * fib(3) * 2",
                        "fib((1 + 2) * fib(3) * 2)"
                };
        for (int i = 0; i < tests.length; i++) {
            try {
                testParse(tests[i], i);
            } catch (IOException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void testParse(String test, int i) throws IOException {
        ArithmeticParser p = new ArithmeticParser();
        File dotFile = new File("graph" + i + ".dot");
        parseAnsSaveIfComplete(p, test, dotFile);
        File pngFile = new File("graph" + i + ".png");
        DotToPngConverter.convertDotToPng(dotFile.getPath(), pngFile.getPath());
    }

    private static void parseAnsSaveIfComplete(ArithmeticParser p, String test, File filePath) throws IOException {
        try {
            Tree t = p.parse(new ByteArrayInputStream(StandardCharsets.UTF_8.encode(test).
                    array()));
            System.out.println(t.val);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write("digraph ParserResult {\n");
                t.writeUsing(writer);
                writer.write("}");
            }
            System.out.println("\"" + test + "\"" + " is parsed successfully.\n");
        } catch (ParseException e) {
            System.out.println("Error happened during parsing expression: \"" + test + "\"");
            System.out.println(e.getMessage() + "\n");
        }
    }
}
