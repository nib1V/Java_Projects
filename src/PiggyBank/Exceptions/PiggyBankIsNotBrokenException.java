package PiggyBank.Exceptions;

/**
 * Checked {@code Exception} thrown if Piggy Bank
 * is not broken during the execution of {@code getMoney}
 * method of PiggyBank class.
 * @see PiggyBank.Exceptions
 */

public class PiggyBankIsNotBrokenException extends Exception {
    public PiggyBankIsNotBrokenException(){
        super("The Piggy Bank is not Broken!");
    }

    public PiggyBankIsNotBrokenException(String s){
        super(s);
    }
}
