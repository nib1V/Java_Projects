package SorryBoardGame.Model.Cards;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Pawn;

public class NumberOneCard extends NumberCard{
    private String card = "src/SorryBoardGame/Assets/cards/card1.png";

    /**
     * Constructor of {@code NumberOneCard} Class.<br>
     * <b>Post-Condition:</b> Initializes a NumberCard with the value(=1).
     * @class NumberOneCard
     */
    public NumberOneCard(){super(1);}

    /**
     * Accessor method of {@code NumberOneCard} Class.<br>
     * <b>Post-Condition:</b> Returns a path to the image of the front of the card.
     * @class NumberOneCard
     */
    public String getCard() {return card;}

    //Add details about how this movePawn should work according to the instructions of the game
    @Override
    public void movePawn(Pawn p, Board b) {}
}
