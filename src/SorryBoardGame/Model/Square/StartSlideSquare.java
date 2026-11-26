package SorryBoardGame.Model.Square;

import SorryBoardGame.Model.Pawn;

public class StartSlideSquare extends SlideSquare{

    public StartSlideSquare(int Color){
        super(Color);
    }

    public String getIcon(){return "SorryBoardGame/Assets/slides/" + getIconColor() + "SlideStart.png";}

    /**
     * Transformer method of {@code StartSlideSquare} Class.<br>
     * <b>Post-Condition:</b> Inserts a Pawn into the StartSlideSquare.
     * @class StartSlideSquare
     * @param pawn the pawn to be placed in the StartSlideSquare
     */
    @Override
    public void setPawn(Pawn pawn) {}
}
