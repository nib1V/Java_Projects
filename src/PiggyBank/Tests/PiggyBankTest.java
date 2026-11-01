package PiggyBank.Tests;

import PiggyBank.BankNote;
import PiggyBank.Exceptions.InvalidBankNoteException;
import PiggyBank.Exceptions.PiggyBankFullException;
import PiggyBank.Exceptions.PiggyBankIsBrokenException;
import PiggyBank.Exceptions.PiggyBankIsNotBrokenException;
import PiggyBank.PiggyBank;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class PiggyBankTest {

    //Post-Condition Testing
    @Test
    public void addMoneyPost() throws InvalidBankNoteException, PiggyBankFullException, PiggyBankIsBrokenException{
        PiggyBank koumparas = new PiggyBank();
        BankNote note = new BankNote(10);
        koumparas.addMoney(note);
        assertEquals("Post-condition Testing: ", 10.0,  koumparas.breakPiggyBank(), 0.0);
    }

    //Pre-Condition Testing
    @Test (expected = PiggyBankIsBrokenException.class)
    public void addMoneyPre1() throws InvalidBankNoteException, PiggyBankFullException, PiggyBankIsBrokenException {
        PiggyBank koumparas = new PiggyBank();
        koumparas.breakPiggyBank();
        BankNote note = new BankNote(10);
        koumparas.addMoney(note);
    }

    //Pre-Condition Testing
    @Test (expected = PiggyBankFullException.class)
    public void addMoneyPre2() throws InvalidBankNoteException, PiggyBankFullException, PiggyBankIsBrokenException {
        PiggyBank koumparas = new PiggyBank();
        for (int i = 0; i < 110; i++)
            koumparas.addMoney(new BankNote(10));
    }

    //Pre-Condition Testing
    @Test (expected = PiggyBankIsBrokenException.class)
    public void breakPiggyBankPre() throws PiggyBankIsBrokenException{
        PiggyBank koumparas = new PiggyBank();
        koumparas.breakPiggyBank();
        koumparas.breakPiggyBank();
    }

    //Post-Condition Testing
    @Test
    public void breakPiggyBankPost() throws PiggyBankIsBrokenException{
        PiggyBank koumparas = new PiggyBank();
        assertEquals("Post-condition Testing: ", 0.0,  koumparas.breakPiggyBank(), 0.0);
    }

    //Pre-Condition Testing
    @Test (expected = PiggyBankIsNotBrokenException.class)
    public void getMoneyPre() throws PiggyBankIsNotBrokenException{
        PiggyBank koumparas = new PiggyBank();
        koumparas.getMoney();
    }

    //Post-Condition Testing
    @Test
    public void getMoneyPost() throws PiggyBankIsNotBrokenException, PiggyBankIsBrokenException{
        PiggyBank koumparas = new PiggyBank();
        koumparas.breakPiggyBank();
        assertEquals("Post-condition Testing: ", 0.0,  koumparas.getMoney(), 0.0);
    }
}