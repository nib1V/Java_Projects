package SorryBoardGame.Model.Cards;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Pawn;

public class NumberElevenCard extends NumberCard{
    private String card = "src/SorryBoardGame/Assets/cards/card11.png";

    /**
     * Constructor of {@code NumberEleventCard} Class.<br>
     * <b>Post-Condition:</b> Initializes a NumberCard with the value(=11).
     * @class NumberElevenCard
     */
    public NumberElevenCard(){super(11);}

    /**
     * Accessor method of {@code NumberElevenCard} Class.<br>
     * <b>Post-Condition:</b> Returns a path to the image of the front of the card.
     * @class NumberElevenCard
     */
    public String getCard() {return card;}

    //Add details about how this movePawn should work according to the instructions of the game
    @Override
    public void movePawn(Pawn p, Board b) {}
}
