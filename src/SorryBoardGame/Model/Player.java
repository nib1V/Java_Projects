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

    /**
     * Accessor Method of {@code Player} Class.<br>
     * <b>Post-Condition:</b> Returns the name of the {@code Player}.
     * @class Player
     */
    public String getName(){return name;}

    /**
     * Transformer Method of {@code Player} Class.<br>
     * <b>Pre-Condition:</b> The given name is correct.<br>
     * <b>Post-Condition:</b> Updates the name of the Player correctly.
     * @class Player
     * @param name
     */
    public void setName(String name){this.name = name;}

    /**
     * Accessor method of {@code Player} Class.<br>
     * <b>Pre-Condition:</b> The given parameter {@code number} must be 0 or 1,
     * otherwise {@code IndexOutOfBoundsException} is thrown.<br>
     * <b>Post-Condition:</b> Must return one of the two Pawns of the {@code Player}.
     * @class Player
     * @param number
     * @throws IndexOutOfBoundsException
     */
    public Pawn getPawn(int number) throws IndexOutOfBoundsException {return pawns[number];}

    /**
     * Observer method of {@code Player} class.<br>
     * <b>Post-Condition:</b> Returns {@code true} or {@code false} if it is the
     * player's turn.
     * @class Player
     */
    public boolean getTurn(){return myTurn;}

    /**
     * Transformer method of {@code Player} Class.<br>
     * <b>Pre-Condition:</b> The given boolean value must be correct so that
     * both players of the game never have the same {@code myTurn} value.<br>
     * <b>Post-Condition:</b> The value of {@code myTurn} is changed.
     * @class Player
     * @param value
     */
    public void setTurn(boolean value){myTurn = value;}
}