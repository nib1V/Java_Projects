package PiggyBank.Exceptions;

/**
 * Checked {@code Exception} thrown if given an Invalid
 * BankNote value which is controlled by the
 * {@code Constructor} of BankNote.
 * @see PiggyBank.Coin
 * @see PiggyBank.Exceptions
 */
public class InvalidBankNoteException extends Exception{
    public InvalidBankNoteException(){
        super("Invalid BankNote value given!");
    }
}
