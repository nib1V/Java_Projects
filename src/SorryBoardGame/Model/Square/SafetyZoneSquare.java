package SorryBoardGame.Model.Square;

import SorryBoardGame.Model.Pawn;

public class SafetyZoneSquare extends Square{

    public SafetyZoneSquare(int Color){
        super();
        setColor(Color);
    }

    @Override
    public void setPawn(Pawn pawn) {}
}
