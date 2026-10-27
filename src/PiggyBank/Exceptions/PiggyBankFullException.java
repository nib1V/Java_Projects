package PiggyBank.Exceptions;

public class PiggyBankFullException extends Exception {
    public PiggyBankFullException(){
        super("Piggy Bank is Full");
    }

    public PiggyBankFullException(String s){
        super(s);
    }
}
