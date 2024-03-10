import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import logic.*;
import antlr.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class testLogic {

    @Test
    void testExprAsPlus() {
        Processor processor = new Processor("2+3");
        processor.process();
        assertEquals(processor.getResult(), 5);
        processor.print();
    }

    @Test
    void testExprAsMinus() {
        Processor processor = new Processor("2-3");
        processor.process();
        assertEquals(processor.getResult(), -1);
        processor.print();
        processor = null;
    }

    @Test
    void testExprAsMultiply() {
        Processor processor = new Processor("2*3");
        processor.process();
        assertEquals(processor.getResult(), 6);
        processor.print();
    }

    @Test
    void testExprAsDivide() {
        Processor processor = new Processor("2/3");
        processor.process();
        assertEquals(processor.getResult(), 0.6666666666666666);
        processor.print();
    }

    @Test
    void testExprAsComb1() {
        Processor processor = new Processor("2+(3*4)/5");
        processor.process();
        assertEquals(processor.getResult(), 4.4);
        processor.print();
    }

    @Test
    void testExprAsComb2() {
        Processor processor = new Processor("2+(3*4)/5-6");
        processor.process();
        System.out.println("2+(3*4)/5-6 = " + processor.getResult());
        processor.print();

    }

    @Test
    void testExprAsComb3() {
        Processor processor = new Processor("2+(3*4)/5-6*7");
        processor.process();
        assertEquals(processor.getResult(), -37.6);
        processor.print();
    }

    @Test
    void testExprAsComb4() {
        Processor processor = new Processor("2+(3*4)/5-6*7+sin(4)");
        processor.process();
        assertEquals(processor.getResult(), -37.75680249530793);
        processor.print();
    }

    @Test
    void testExprAsComb5() {
        Processor processor = new Processor("2+(3*4)/5-6*7+sin(4)+cos(4)");
        processor.process();
        assertEquals(processor.getResult(), -37.75680249530793 + -0.6536436208636119);
        processor.print();
    }

}
