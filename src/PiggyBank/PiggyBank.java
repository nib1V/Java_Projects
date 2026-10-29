package PiggyBank;

import PiggyBank.Exceptions.PiggyBankFullException;
import PiggyBank.Exceptions.PiggyBankIsBrokenException;
import PiggyBank.Exceptions.PiggyBankIsNotBrokenException;

public class PiggyBank {
    //Private data members of PiggyBank
    private double money = 0.0;
    private double[] arr = new double[100];
    private int size = 0;
    private int banknotes = 0;
    private int coins = 0;
    private boolean broken = false;

    //Constructor of PiggyBank
    public PiggyBank(Currency currency){
        if (currency instanceof BankNote){
            banknotes++;
        }
        else if (currency instanceof Coin){
            coins++;
        }
        arr[size++] = currency.getval();
    }

    //No argument constructor
    public PiggyBank(){
    }

    //Transformers of PiggyBank
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

    //Observers of PiggyBank
    public boolean isFull(){
        return (banknotes == 100) && (coins == 1000);
    }

    public boolean isBroken(){
        return broken;
    }

    //Accessors of PiggyBank
    public double breakPiggyBank() throws PiggyBankIsBrokenException{
        if (isBroken()) throw new PiggyBankIsBrokenException();
        this.broken = true;
        double sum = 0.0;
        for (int i = 0; i < size; i++) sum += arr[i];
        money = sum;
        return sum;
    }

    public double getMoney() throws PiggyBankIsNotBrokenException{
        if (!isBroken()) throw new PiggyBankIsNotBrokenException();
        return money;
    }
}