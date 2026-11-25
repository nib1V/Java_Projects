package SorryBoardGame.Controller;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Cards.Card;
import SorryBoardGame.Model.Deck;
import SorryBoardGame.Model.Player;
import SorryBoardGame.View.view;
import static SorryBoardGame.Model.Resources.*;

public class controller {
    private int turn = 0;
    private Board myBoard;
    private Deck myDeck;
    private Player[] players = new Player[2];
    private view gameGUI;
    /**
     * Constructor of class {@code controller}.<br>
     * <b>Post-Condition:</b> Creates and initializes the game
     * @class controller
     */
    public controller(){
        myBoard = new Board();
        myDeck = new Deck();
        players[0] = new Player("Player1", YELLOW, myBoard);
        players[1] = new Player("Player2", RED, myBoard);
        gameGUI = new view(myBoard);
    }

    /**
     * Observer method of class {@code controller}.<br>
     * <b>Post-Condition:</b> Returns a boolean value depending on the state of the game.
     * @class controller
     */
    public boolean GameFinished(){}

    /**
     * Accessor method of {@code controller} class.<br>
     * <b>Post-Condition:</b> Returns the Current Player based on the turn.
     * @class controller
     */
    public Player getPlayer(){
        if (turn == 1){
            ChangeTurn();
            return players[1];
        }
        else {
            ChangeTurn();
            return players[0];
        }
    }

    /**
     * Accessor method of {@code controller} class.<br>
     * <b>Post-Condition:</b> Returns the Top Card of the Deck.
     * @class controller
     *
     */
    public Card getCard(){
            return myDeck.drawTop();
    }

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
