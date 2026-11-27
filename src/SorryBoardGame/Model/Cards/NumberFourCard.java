package SorryBoardGame.Model.Cards;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Pawn;

public class NumberFourCard extends NumberCard{
    private String card = "src/SorryBoardGame/Assets/cards/card4.png";

    /**
     * Constructor of {@code NumberFourCard} Class.<br>
     * <b>Post-Condition:</b> Initializes a NumberCard with the value(=4).
     * @class NumberFourCard
     */
    public NumberFourCard(){super(4);}

    /**
     * Accessor method of {@code NumberFourCard} Class.<br>
     * <b>Post-Condition:</b> Returns a path to the image of the front of the card.
     * @class NumberFourCard
     */
    public String getCard() {return card;}

    //Add details about how this movePawn should work according to the instructions of the game
    @Override
    public void movePawn(Pawn p, Board b) {}
}
