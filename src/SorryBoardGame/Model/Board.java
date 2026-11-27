package SorryBoardGame.Model;

import SorryBoardGame.Model.Square.*;
import SorryBoardGame.View.PlayBoard;

import static SorryBoardGame.Model.Resources.*;

public class Board {
    public static final int BOARD_WIDTH = 16;
    public static final int BOARD_HEIGHT = 16;
    private final StartSquare yellowStart;
    private final StartSquare redStart;
    private final SafetyZoneSquare[] yellowSafetyZoneSquares = new SafetyZoneSquare[5];
    private final SafetyZoneSquare[] redSafetyZoneSquares = new SafetyZoneSquare[5];
    private final HomeSquare yellowHomeSquare;
    private final HomeSquare redHomeSquare;

    private final Square[][] squares = new Square[16][16];

    /**
     * Constructor of {@code Board} Class.<br>
     * <b>Post-Condition:</b> Creates the Board with all the needed squares.
     * @class Board
     */
    public Board(Player p1, Player p2){
        //Initializing Starting Squares for the two players
        yellowStart = new StartSquare(YELLOW, p1);
        redStart = new StartSquare(RED, p2);

        //Initializing the safety zones of the two players
        yellowHomeSquare = new HomeSquare(YELLOW);
        redHomeSquare = new HomeSquare(RED);
        for (int i = 0; i < 5; i++) {
            yellowSafetyZoneSquares[i] = new SafetyZoneSquare(YELLOW);
            redSafetyZoneSquares[i] = new SafetyZoneSquare(RED);
        }

        InitializeSliders();
    }

    void InitializeSliders(){
        //Initializing the border of the board with all simple squares
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                squares[i][j] = new SimpleSquare();
            }
        }

        //Adding the Slider Squares that are needed
        squares[0][1] = new StartSlideSquare(RED);
        squares[0][2] = new InternalSlideSquare(RED);
        squares[0][3] = new InternalSlideSquare(RED);
        squares[0][4] = new EndSlideSquare(RED);

        squares[0][9] = new StartSlideSquare(RED);
        squares[0][10] = new InternalSlideSquare(RED);
        squares[0][11] = new InternalSlideSquare(RED);
        squares[0][12] = new InternalSlideSquare(RED);
        squares[0][13] = new EndSlideSquare(RED);

        squares[2][0] = new StartSlideSquare(GREEN);
        squares[3][0] = new InternalSlideSquare(GREEN);
        squares[4][0] = new InternalSlideSquare(GREEN);
        squares[5][0] = new InternalSlideSquare(GREEN);
        squares[6][0] = new EndSlideSquare(GREEN);

        squares[11][0] = new StartSlideSquare(GREEN);
        squares[12][0] = new InternalSlideSquare(GREEN);
        squares[13][0] = new InternalSlideSquare(GREEN);
        squares[14][0] = new EndSlideSquare(GREEN);

        squares[15][2] = new StartSlideSquare(YELLOW);
        squares[15][3] = new InternalSlideSquare(YELLOW);
        squares[15][4] = new InternalSlideSquare(YELLOW);
        squares[15][5] = new InternalSlideSquare(YELLOW);
        squares[15][6] = new EndSlideSquare(YELLOW);

        squares[15][11] = new StartSlideSquare(YELLOW);
        squares[15][12] = new InternalSlideSquare(YELLOW);
        squares[15][13] = new InternalSlideSquare(YELLOW);
        squares[15][14] = new EndSlideSquare(YELLOW);

        squares[1][15] = new StartSlideSquare(BLUE);
        squares[2][15] = new InternalSlideSquare(BLUE);
        squares[3][15] = new InternalSlideSquare(BLUE);
        squares[4][15] = new EndSlideSquare(BLUE);

        squares[9][15] = new StartSlideSquare(BLUE);
        squares[10][15] = new InternalSlideSquare(BLUE);
        squares[11][15] = new InternalSlideSquare(BLUE);
        squares[12][15] = new InternalSlideSquare(BLUE);
        squares[13][15] = new EndSlideSquare(BLUE);
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
