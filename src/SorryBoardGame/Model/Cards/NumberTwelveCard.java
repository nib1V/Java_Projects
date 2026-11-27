package SorryBoardGame.Model.Cards;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Pawn;

public class NumberTwelveCard extends NumberCard{
    private String card = "src/SorryBoardGame/Assets/cards/card12.png";

    /**
     * Constructor of {@code NumberTwelveCard} Class.<br>
     * <b>Post-Condition:</b> Initializes a NumberCard with the value(=12).
     * @class NumberTwelveCard
     */
    public NumberTwelveCard(){super(12);}

    /**
     * Accessor method of {@code NumberTwelveCard} Class.<br>
     * <b>Post-Condition:</b> Returns a path to the image of the front of the card.
     * @class NumberTwelveCard
     */
    public String getCard() {return card;}

    //Add details about how this movePawn should work according to the instructions of the game
    @Override
    public void movePawn(Pawn p, Board b) {}
}
