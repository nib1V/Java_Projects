package PiggyBank;

/**
 *  Abstract Data Type that stores a type of Currency.
 *  Cannot be instantiated and therefore is used to implement
 *  Subclasses such as {@code Coin} and {@code BankNote}.
 *  @see Coin
 *  @see BankNote
 */
public abstract class Currency {
    //Private Data Member of Currency:
    private double value;

    //Constructor of Currency:
    public Currency(){}

    //Accessor of Currency:
    public abstract double getval();
}
