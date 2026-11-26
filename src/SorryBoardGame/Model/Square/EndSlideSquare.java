package SorryBoardGame.Model.Square;

import SorryBoardGame.Model.Pawn;

public class EndSlideSquare extends SlideSquare{

    public EndSlideSquare(int Color){
        super(Color);
    }

    public String getIcon(){return "SorryBoardGame/Assets/slides/" + getIconColor() + "SlideEnd.png";}

    /**
     * Transformer method of {@code EndSlideSquare} Class.<br>
     * <b>Post-Condition:</b> Inserts a Pawn into the EndSlideSquare.
     * @class EndSlideSquare
     * @param pawn the pawn to be placed in the EndSlideSquare
     */
    @Override
    public void setPawn(Pawn pawn) {}
}
