package PiggyBank.Exceptions;

public class InvalidCoinException extends Exception{
    public InvalidCoinException(){
        super("Invalid coin value given!");
    }
}
