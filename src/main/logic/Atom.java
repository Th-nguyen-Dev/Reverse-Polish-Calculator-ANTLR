package logic;

public class Atom {
    public enum Function{
        DEFAULT,NEG, POS ,PLUS, MINUS, MULTIPLY, DIVIDE, POWER, SIN, COS, TAN, LOG, LN, FACTORIAL, TANH, COSH, SINH
    }
    public Atom(boolean isNumber, double number, Function function) {
        this.isNumber = isNumber;
        this.number = number;
        this.function = function;
    }

    public double getNumber() {
        return number;
    }

    public Function getFunction() {
        return function;
    }
    //get isNumber
    public boolean getIsNumber() {
        return isNumber;
    }

    private boolean isNumber;
    private double number;

    private Function function;
}
