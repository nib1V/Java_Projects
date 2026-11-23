package SorryBoardGame.Model;

import SorryBoardGame.Model.Square.Square;
import SorryBoardGame.Model.Square.StartSquare;

import static SorryBoardGame.Model.Resources.*;

public class Board {
    private final StartSquare yellowStart;
    private final StartSquare redStart;
//    private final Square[] fourLengthSlides = new Square[8];

    /**
     * Constructor of {@code Board} Class.<br>
     * <b>Post-Condition:</b> Creates the Board with all the needed squares.
     * @class Board
     */
    public Board(){
        yellowStart = new StartSquare(YELLOW);
        redStart = new StartSquare(RED);
        //Add more about slide Squares and find a way to implement the 8 slides
    }

    /**
     * Accessor method of {@code Board} Class.<br>
     * <b>Post-Condition:</b> Return the Yellow Player's Starting Square.
     * @class Board
     */
    public StartSquare getYellowStart() {return yellowStart;}

    /**
     * Accessor method of {@code Board} Class.<br>
     * <b>Post-Condition:</b> Return the Red Player's Starting Square.
     * @class Board
     */
    public StartSquare getRedStart(){return redStart;}

    /**
     * Accessor method of {@code Board} Class.<br>
     * <b>Pre-Condition:</b> The given Player's Color is only {@code YELLOW}(=1) or {@code RED}(=2).<br>
     * <b>Post-Condition:</b> Returns the Starting Square of the yellow or red Player.<br>
     * @class Board
     * @param player
     */
    public StartSquare getStart(Player player){
        if (player.getColor() == YELLOW) return getYellowStart();
        else return getRedStart();
    }
}
