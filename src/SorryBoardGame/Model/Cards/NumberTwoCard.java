package SorryBoardGame.Model.Cards;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Pawn;

public class NumberTwoCard extends NumberCard{
    private String card = "src/SorryBoardGame/Assets/cards/card2.png";

    public String getCard() {return card;}
    @Override
    public void movePawn(Pawn p, Board b) {}
}
