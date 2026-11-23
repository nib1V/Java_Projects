package SorryBoardGame.Model.Square;

import SorryBoardGame.Model.Pawn;

public class StartSquare extends Square{

    /**
     * Constructor of {@code StartSquare} Class.<br>
     * <b>Pre-Condition:</b> The given Color is one of the available ones from
     * the {@code Resources} Class.<br>
     * <b>Post-Condition:</b> The Square created is a starting square.
     * @class StartSquare
     * @param Color
     */
    public StartSquare(int Color){
        super();
        setHasPawn(true);
        setColor(Color);
    }


    @Override
    public void setPawn(Pawn pawn) {}
}
