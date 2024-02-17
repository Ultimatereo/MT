import antlr.parser.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ClojureToPythonConverter {
    public static void main(String[] args) {
        String input = "(defn add [x y] (+ x y))\n(print (add 2 3))";
        ClojureLexer lexer = new ClojureLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ClojureParser parser = new ClojureParser(tokens);
        ParseTree tree = parser.program();

        // Создание посетителя и применение его к дереву разбора
        ClojureToPythonVisitor visitor = new ClojureToPythonVisitor();
        String pythonCode = visitor.visit(tree);

        System.out.println(pythonCode);
    }
}

