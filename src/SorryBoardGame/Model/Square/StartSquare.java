package SorryBoardGame.Model.Square;

import SorryBoardGame.Model.Pawn;
import SorryBoardGame.Model.Player;

public class StartSquare extends Square{
    private Pawn[] pawns = new Pawn[2];
    private int capacity = 0;

    /**
     * Constructor of {@code StartSquare} Class.<br>
     * <b>Pre-Condition:</b> The given Color is one of the available ones from
     * the {@code Resources} Class.<br>
     * <b>Post-Condition:</b> The Square created is a starting square.
     * @class StartSquare
     * @param Color the color of the HomeSquare
     */
    public StartSquare(int Color, Player player){
        super();
        setColor(Color);
        pawns[0] = player.getPawn(0);
        pawns[1] = player.getPawn(1);
        setHasPawn(true);
    }

    /**
     * Transformer method of {@code StartSquare} Class.<br>
     * <b>Pre-Condition:</b> The StartSquare must not be empty
     * <b>Post-Condition:</b> Removes the pawn in the StartSquare or the first one
     * if there are two pawns in there.<br>
     * @class StartSquare
     */
    public Pawn removePawn(){
        Pawn p = getPawn();
        pawns[--capacity] = null;
        return p;
    }

    /**
     * Transformer method of {@code StartSquare} Class.<br>
     * <b>Post-Condition:</b> Sets the hasPawn field of Square based on the capacity of the
     * StartSquare.
     * @class StartSquare
     * @param val Here becomes unused since capacity does the same thing
     */
    @Override
    public void setHasPawn(boolean val){
        super.setHasPawn(capacity < 2);
    }

    /**
     * Accessor method of {@code StartSquare} Class.<br>
     * <b>Pre-Condition:</b> The StartSquare must not be empty
     * <b>Post-Condition:</b> Returns the pawn in the StartSquare or the first one
     * if there are two pawns in there.<br>
     * @class StartSquare
     */
    @Override
    public Pawn getPawn(){return pawns[capacity - 1];}

    /**
     * Transformer method of {@code StartSquare} Class.<br>
     * <b>Pre-Condition:</b> The capacity isn't zero.<br>
     * <b>Post-Condition:</b> Inserts a Pawn into the StartSquare.
     * @class StartSquare
     * @param pawn the pawn to be placed in the StartSquare
     */
    @Override
    public void setPawn(Pawn pawn) {this.pawns[capacity++] = pawn;}
}
