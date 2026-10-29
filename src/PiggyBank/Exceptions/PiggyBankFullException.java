package PiggyBank.Exceptions;

/**
 * Checked {@code Exception} thrown if Piggy Bank
 * is full during the execution of {@code addMoney}
 * method of PiggyBank class.
 * @see PiggyBank.Exceptions
 */

public class PiggyBankFullException extends Exception {
    public PiggyBankFullException(){
        super("Piggy Bank is Full");
    }

    public PiggyBankFullException(String s){
        super(s);
    }
}
