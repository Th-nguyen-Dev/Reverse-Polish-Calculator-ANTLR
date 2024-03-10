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

public class testVisitorMD {
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
            if (a1.getFunction() != a2.getFunction()){

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

    @Test
    void testExprAsPlus() {
        String input = "2*3";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MULTIPLY));
        assertEquals(compareStacks(test, result), true);
    }
    @Test
    void testExprAsDevide() {
        String input = "2/3";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.DIVIDE));
        assertEquals(compareStacks(test, result), true);
    }

    @Test
    void testExprAsDivideMultiply() {
        String input = "2/3*4";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.DIVIDE));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MULTIPLY));
        assertEquals(compareStacks(test, result), true);
    }

    @Test
    void testExprAsMultiplyDivide() {
        String input = "2*3/4";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MULTIPLY));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.DIVIDE));
        assertEquals(compareStacks(test, result), true);
    }
    @Test
    void testExprAsMultiplyNeg() {
        String input = "2*-4";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.NEG));
        result.add(new Atom(false, 0, Atom.Function.MULTIPLY));
        assertEquals(compareStacks(test, result), true);
    }
    void testExprAsNegDivde() {
        String input = "--4/2";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.NEG));
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertEquals(compareStacks(test, result), true);
    }

    @Test
    void testExprAsMultiplyNegExtream() {
        String input = "2*-40000000000001";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 40000000000001L, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.NEG));
        result.add(new Atom(false, 0, Atom.Function.MULTIPLY));
        assertEquals(compareStacks(test, result), true);
    }
    void testExprAsDivideNegExtream() {
        String input = "--40000000000001/2";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 40000000000001L, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.NEG));
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.DIVIDE));
        assertEquals(compareStacks(test, result), true);
    }
}

