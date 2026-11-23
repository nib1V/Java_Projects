package SorryBoardGame.Model.Square;

import SorryBoardGame.Model.Pawn;

public class SimpleSquare extends Square{

    /**
     * Constructor of {@code SimpleSqurare} Class.<br>
     * <b>Post-Condition:</b> Creates a Default white Square.
     * @class SimpleSquare
     */
    public SimpleSquare(){
        super();
    }

    /**
     * Transformer of {@code SimpleSquare} Class.<br>
     * <b>Pre-Condition:</b> The Given Pawn must align to the game's state.<br>
     * <b>Post-Condition:</b> The Pawn is placed in the square or if there is another
     * one in the same square then the Pawn replaces it.
     * @class SimpleSquare
     * @param pawn
     */
    @Override
    public void setPawn(Pawn pawn){}
}
