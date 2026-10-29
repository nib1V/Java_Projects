package PiggyBank;

public abstract class Currency {
    //Private Data Member of Currency
    private double value;

    //Constructor of Currency
    public Currency(double value){
        this.value = value;
    }

    //Accessor of Currency
    public abstract double getval();
}
