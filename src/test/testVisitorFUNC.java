import antlr.ExprLexer;
import antlr.ExprParser;
import antlr.ExprPostOrderVisitor;
import logic.Atom;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testVisitorFUNC {
    boolean compareStacks(Queue<Atom> s1, Queue<Atom> s2) {
        if (s1.size() != s2.size()) {
//            System.out.println("size: " + s1.size() + " " + s2.size());
            return false;

        }
        while (!s1.isEmpty()) {
            Atom a1 = s1.poll();
            Atom a2 = s2.poll();
//            System.out.println("isNumber: " + a1.getIsNumber() + " " + a2.getIsNumber());
//            System.out.println("function: " + a1.getFunction() + " " + a2.getFunction());
//            System.out.println("number: " + a1.getNumber() + " " + a2.getNumber());
            if (a1.getIsNumber() != a2.getIsNumber()) {

                return false;
            }
            //test for the same function
            if (a1.getFunction() != a2.getFunction()) {

                return false;
            }
            if (a1.getNumber() != a2.getNumber()) {

                return false;
            }
//            System.out.println();
        }
        return true;
    }

    ExprParser Initializer(String input) {
        ExprLexer lexer = new ExprLexer((CharStream) CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream((TokenSource) lexer);
        return new ExprParser((TokenStream) tokens);
    }

    Queue<Atom> testExpr(String input) {
        ExprParser parser = Initializer(input);
        System.out.println(input);
        ParseTree tree = parser.prog();
        ExprPostOrderVisitor eval = new ExprPostOrderVisitor();
        return eval.visit(tree);
    }


    //Write me more unit tests that test for the all other function that is defined in Atom.Function
    @Test
    void testExprSin() {
        String input = "sin(4)";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.SIN));
        assertTrue(compareStacks(test, result));
    }
    @Test
    void testExprCos() {
        String input = "cos(4)";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.COS));
        assertTrue(compareStacks(test, result));
    }
    @Test
    void testExprTan() {
        String input = "tan(4)";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.TAN));
        assertTrue(compareStacks(test, result));
    }
    @Test
    void testExprLog() {
        String input = "log(4)";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.LOG));
        assertTrue(compareStacks(test, result));
    }
    @Test
    void testExprLn() {
        String input = "ln(4)";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.LN));
        assertTrue(compareStacks(test, result));
    }
    @Test
    void testExprTanh() {
        String input = "tanh(4)";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.TANH));
        assertTrue(compareStacks(test, result));
    }
    @Test
    void testExprCosh() {
        String input = "cosh(4)";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.COSH));
        assertTrue(compareStacks(test, result));
    }
    @Test
    void testExprSinh() {
        String input = "sinh(4)";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.SINH));
        assertTrue(compareStacks(test, result));
    }

    @Test
    void testExprFactorial() {
        String input = "4!";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.FACTORIAL));
        assertTrue(compareStacks(test, result));
    }
    //Write me more unit tests that test for the all other combinations of function that is defined in Atom.Function
    @Test
    void testExprSinFactorial() {
        String input = "sin(4)!";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.SIN));
        result.add(new Atom(false, 0, Atom.Function.FACTORIAL));
        assertTrue(compareStacks(test, result));
    }
    @Test
    void testExprSinFactorialCos() {
        String input = "sin(4)!cos(4)";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.SIN));
        result.add(new Atom(false, 0, Atom.Function.FACTORIAL));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.COS));
        assertTrue(compareStacks(test, result));
    }
    @Test
    void testExprSinFactorialCosFactorial() {
        String input = "sin(4)!cos(4)!";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.SIN));
        result.add(new Atom(false, 0, Atom.Function.FACTORIAL));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.COS));
        result.add(new Atom(false, 0, Atom.Function.FACTORIAL));
        assertTrue(compareStacks(test, result));
    }
    //Write me more unit tests that test for the all other functions in form of f(g(x)) that is defined in Atom.Function
    @Test
    void testExprSinCos() {
        String input = "sin(cos(4))";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.COS));
        result.add(new Atom(false, 0, Atom.Function.SIN));
        assertTrue(compareStacks(test, result));
    }
    @Test
    void testExprSinCosTan() {
        String input = "sin(cos(tan(4)))";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.TAN));
        result.add(new Atom(false, 0, Atom.Function.COS));
        result.add(new Atom(false, 0, Atom.Function.SIN));
        assertTrue(compareStacks(test, result));
    }
    @Test
    void testExprSinCosTanLog() {
        String input = "sin(cos(tan(log(4))))";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.LOG));
        result.add(new Atom(false, 0, Atom.Function.TAN));
        result.add(new Atom(false, 0, Atom.Function.COS));
        result.add(new Atom(false, 0, Atom.Function.SIN));
        assertTrue(compareStacks(test, result));
    }
    @Test
    void testExprSinCosTanLogLn() {
        String input = "sin(cos(tan(log(ln(4)))))";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.LN));
        result.add(new Atom(false, 0, Atom.Function.LOG));
        result.add(new Atom(false, 0, Atom.Function.TAN));
        result.add(new Atom(false, 0, Atom.Function.COS));
        result.add(new Atom(false, 0, Atom.Function.SIN));
        assertTrue(compareStacks(test, result));
    }







}