package PiggyBank.Exceptions;

public class InvalidBankNoteException extends Exception{
    public InvalidBankNoteException(){
        super("Invalid BankNote value given!");
    }
}
