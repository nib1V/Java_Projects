package PiggyBank;

import PiggyBank.Exceptions.*;

public class Tester {

    public static void main(String[] args) {
        try{
            PiggyBank bank = new PiggyBank();
            bank.addMoney(new BankNote(10.0));
            bank.addMoney(new Coin(0.2));
            bank.addMoney(new Coin(1.0));
            bank.addMoney(new BankNote(20));
            bank.addMoney(new Coin(1.5));
            bank.breakPiggyBank();
            System.out.println(bank.getMoney());
        }
        catch (PiggyBankIsBrokenException e){
            System.out.println("Couldn't do anything because piggybank was broken");
            System.exit(-1);
        }
        catch (PiggyBankFullException e){
            System.out.println("The piggybank was full couldn't add anything more to it");
        }
        catch (InvalidBankNoteException e){
            System.out.println("Incorrect or Counterfeit bank note given!");
        }
        catch (InvalidCoinException e){
            System.out.println("Incorrect or Counterfeit coin given!");
        }
        catch (PiggyBankIsNotBrokenException e) {
            System.out.println("The PiggyBank was not broken in order to take the money out of it!");
        }
    }
}
