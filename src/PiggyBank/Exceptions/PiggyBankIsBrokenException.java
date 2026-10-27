package PiggyBank.Exceptions;

public class PiggyBankIsBrokenException extends Exception {
    public PiggyBankIsBrokenException(){
        super("The Piggy is Broken!");
    }

    public PiggyBankIsBrokenException(String s){
        super(s);
    }
}
