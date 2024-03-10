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
        postfix = "";
    }
    static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }
    public static void processOperation(Atom.Function function){
        Double b = stack.pop();
        Double a = stack.pop();
        switch (function) {
            case DEFAULT:
                return;
            case NEG:
                stack.push(a);
                stack.push(-b);
                postfix += "NEG" + " ";
                break;
            case POS:
                stack.push(a);
                stack.push(b);
                postfix += "POS" + " ";
                break;
            case PLUS:
                stack.push(a + b);
                postfix += "+" + " ";
                break;
            case MINUS:
                stack.push(a - b);
                postfix += "-" + " ";
                break;
            case MULTIPLY:
                stack.push(a* b);
                postfix += "*" + " ";
                break;
            case DIVIDE:
                stack.push((Double) (a / b));
                postfix += "/" + " ";
                break;
            case POWER:
                stack.push(Math.pow(a, b));
                postfix += "**" + " ";
                break;
            case FACTORIAL:
                stack.push(a);
                stack.push((double) factorial(b.intValue()));
                postfix += "!" + " ";
                break;
            case SIN:
                stack.push(a);
                stack.push(Math.sin(b));
                postfix += "SIN" + " ";
                break;
            case COS:
                stack.push(a);
                stack.push(Math.cos(b));
                postfix += "COS" + " ";
                break;
            case TAN:
                stack.push(a);
                stack.push(Math.tan(b));
                postfix += "TAN" + " ";
                break;
            case COSH:
                stack.push(a);
                stack.push(Math.cosh(b));
                postfix += "COSH" + " ";
                break;
            case SINH:
                stack.push(a);
                stack.push(Math.sinh(b));
                postfix += "SINH" + " ";
                break;
            case TANH:
                stack.push(a);
                stack.push(Math.tanh(b));
                postfix += "TANH" + " ";
                break;
            case LOG:
                stack.push(a);
                stack.push(Math.log10(b));
                postfix += "LOG" + " ";
                break;
            case LN:
                stack.push(a);
                stack.push(Math.log(b));
                postfix += "LN" + " ";
                break;
        }

    }
    public static void print(){
        System.out.println("Input: " + input);
        System.out.println("Postfix: " + postfix);
        System.out.println("Result: " + result);
        System.out.println();
    }
    public static void process(){

        while (!operations.isEmpty()) {
            Atom a = operations.poll();
            if (a.getIsNumber()) {
                stack.push(a.getNumber());
                String temp = Double.toString(a.getNumber()) + " ";
                postfix += temp;
            } else {
                processOperation(a.getFunction());
            }
        }
        result = stack.pop();

    }

    public static String getPostfix() {
        return postfix;
    }
    public static String getInput() {
        return input;
    }

    public static Double getResult() {
        return result;
    }

    private static Double result;
    private static String input;
    private static String postfix = new String();
    private static Queue<Atom> operations = new ArrayDeque<Atom>();
    private static Stack<Double> stack = new Stack<Double>();


}
