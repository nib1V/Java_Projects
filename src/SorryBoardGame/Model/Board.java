package SorryBoardGame.Model;

import SorryBoardGame.Model.Square.HomeSquare;
import SorryBoardGame.Model.Square.SafetyZoneSquare;
import SorryBoardGame.Model.Square.Square;
import SorryBoardGame.Model.Square.StartSquare;

import static SorryBoardGame.Model.Resources.*;

public class Board {
    private final StartSquare yellowStart;
    private final StartSquare redStart;
    private final SafetyZoneSquare[] yellowSafetyZoneSquares = new SafetyZoneSquare[5];
    private final SafetyZoneSquare[] redSafetyZoneSquares = new SafetyZoneSquare[5];
    private final HomeSquare yellowHomeSquare;
    private final HomeSquare redHomeSquare;

    /**
     * Constructor of {@code Board} Class.<br>
     * <b>Post-Condition:</b> Creates the Board with all the needed squares.
     * @class Board
     */
    public Board(){
        //Initializing Starting Squares for the two players
        yellowStart = new StartSquare(YELLOW);
        redStart = new StartSquare(RED);
        //Initializing the safety zones of the two players
        yellowHomeSquare = new HomeSquare(YELLOW);
        redHomeSquare = new HomeSquare(RED);
        for (int i = 0; i < 5; i++) {
            yellowSafetyZoneSquares[i] = new SafetyZoneSquare(YELLOW);
            redSafetyZoneSquares[i] = new SafetyZoneSquare(RED);
        }
        //Make an Array that's 16x16 of Squares and fill it with Simple Squares
        //And Slider Squares wherever it's needed
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
     * <b>Post-Conditions:</b> Returns the Home Square of the Yellow Player.
     * @class Board
     */
    public HomeSquare getYellowHomeSquare() {return yellowHomeSquare;}

    /**
     * Accessor method of {@code Board} Class.<br>
     * <b>Post-Conditions:</b> Returns the Home Square of the Red Player.
     * @class Board
     */
    public HomeSquare getRedHomeSquare() {return redHomeSquare;}

    /**
     * Accessor method of {@code Board} Class.<br>
     * <b>Post-Conditions:</b> Returns an array of the safety zone squares of the Yellow Player.
     * @class Board
     */
    public SafetyZoneSquare[] getYellowSafetyZoneSquares() {return yellowSafetyZoneSquares;}

    /**
     * Accessor method of {@code Board} Class.<br>
     * <b>Post-Conditions:</b> Returns an array of the safety zone squares of the Red Player.
     * @class Board
     */
    public SafetyZoneSquare[] getRedSafetyZoneSquares() {return redSafetyZoneSquares;}

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
