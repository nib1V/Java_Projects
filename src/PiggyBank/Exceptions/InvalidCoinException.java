package PiggyBank.Exceptions;

/**
 * Checked {@code Exception} thrown if given an Invalid
 * Coin value which is controlled by the
 * {@code Constructor} of Coin.
 * @see PiggyBank.Coin
 * @see PiggyBank.Exceptions
 */

public class InvalidCoinException extends Exception{
    public InvalidCoinException(){
        super("Invalid coin value given!");
    }
}
