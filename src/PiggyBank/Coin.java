package PiggyBank;

import PiggyBank.Exceptions.InvalidCoinException;

/**
 *  Subclass of ADT {@code Currency} used to store the
 *  value of a coin. The acceptable values are:
 *  <b>{0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1.0, 2.0}</b>
 *  @see Currency
 */
public class Coin extends Currency{
    //Private Data Member of Coin:
    private double value;

    //Constructor of Coin:
    /**
     *  <b>Pre-condition</b>: value must be:<br>
     *  {0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1.0, 2.0}<br>
     *  <b>Post-condition</b>: Creates an instance of Coin Class with given value<br>
     *  <u>Constructor</u> of ADT Coin.
     *  @throws InvalidCoinException
     *  @see Currency
     */
    public Coin(double value) throws InvalidCoinException{
        if (value != 0.01 && value != 0.02 && value != 0.05 && value != 0.1 &&
            value != 0.2 && value != 0.5 && value != 1.0 && value != 2.0)
            throw new InvalidCoinException();
        this.value = value;
    }

    //Accessor of Coin:
    /**
     *  <b>Pre-condition</b>:<br>
     *  <b>Post-condition</b>: Returns the value of the Coin.<br>
     *  <u>Accessor</u> of ADT Coin.
     */
    public double getval() {return value;}
}
