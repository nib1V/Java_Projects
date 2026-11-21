package SorryBoardGame.Model.Cards;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Pawn;

public abstract class Card {
    private String backcard = "src/SorryBoardGame/Assets/cards/backCard.png";

    public abstract void movePawn(Pawn p, Board b);

    public String getBackcard() {return backcard;}
}
