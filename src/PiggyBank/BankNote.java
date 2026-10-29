package PiggyBank;

import PiggyBank.Exceptions.InvalidBankNoteException;

public class BankNote extends Currency{
    //Private Data Member of BankNote
    private double value;

    //Constructor of BankNote
    public BankNote(double value) throws InvalidBankNoteException {
        super(value);
        if (value != 5 && value != 10 && value != 20 && value != 50 &&
            value != 100 && value != 200 && value != 500)
            throw new InvalidBankNoteException();
        this.value = value;
    }

    //Getter of BankNote
    public double getval() {return value;}
}
