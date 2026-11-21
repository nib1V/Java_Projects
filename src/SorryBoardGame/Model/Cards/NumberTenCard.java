package SorryBoardGame.Model.Cards;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Pawn;

public class NumberTenCard extends NumberCard{
    private String card = "src/SorryBoardGame/Assets/cards/card10.png";

    public String getCard() {return card;}
    @Override
    public void movePawn(Pawn p, Board b) {}
}
