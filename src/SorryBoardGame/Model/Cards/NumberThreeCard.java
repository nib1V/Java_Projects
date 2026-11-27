package SorryBoardGame.Model.Cards;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Pawn;

public class NumberThreeCard extends NumberCard{
    private String card = "src/SorryBoardGame/Assets/cards/card3.png";

    /**
     * Constructor of {@code NumberThreeCard} Class.<br>
     * <b>Post-Condition:</b> Initializes a NumberCard with the value(=3).
     * @class NumberThreeCard
     */
    public NumberThreeCard(){super(3);}

    /**
     * Accessor method of {@code NumberThreeCard} Class.<br>
     * <b>Post-Condition:</b> Returns a path to the image of the front of the card.
     * @class NumberThreeCard
     */
    public String getCard() {return card;}

    //Add details about how this movePawn should work according to the instructions of the game
    @Override
    public void movePawn(Pawn p, Board b) {}
}
