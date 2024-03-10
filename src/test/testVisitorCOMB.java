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

public class testVisitorCOMB {
    boolean compareStacks(Queue<Atom> s1, Queue<Atom> s2) {
        boolean isSame = true;
        if (s1.size() != s2.size()) {
//            System.out.println("size: " + s1.size() + " " + s2.size());
//            return false;

        }
        while (!s1.isEmpty()) {
            Atom a1 = s1.poll();
            Atom a2 = s2.poll();
            if (a2 == null) {
                a2 = new Atom(false, 0, Atom.Function.DEFAULT);
            }
            System.out.println("isNumber: " + a1.getIsNumber() + " " + a2.getIsNumber());
            System.out.println("function: " + a1.getFunction() + " " + a2.getFunction());
            System.out.println("number: " + a1.getNumber() + " " + a2.getNumber());
            if (a1.getIsNumber() != a2.getIsNumber()) {
                isSame = false;
//                return false;
            }
            //test for the same function
            if (a1.getFunction() != a2.getFunction()) {
                isSame = false;
//                return false;
            }
            if (a1.getNumber() != a2.getNumber()) {
                isSame = false;
//                return false;
            }
            System.out.println();
        }
        return isSame;
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
    @Test
    void testExprComb1() {
        String input = "2+(3*4)/5";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MULTIPLY));
        result.add(new Atom(true, 5, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.DIVIDE));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        assertTrue(compareStacks(test, result));
    }
    //Write me more unit tests that use all type of funtions in combinations with each other to create complicated expressions. Do not repeat old test

    @Test
    void testExprComb2() {
        String input = "2+(3*4)/5**6";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MULTIPLY));
        result.add(new Atom(true, 5, Atom.Function.DEFAULT));
        result.add(new Atom(true, 6, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.POWER));
        result.add(new Atom(false, 0, Atom.Function.DIVIDE));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        assertTrue(compareStacks(test, result));
    }

    @Test
    void testExprComb3() {
        String input = "2+(3*4)/5**6+7-8*9";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MULTIPLY));
        result.add(new Atom(true, 5, Atom.Function.DEFAULT));
        result.add(new Atom(true, 6, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.POWER));
        result.add(new Atom(false, 0, Atom.Function.DIVIDE));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        result.add(new Atom(true, 7, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        result.add(new Atom(true, 8, Atom.Function.DEFAULT));
        result.add(new Atom(true, 9, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MULTIPLY));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertTrue(compareStacks(test, result));
    }

    @Test
    void testExprComb4() {
        String input = "2+(3*4)/5**6+7-8*9+sin(4)";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MULTIPLY));
        result.add(new Atom(true, 5, Atom.Function.DEFAULT));
        result.add(new Atom(true, 6, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.POWER));
        result.add(new Atom(false, 0, Atom.Function.DIVIDE));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        result.add(new Atom(true, 7, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        result.add(new Atom(true, 8, Atom.Function.DEFAULT));
        result.add(new Atom(true, 9, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MULTIPLY));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.SIN));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        assertTrue(compareStacks(test, result));
    }

    @Test
    void testExprComb5() {
        String input = "2+(3*4)/5**6+7-8*9+sin(4)!*cos(4)!";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MULTIPLY));
        result.add(new Atom(true, 5, Atom.Function.DEFAULT));
        result.add(new Atom(true, 6, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.POWER));
        result.add(new Atom(false, 0, Atom.Function.DIVIDE));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        result.add(new Atom(true, 7, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        result.add(new Atom(true, 8, Atom.Function.DEFAULT));
        result.add(new Atom(true, 9, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MULTIPLY));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.SIN));
        result.add(new Atom(false, 0, Atom.Function.FACTORIAL));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.COS));
        result.add(new Atom(false, 0, Atom.Function.FACTORIAL));
        result.add(new Atom(false, 0, Atom.Function.MULTIPLY));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        assertTrue(compareStacks(test, result));
    }



}