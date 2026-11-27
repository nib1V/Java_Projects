package SorryBoardGame.Model.Cards;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Pawn;

public class NumberSevenCard extends NumberCard{
    private String card = "src/SorryBoardGame/Assets/cards/card7.png";

    /**
     * Constructor of {@code NumberSevenCard} Class.<br>
     * <b>Post-Condition:</b> Initializes a NumberCard with the value(=7).
     * @class NumberSevenCard
     */
    public NumberSevenCard(){super(7);}

    /**
     * Accessor method of {@code NumberSevenCard} Class.<br>
     * <b>Post-Condition:</b> Returns a path to the image of the front of the card.
     * @class NumberSevenCard
     */
    public String getCard() {return card;}

    //Add details about how this movePawn should work according to the instructions of the game
    @Override
    public void movePawn(Pawn p, Board b) {}
}
