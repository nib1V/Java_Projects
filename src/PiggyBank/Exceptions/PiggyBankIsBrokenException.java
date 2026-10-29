package PiggyBank.Exceptions;

/**
 * Checked {@code Exception} thrown if Piggy Bank
 * is broken during the execution of {@code addMoney}
 * or {@code breakPiggyBank} method of PiggyBank class.
 * @see PiggyBank.Exceptions
 */

public class PiggyBankIsBrokenException extends Exception {
    public PiggyBankIsBrokenException(){
        super("The Piggy is Broken!");
    }

    public PiggyBankIsBrokenException(String s){
        super(s);
    }
}
