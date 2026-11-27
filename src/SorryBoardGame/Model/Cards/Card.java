package SorryBoardGame.Model.Cards;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Pawn;

public abstract class Card {
    private String backcard = "src/SorryBoardGame/Assets/cards/backCard.png";

    /**
     * Abstract Transformer method of {@code Card} Class.<br>
     * <b>Pre-Condition:</b> The given Pawn exists in the Board that is given
     * and is not in a HomeSquare.<br>
     * <b>Post-Condition:</b> Moves the Pawn to the Square of the Board that the card dictates.
     * @class Card
     * @param p the pawn that the move will be applied to.
     * @param b the board that the pawn exists on.
     */
    public abstract void movePawn(Pawn p, Board b);

    /**
     * Accessor method of {@code Card} Class.<br>
     * <b>Post-Condition:</b> Returns a String containing the path to the image of the back on every Card.
     * @class Card
     */
    public String getBackcard() {return backcard;}
}
