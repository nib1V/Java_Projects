package SorryBoardGame.Model;

import SorryBoardGame.Model.Square.Square;

public class Pawn {
    private boolean isActive;
    private int color;
    private Square currSquare;

    /**
     * Constructor of {@code Pawn} Class.<br>
     * <b>Pre-Condition:</b> The given square is a Starting Square.<br>
     * <b>Post-Condition:</b> Creates an instance of a pawn.
     * @param color
     * @param start
     * @class Pawn
     */
    public Pawn(int color, Square start){
        this.color = color;
        this.currSquare = start;
        this.isActive = false;
    }

    /**
     * Transformer Method of {@code Pawn} Class.<br>
     * <b>Pre-Condition:</b> The given square is a square the pawn can actually go to.<br>
     * <b>Post-Condition:</b> Changes the Current Square of the {@code Pawn}.
     * @class Pawn
     * @param square
     */
    public void setCurrSquare(Square square) {this.currSquare = square;}

    /**
     * Accessor Method of {@code Pawn} Class.<br>
     * <b>Post-Condition:</b> Returns the Current Square of the {@code Pawn}.
     * @class Pawn
     */
    public Square getCurrSquare() {return currSquare;}

    /**
     * Transformer Method of {@code Pawn} Class.<br>
     * <b>Pre-Condition:</b> The given color must be {@code YELLOW}(=1) or {@code RED}(=2).<br>
     * <b>Post-Condition:</b> Updates the color of the Pawn correctly.
     * @class Pawn
     * @param color
     */
    public void setColor(int color) {this.color = color;}

    /**
     * Accessor Method of {@code Pawn} Class.<br>
     * <b>Post-Condition:</b> Returns the color of the {@code Pawn}.
     * @class Pawn
     */
    public int getColor() {return color;}

    /**
     * Transformer Method of {@code Pawn} Class.<br>
     * <b>Pre-Condition:</b> The given status corresponds with the current state of the game.<br>
     * <b>Post-Condition:</b> Changes the status of the Pawn.
     * @class Pawn
     * @param status
     */
    public void setStatus(boolean status){this.isActive = status;}

    /**
     * Accessor Method of {@code Pawn} Class.<br>
     * <b>Post-Condition:</b> Returns the Current State of the {@code Pawn}.
     * @class Pawn
     */
    public boolean getStatus() {return isActive;}
}
