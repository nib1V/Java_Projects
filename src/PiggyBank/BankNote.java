package PiggyBank;

import PiggyBank.Exceptions.InvalidBankNoteException;

public class BankNote {
    //Private Data Member of BankNote
    private int value;

    //Constructor of BankNote
    public BankNote(int value) throws InvalidBankNoteException {
        if (value!= 0 && value != 5 && value != 10 && value != 20 && value != 50 &&
            value != 100 && value != 200 && value != 500)
            throw new InvalidBankNoteException();
        this.value = value;
    }

    //Getter of BankNote
    public int getval() {return value;}
}
