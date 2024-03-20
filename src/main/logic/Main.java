package logic;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import antlr.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
public class Main  {
    public static void call_Processor(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine())
        {
            String expression = scanner.nextLine();
            Processor processor = new Processor(expression);
            processor.process();
            processor.print();
        }
        scanner.close();
    }

    //create a new instance of the lexer, and parser with a test string and print the parse tree
    public static void main(String[] args) throws Exception {
        call_Processor();
    }

}
