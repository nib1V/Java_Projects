package SorryBoardGame.Model.Square;

import java.awt.*;

public abstract class Square {
    private boolean hasPawn;
    private Color colour;

    public Square(){
        colour = Color.WHITE;
        hasPawn = false;
    }

    public boolean hasPawn(){return hasPawn;}
}
