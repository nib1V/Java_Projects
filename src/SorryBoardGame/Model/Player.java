package SorryBoardGame.Model;

import java.awt.*;

public class Player {
    private String name;
    private Pawn[] pawns = new Pawn[2];
    private boolean myTurn;
    private Color colour;

    public Player(String name, Color colour) {
        this.name = name;
        this.colour = colour;
    }

    public String getName(){return name;}

    public boolean getTurn(){return myTurn;}
    private void setTurn(boolean val){myTurn = val;}
}
