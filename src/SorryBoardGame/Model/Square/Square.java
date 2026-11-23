package SorryBoardGame.Model.Square;

import static SorryBoardGame.Model.Resources.WHITE;

public abstract class Square {
    private boolean hasPawn;
    private int color;

    /**
     * Constructor of {@code Square} Class.<br>
     * <b>Post-Condition:</b> Initializes a default square.
     * @class Square
     */
    public Square(){
        this.color = WHITE;
        hasPawn = false;
    }

    /**
     * Transformer method of {@code Square} Class.<br>
     * <b>Pre-Condition:</b> The given color is one of the available ones
     * from the {@code Resources} Class.<br>
     * <b>Post-Condition:</b> Changes the color of the Square.
     * @class Square
     * @param color
     */
    public void setColor(int color) {this.color = color;}

    /**
     * Observer method of {@code Square} Class.<br>
     * <b>Post-Condition:</b> Returns the color of the square.
     * @class Square
     */
    public int getColor() {return color;}

    /**
     * Transformer method of {@code Square} Class.
     * <b>Pre-Condition:</b> The given boolean value aligns with the state of
     * the game and the square actually has a {@code Pawn} in it.<br>
     * <b>Post-Condition:</b> The {@code hasPawn} data member of Square gets updated.
     * @class Square
     * @param val
     */
    public void setHasPawn(boolean val){hasPawn = val;}

    /**
     * Observer method of {@code Square} Class.<br>
     * <b>Post-Condition:</b> Returns the value of {@code hasPawn}.
     * @class Square
     */
    public boolean hasPawn(){return hasPawn;}
}
