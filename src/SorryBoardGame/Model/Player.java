package SorryBoardGame.Model;

public class Player {
    private String name;
    private Pawn[] pawns = new Pawn[2];
    private boolean myTurn;
    private int color;

    /**
     * Constructor of {@code Player} Class.<br>
     * <b>Pre-Condition:</b> The given parameters are correct.<br>
     * <b>Post-Condition:</b> Creates a new Player.
     * @param name
     * @param color
     * @param board
     * @class Player
     */
    public Player(String name, int color, Board board) {
        pawns[0] = new Pawn(color, board.getStart(this)[0]);
        pawns[1] = new Pawn(color, board.getStart(this)[1]);
        this.name = name;
        this.color = color;
    }

    /**
     * Transformer Method of {@code Player} Class.<br>
     * <b>Pre-Condition:</b> The given color must be {@code YELLOW}(=1) or {@code RED}(=2).<br>
     * <b>Post-Condition:</b> Updates the color of the Player correctly.
     * @class Player
     * @param color
     */
    public void setColor(int color){this.color = color;}

    /**
     * Accessor Method of {@code Player} Class.<br>
     * <b>Post-Condition:</b> Returns the color of the {@code Player}.
     * @class Player
     */
    public int getColor(){return color;}

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