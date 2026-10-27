package PiggyBank;

import PiggyBank.Exceptions.PiggyBankFullException;
import PiggyBank.Exceptions.PiggyBankIsBrokenException;
import PiggyBank.Exceptions.PiggyBankIsNotBrokenException;

public class PiggyBank {
    //Private data members of PiggyBank
    private double money;
    private double[] arr = new double[100];
    private int size = 0;
    private int banknotes = 0;
    private int coins = 0;
    private boolean broken = false;

    //Constructor of PiggyBank
    public PiggyBank(){
    }

    //Transformers of PiggyBank
    public void addMoney(BankNote note, Coin coin) throws PiggyBankFullException{
        if (isBroken()) throw new PiggyBankFullException();
        this.banknotes++;
        this.coins++;
        arr[size++] = (double)note.getval() + coin.getval();
    }

    //Observers of PiggyBank
    public boolean isFull(){
        return (banknotes + coins) == 100;
    }

    public boolean isBroken(){
        return broken;
    }

    //Accessors of PiggyBank
    public double breakPiggyBank() throws PiggyBankIsBrokenException{
        if (isBroken()) throw new PiggyBankIsBrokenException();
        this.broken = true;
        double sum = 0.0;
        for (int i = 0; i < size - 1; i++) sum += arr[i];
        money = sum;
        return sum;
    }

    public double getMoney() throws PiggyBankIsNotBrokenException{
        if (!isBroken()) throw new PiggyBankIsNotBrokenException();
        return money;
    }
}


