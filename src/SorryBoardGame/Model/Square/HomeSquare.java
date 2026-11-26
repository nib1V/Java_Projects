package SorryBoardGame.Model.Square;

import SorryBoardGame.Model.Pawn;

public class HomeSquare extends Square{
    private Pawn[] pawns = new Pawn[2];
    private int capacity = 2;

    /**
     *  Constructor of {@code HomeSquare} Class.<br>
     *  <b>Pre-Condition:</b> The given color must be either red or yellow.<br>
     *  <b>Post-Condition:</b> Initializes the HomeSquare.
     * @class HomeSquare
     * @param Color the color of the HomeSquare
     */
    public HomeSquare(int Color){
        super();
        setColor(Color);
    }

    /**
     * Transformer method of {@code HomeSquare} Class.<br>
     * <b>Post-Condition:</b> Sets the hasPawn field of Square based on the capacity of the
     * HomeSquare.
     * @class HomeSquare
     * @param val Here becomes unused since capacity does the same thing
     */
    @Override
    public void setHasPawn(boolean val){
        super.setHasPawn(capacity < 2);
    }

    /**
     * Accessor method of {@code HomeSquare} Class.<br>
     * <b>Pre-Condition:</b> The HomeSquare must not be empty
     * <b>Post-Condition:</b> Returns the pawn in the HomeSquare or the first one
     * if there are two pawns in there.<br>
     * @class HomeSquare
     */
    @Override
    public Pawn getPawn(){return pawns[capacity - 1];}

    /**
     * Transformer method of {@code HomeSquare} Class.<br>
     * <b>Pre-Condition:</b> The capacity isn't zero.<br>
     * <b>Post-Condition:</b> Inserts a Pawn into the HomeSquare.
     * @class HomeSquare
     * @param pawn the pawn to be placed in the HomeSquare
     */
    @Override
    public void setPawn(Pawn pawn) {this.pawns[--capacity] = pawn;}
}
