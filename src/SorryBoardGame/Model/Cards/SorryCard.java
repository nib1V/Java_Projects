package SorryBoardGame.Model.Cards;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Pawn;

public class SorryCard extends Card{
    private String card = "src/SorryBoardGame/Assets/cards/cardSorry.png";

    public String getCard() {return card;}
    @Override
    public void movePawn(Pawn p, Board b) {}
}
