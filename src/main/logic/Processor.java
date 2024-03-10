package logic;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import antlr.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Queue;

public class Processor {
    public Processor(String input){
        this.input = input;
        ExprLexer lexer = new ExprLexer((CharStream) CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream((TokenSource) lexer);
        ExprParser parser = new ExprParser((TokenStream) tokens);
        ParseTree tree = parser.prog();
        ExprPostOrderVisitor eval = new ExprPostOrderVisitor();
        operations = eval.visit(tree);
    }
    static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }
    public static void processOperation(Atom.Function function){
        Double a = stack.pop();
        Double b = stack.pop();
        switch (function) {
            case DEFAULT:
                return;
            case PLUS:
                stack.push(a + b);
                break;
            case MINUS:
                stack.push(a - b);
                break;
            case MULTIPLY:
                stack.push(a* b);
                break;
            case DIVIDE:
                stack.push((Double) (a / b));
                break;
            case POWER:
                stack.push(Math.pow(a, b));
                break;
            case FACTORIAL:
                stack.push(a);
                stack.push((double) factorial(b.intValue()));
                break;

        }

    }
    public static void print(){}
    public static void process(){

        while (!operations.isEmpty()) {
            Atom a = operations.poll();
            if (a.getIsNumber()) {
                stack.push(a.getNumber());
            } else {
                processOperation(a.getFunction());
            }
        }
    }

    private String input;
    private String postfix;
    private static Queue<Atom> operations = new ArrayDeque<Atom>();
    private static Stack<Double> stack = new Stack<Double>();






}
