package SorryBoardGame.Model.Square;

import SorryBoardGame.Model.Pawn;

public class HomeSquare extends Square{

    public HomeSquare(int Color){
        super();
        setColor(Color);
    }

    @Override
    public void setPawn(Pawn pawn) {}
}
