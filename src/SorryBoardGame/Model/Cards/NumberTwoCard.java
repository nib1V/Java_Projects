package SorryBoardGame.Model.Cards;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Pawn;

public class NumberTwoCard extends NumberCard{
    private String card = "src/SorryBoardGame/Assets/cards/card2.png";

    /**
     * Constructor of {@code NumberTwoCard} Class.<br>
     * <b>Post-Condition:</b> Initializes a NumberCard with the value(=2).
     * @class NumberTwoCard
     */
    public NumberTwoCard(){super(2);}

    /**
     * Accessor method of {@code NumberTwoCard} Class.<br>
     * <b>Post-Condition:</b> Returns a path to the image of the front of the card.
     * @class NumberTwoCard
     */
    public String getCard() {return card;}

    //Add details about how this movePawn should work according to the instructions of the game
    @Override
    public void movePawn(Pawn p, Board b) {}
}
