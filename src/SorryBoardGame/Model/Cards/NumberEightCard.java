package SorryBoardGame.Model.Cards;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Pawn;

public class NumberEightCard extends NumberCard{
    private String card = "src/SorryBoardGame/Assets/cards/card8.png";

    /**
     * Constructor of {@code NumberEightCard} Class.<br>
     * <b>Post-Condition:</b> Initializes a NumberCard with the value(=8).
     * @class NumberEightCard
     */
    public NumberEightCard(){super(8);}

    /**
     * Accessor method of {@code NumberEightCard} Class.<br>
     * <b>Post-Condition:</b> Returns a path to the image of the front of the card.
     * @class NumberEightCard
     */
    public String getCard() {return card;}

    //Add details about how this movePawn should work according to the instructions of the game
    @Override
    public void movePawn(Pawn p, Board b) {}
}
