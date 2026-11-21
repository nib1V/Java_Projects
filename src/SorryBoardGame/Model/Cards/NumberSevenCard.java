package SorryBoardGame.Model.Cards;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Pawn;

public class NumberSevenCard extends NumberCard{
    private String card = "src/SorryBoardGame/Assets/cards/card7.png";

    public String getCard() {return card;}
    @Override
    public void movePawn(Pawn p, Board b) {}
}
