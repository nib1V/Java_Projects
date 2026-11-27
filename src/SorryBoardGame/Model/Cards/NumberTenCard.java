package SorryBoardGame.Model.Cards;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Pawn;

public class NumberTenCard extends NumberCard{
    private String card = "src/SorryBoardGame/Assets/cards/card10.png";

    /**
     * Constructor of {@code NumberTenCard} Class.<br>
     * <b>Post-Condition:</b> Initializes a NumberCard with the value(=10).
     * @class NumberTenCard
     */
    public NumberTenCard(){super(10);}

    /**
     * Accessor method of {@code NumberTenCard} Class.<br>
     * <b>Post-Condition:</b> Returns a path to the image of the front of the card.
     * @class NumberTenCard
     */
    public String getCard() {return card;}

    //Add details about how this movePawn should work according to the instructions of the game
    @Override
    public void movePawn(Pawn p, Board b) {}
}
