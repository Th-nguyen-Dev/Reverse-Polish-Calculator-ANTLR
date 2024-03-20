package logic;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import antlr.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
public class Main  {
    private static String[] stringDriver(String filename) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            return lines.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void call_Processor(String args){
            String[] lines = stringDriver(args);
            for (String line : lines) {
                System.out.println(line);
                Processor processor = new Processor(line);
                Processor.process();
                Processor.print();
                processor = null;
            }
    }

    //create a new instance of the lexer, and parser with a test string and print the parse tree
    public static void main(String[] args) throws Exception {
        call_Processor(args[0]);
    }

}
