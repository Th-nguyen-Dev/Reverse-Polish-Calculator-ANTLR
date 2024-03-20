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

        postfix = "";
        operations.clear();
        stack.clear();
        result = 0.0;
        operations = eval.visit(tree);

    }
    int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }

    public long factorialUsingForLoop(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
    public void processOperation(Atom.Function function){
        Double b;
        Double a;
        switch (function) {
            case DEFAULT:
                return;
            case NEG:
                b = stack.pop();
                stack.push(-b);
                postfix += "NEG" + " ";
                break;
            case POS:
                postfix += "POS" + " ";
                break;
            case PLUS:
                b = stack.pop();
                a = stack.pop();
                stack.push(a + b);
                postfix += "+" + " ";
                break;
            case MINUS:
                b = stack.pop();
                a = stack.pop();
                stack.push(a - b);
                postfix += "-" + " ";
                break;
            case MULTIPLY:
                b = stack.pop();
                a = stack.pop();
                stack.push(a* b);
                postfix += "*" + " ";
                break;
            case DIVIDE:
                b = stack.pop();
                a = stack.pop();
                stack.push((Double) (a / b));
                postfix += "/" + " ";
                break;
            case POWER:
                b = stack.pop();
                a = stack.pop();
                stack.push(Math.pow(a, b));
                postfix += "**" + " ";
                break;
            case FACTORIAL:
                b = stack.pop();
                stack.push((double) factorialUsingForLoop(b.intValue()));
                postfix += "!" + " ";
                break;
            case SIN:
                b = stack.pop();
                stack.push(Math.sin(b));
                postfix += "SIN" + " ";
                break;
            case COS:
                b = stack.pop();
                stack.push(Math.cos(b));
                postfix += "COS" + " ";
                break;
            case TAN:
                b = stack.pop();
                stack.push(Math.tan(b));
                postfix += "TAN" + " ";
                break;
            case COSH:
                b = stack.pop();
                stack.push(Math.cosh(b));
                postfix += "COSH" + " ";
                break;
            case SINH:
                b = stack.pop();
                stack.push(Math.sinh(b));
                postfix += "SINH" + " ";
                break;
            case TANH:
                b = stack.pop();
                stack.push(Math.tanh(b));
                postfix += "TANH" + " ";
                break;
            case LOG:
                b = stack.pop();
                stack.push(Math.log10(b));
                postfix += "LOG" + " ";
                break;
            case LN:
                b = stack.pop();
                stack.push(Math.log(b));
                postfix += "LN" + " ";
                break;

        }


    }
    public void print(){
        System.out.println("Input: " + input);
        System.out.println("Postfix: " + postfix);
        System.out.println("Result: " + result);
        System.out.println();
    }
    public void process(){

        while (!operations.isEmpty()) {
            Atom a = operations.poll();
            if (a.getIsNumber()) {
                stack.push(a.getNumber());
                String temp = Double.toString(a.getNumber()) + " ";
                postfix = postfix + temp;
            } else {
                processOperation(a.getFunction());
            }
        }
        result = stack.pop();


    }

    public String getPostfix() {
        return postfix;
    }
    public  String getInput() {
        return input;
    }

    public  Double getResult() {
        return result;
    }

    

    private Double result;
    private String resultString;
    private final String input;
    private String postfix;
    private Queue<Atom> operations = new ArrayDeque<Atom>();
    private Stack<Double> stack = new Stack<Double>();


}
