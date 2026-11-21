package SorryBoardGame.Model;

import SorryBoardGame.Model.Square.StartSquare;

import static SorryBoardGame.Model.Resources.*;

public class Board {
    private final StartSquare[] yellowStart = new StartSquare[2];
    private final StartSquare[] redStart = new StartSquare[2];

    public Board(){

    }

    /**
     * Accessor method of {@code Board} Class.<br>
     * <b>Post-Condition:</b> Return the Yellow Player's Starting Square.
     * @class Board
     */
    public StartSquare[] getYellowStart() {return yellowStart;}

    /**
     * Accessor method of {@code Board} Class.<br>
     * <b>Post-Condition:</b> Return the Red Player's Starting Square.
     * @class Board
     */
    public StartSquare[] getRedStart(){return redStart;}

    /**
     * Accessor method of {@code Board} Class.<br>
     * <b>Pre-Condition:</b> The given Player's Color is only {@code YELLOW}(=1) or {@code RED}(=2).<br>
     * <b>Post-Condition:</b> Returns the Starting Square of the yellow or red Player.<br>
     * @class Board
     * @param player
     */
    public StartSquare[] getStart(Player player){
        if (player.getColor() == YELLOW) return getYellowStart();
        else return getRedStart();
    }
}
