package SorryBoardGame.Controller;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Cards.Card;
import SorryBoardGame.Model.Deck;
import SorryBoardGame.Model.Player;
import SorryBoardGame.View.PlayBoard;

import static SorryBoardGame.Model.Resources.*;

public class controller {
    private int turn = 0;
    private Board myBoard;
    private Deck myDeck;
    private Player[] players = new Player[2];
    private PlayBoard gameGUI;
    private Card currCard;
    /**
     * Constructor of class {@code controller}.<br>
     * <b>Post-Condition:</b> Creates and initializes the game
     * @class controller
     */
    public controller(){
        myDeck = new Deck();
        players[0] = new Player("Player1", YELLOW, myBoard);
        players[1] = new Player("Player2", RED, myBoard);
        myBoard = new Board(players[0], players[1]);
        gameGUI = new PlayBoard(this);
    }

    /**
     * Observer method of class {@code controller}.<br>
     * <b>Post-Condition:</b> Returns a boolean value depending on the state of the game.
     * @class controller
     */
//    public boolean hasGameFinished(){}

    /**
     * Transformer method of {@code controller} Class.<br>
     * <b>Pre-Condition:</b> Must be called only after the game has ended.<br>
     * <b>Post-Condition:</b> Terminates the Program.
     * @class controller
     */
    public void gameEnd(){System.exit(0);}

    /**
     * Accessor method of {@code controller} class.<br>
     * <b>Post-Condition:</b> Returns the Current Player based on the turn.
     * @class controller
     */
    public Player getPlayer(){
        if (turn == 1)
            return players[1];
        return players[0];
    }

    /**
     * Accessor method of {@code controller} Class.<br>
     * <b>Pre-Condition:</b> A card must have been drawn by the Player using the
     * {@code getCard} method and updating the GUI of the top of the deck.<br>
     * <b>Post-Condition:</b> Updates the GUI Appropriately in order to
     * let the user know what his legal moves are based on the Card he drew.
     * @class controller
     */
    public void getMoves(){}

    /**
     * Observer method of {@code controller} Class.<br>
     * <b>Pre-Condition:</b> Must run {@code getMoves} method in order to get all the available moves.<br>
     * <b>Post-Condition:</b> Returns a boolean value that corresponds if the player can
     * fold or not.
     */
    //public boolean hasPlayerFold(){}

    /**
     * Transformer method of {@code controller} Class.<br>
     * <b>Pre-Condition:</b> The Player must first get the available moves and then make a
     * choice and according to that.<br>
     * <b>Post-Condition:</b> Changes the GUI along with the position of the Pawn(s) of the
     * Player Playing according to the card drawn using {@code setCard} method.
     * @class controller
     */
    public void makeMove(){}

    /**
     * Accessor method of {@code controller} class.<br>
     * <b>Post-Condition:</b> Returns the Top Card of the Deck.
     * @class controller
     */
    public void setCard(){
        currCard = myDeck.drawTop();
    }

    /**
     * Accessor method of {@code controller} class.<br>
     * <b>Post-Condition:</b> Returns the Board of the Game.
     * @class controller
     */
    public Board getBoard(){return myBoard;}

    /**
     * Accessor method of {@code controller} Class.<br>
     * <b>Pre-Condition:</b> The currCard field must have been initialized by
     * drawing a card from the top of the deck using setCard.<br>
     * <b>Post-Condition:</b> Returns the current Drawn Card.
     * @class controller
     */
    public Card getCurrentCard(){return currCard;}

    /**
     * Accessor method of {@code controller} Class.
     * <b>Post-Condition:</b> Returns the turn.
     * @class controller
     */
    public int getTurn() {return turn;}

    /**
     * Transformer method of class {@code controller}.<br>
     * <b>Post-Condition:</b> Changes the turn of the player
     * when {@code Fold} gets pressed or when a player has no more moves to do.
     * @class controller
     */
    public void ChangeTurn(){
        if (turn == 0) turn = 1;
        else turn = 1;
    }
    //You will need an action listener in order to listen to the fold button getting
    //pressed and then use ChangeTurn

    public static void main(String[] args){
        controller Game = new controller();
    }
}
