package SorryBoardGame.Model.Cards;

public abstract class NumberCard extends Card{
    private int value;

    /**
     * Constructor of {@code NumberCard} Class.<br>
     * <b>Pre-Condition:</b> The given number is {1,2,3,4,5,7,8,10,11,12} according to the available cards.
     * @class NumberCard
     * @param value the value of the Card
     */
    public NumberCard(int value){
        this.value = value;
    }

    /**
     * Accessor method of {@code NumberCard} Class.<br>
     * <b>Post-Condition:</b> Returns the value of the given card.
     * @class NumberCard
     */
    public int getValue() {return value;}

    /**
     * Transformer method of {@code NumberCard} Class.<br>
     * <b>Pre-Condition:</b> The given value is a number in range of {1,2,3,4,5,7,8,10,11,12}.<br>
     * <b>Post-Condition:</b> Changes the value of the given Card.
     * @class NumberCard
     * @param value the value of the card
     */
    public void setValue(int value) {this.value = value;}
}
