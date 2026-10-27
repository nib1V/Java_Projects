package PiggyBank;

import PiggyBank.Exceptions.InvalidCoinException;

public class Coin {
    //Private Data Member of Coin
    private double value;

    //Constructor of Coin
    public Coin(double value) throws InvalidCoinException{
        if (value != 0.0 && value != 0.01 && value != 0.02 && value != 0.05 && value != 0.1 &&
            value != 0.2 && value != 0.5 && value != 1.0 && value != 2.0)
            throw new InvalidCoinException();
        this.value = value;
    }

    //Getter of Coin
    public double getval() {return value;}
}
