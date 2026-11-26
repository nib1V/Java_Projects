package SorryBoardGame.Model.Square;

import SorryBoardGame.Model.Pawn;

public class InternalSlideSquare extends SlideSquare{

    public InternalSlideSquare(int Color){
        super(Color);
    }

    public String getIcon(){return "SorryBoardGame/Assets/slides/" + getIconColor() + "SlideMedium.png";}

    /**
     * Transformer method of {@code InternalSlideSquare} Class.<br>
     * <b>Post-Condition:</b> Inserts a Pawn into the InternalSlideSquare.
     * @class InternalSlideSquare
     * @param pawn the pawn to be placed in the InternalSlideSquare
     */
    @Override
    public void setPawn(Pawn pawn) {}
}
