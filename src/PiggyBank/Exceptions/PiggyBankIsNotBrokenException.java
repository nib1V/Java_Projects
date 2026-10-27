package PiggyBank.Exceptions;

public class PiggyBankIsNotBrokenException extends Exception {
    public PiggyBankIsNotBrokenException(){
        super("The Piggy Bank is not Broken!");
    }

    public PiggyBankIsNotBrokenException(String s){
        super(s);
    }
}
