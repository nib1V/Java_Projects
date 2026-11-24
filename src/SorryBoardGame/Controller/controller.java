package SorryBoardGame.Controller;

import SorryBoardGame.Model.Board;
import SorryBoardGame.Model.Deck;
import SorryBoardGame.Model.Player;
import SorryBoardGame.View.view;

import static SorryBoardGame.Model.Resources.*;

public class controller {
    
    public controller(){
        Board myBoard = new Board();
        Deck myDeck = new Deck();
        Player p1 = new Player("Player1", YELLOW, myBoard);
        Player p2 = new Player("Player2", RED, myBoard);

        view game = new view();
    }

    public static void main(String[] args){
        controller Game = new controller();
    }
}
