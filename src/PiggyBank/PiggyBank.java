package PiggyBank;

import PiggyBank.Exceptions.PiggyBankFullException;
import PiggyBank.Exceptions.PiggyBankIsBrokenException;
import PiggyBank.Exceptions.PiggyBankIsNotBrokenException;

/**
 *  An Abstract Data Type used to store different types of {@code Currency},
 *  those being {@code BankNotes} and {@code Coins}.<br>
 *  The contents can only be revealed once it is broken.<br>
 *  The total capacity is {@code BankNotes <= 100} and {@code Coins <= 1000}.
 *  @see Coin
 *  @see BankNote
 *  @Methods: new: returns PiggyBank<br>
 *            new(C): returns PiggyBank<br>
 *            isBroken: PiggyBank returns Boolean<br>
 *            isFull: PiggyBank returns Boolean<br>
 *            getMoney: PiggyBank returns Double<br>
 *            beakPiggyBank: PiggyBank returns Double<br>
 *            addMoney: PiggyBank, Currency returns void
 *
 *  @Variables: P: PiggyBank, C: Currency
 *  @Axioms:  1) new.isBroken = false<br>
 *            2) new.isFull = false<br>
 *            3) new.breakPiggyBank = 0.0<br>
 *            4) new.breakPiggyBank.getMoney = 0.0<br>
 *            5) new.addMoney(C).breakPiggyBank = C.getval
 */
public class PiggyBank {
    //Defining the capacity of the ADT:
    public final int MAX_NOTES = 100;
    public final int MAX_COINS = 1000;

    //Private data members of PiggyBank:
    private double money = 0.0;
    private double[] arr = new double[100];
    private int banknotes = 0, coins = 0, size = 0;
    private boolean broken = false;

    //Constructor of PiggyBank:
    /**
     *  <b>Pre-condition</b>: the {@code Currency} given is correct based on the conditions
     *  set by {@code BankNote} and {@code Coin}.<br>
     *  <b>Post-condition</b>: Creates an instance of PiggyBank Class and
     *  adds {@code Currency} to that instance.<br>
     *  <u>Constructor</u> of ADT PiggyBank.
     *  @class PiggyBank
     *  @see Coin
     *  @see BankNote
     */
    public PiggyBank(Currency currency){
        if (currency instanceof BankNote)
            banknotes++;
        else if (currency instanceof Coin)
            coins++;
        arr[size++] = currency.getval();
    }

    //No argument constructor:
    /**
     *  <b>Pre-condition</b>:<br>
     *  <b>Post-condition</b>: Creates an instance of PiggyBank Class.<br>
     *  No-Argument <u>Constructor</u> of ADT PiggyBank.
     *  @class PiggyBank
     */
    public PiggyBank(){}

    //Transformer of PiggyBank:
    /**
     *  <b>Pre-condition</b>: The piggybank is not {@code Full} or {@code Broken}
     *  and the {@code Currency} given is correct based on the conditions
     *  set by {@code BankNote} and {@code Coin}.<br>
     *  <b>Post-condition</b>: Adds the money to the piggybank.<br>
     *  <u>Transformer</u> method of ADT PiggyBank that adds
     *  Currency to the piggybank.
     *  @throws PiggyBankFullException
     *  @throws PiggyBankIsBrokenException
     *  @class PiggyBank
     *  @see Coin
     *  @see BankNote
     */
    public void addMoney(Currency currency) throws PiggyBankFullException, PiggyBankIsBrokenException{
        if (isBroken()) throw new PiggyBankIsBrokenException();
        if (isFull()) throw new PiggyBankFullException();
        if (currency instanceof BankNote){
            banknotes++;
        }
        else if(currency instanceof Coin){
            coins++;
        }
        arr[size++] = currency.getval();
    }

    //Observers of PiggyBank:
    /**
     *  <b>Pre-condition</b>:<br>
     *  <b>Post-condition</b>: Returns whether the piggybank is full or not.<br>
     *  <u>Observer</u> method of ADT PiggyBank that returns
     *  {@code True} or {@code False} based on the capacity of the piggybank.
     *  @class PiggyBank
     */
    public boolean isFull(){return (banknotes == MAX_NOTES) || (coins == MAX_COINS);}

    /**
     *  <b>Pre-condition</b>:<br>
     *  <b>Post-condition</b>: Returns whether the piggybank is broken or not.<br>
     *  <u>Observer</u> method of ADT PiggyBank that returns
     *  {@code True} or {@code False} based on the state of the piggybank.
     *  @class PiggyBank
     */
    public boolean isBroken(){return broken;}

    //Accessors of PiggyBank:
    /**
     *  <b>Pre-condition</b>: The piggybank is not broken.<br>
     *  <b>Post-condition</b>: Returns the money from the piggybank.<br>
     *  <u>Accessor</u> method of ADT PiggyBank that returns
     *  the money from a PiggyBank we just broke.
     *  @throws PiggyBankIsBrokenException
     *  @class PiggyBank
     */
    public double breakPiggyBank() throws PiggyBankIsBrokenException{
        if (isBroken()) throw new PiggyBankIsBrokenException();
        this.broken = true;
        double sum = 0.0;
        for (int i = 0; i < size; i++) sum += arr[i];
        money = sum;
        return sum;
    }

    /**
     *  <b>Pre-condition</b>: The piggybank is already broken.<br>
     *  <b>Post-condition</b>: Returns the money from the piggybank.<br>
     *  <u>Accessor</u> method of ADT PiggyBank that returns
     *  the money from a {@code Broken} PiggyBank.
     *  @throws PiggyBankIsNotBrokenException
     *  @class PiggyBank
     */
    public double getMoney() throws PiggyBankIsNotBrokenException{
        if (!isBroken()) throw new PiggyBankIsNotBrokenException();
        return money;
    }
}