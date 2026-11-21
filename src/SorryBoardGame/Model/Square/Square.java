package SorryBoardGame.Model.Square;

import static SorryBoardGame.Model.Resources.WHITE;

public abstract class Square {
    private boolean hasPawn;
    private int color;

    public Square(){
        this.color = WHITE;
        hasPawn = false;
    }

    public boolean hasPawn(){return hasPawn;}
}
