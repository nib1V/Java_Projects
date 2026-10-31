package PiggyBank;

import PiggyBank.Exceptions.InvalidBankNoteException;

/**
 *  Subclass of ADT {@code Currency} used to store the
 *  value of a banknote. The acceptable values are:
 *  <b>{5, 10, 20, 50, 100, 200, 500}</b>
 *  @see Currency
 */
public class BankNote extends Currency{
    //Private Data Member of BankNote:
    private double value;

    //Constructor of BankNote:
    /**
     *  <b>Pre-condition</b>: value must be:<br>
     *  {5, 10, 20, 50, 100, 200, 500}<br>
     *  <b>Post-condition</b>: Creates an instance of BankNote Class with given value<br>
     *  <u>Constructor</u> of ADT BankNote.
     *  @throws InvalidBankNoteException
     *  @see Currency
     */
    public BankNote(double value) throws InvalidBankNoteException {
        if (value != 5 && value != 10 && value != 20 && value != 50 &&
            value != 100 && value != 200 && value != 500)
            throw new InvalidBankNoteException();
        this.value = value;
    }

    //Accessor of BankNote:
    /**
     *  <b>Pre-condition</b>:<br>
     *  <b>Post-condition</b>: Returns the value of the BankNote.<br>
     *  <u>Accessor</u> of ADT BankNote.
     */
    public double getval() {return value;}
}
