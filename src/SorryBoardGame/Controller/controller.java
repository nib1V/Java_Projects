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
        p1.getPawn(0).setCurrSquare(myBoard.getYellowStart());
        p1.getPawn(1).setCurrSquare(myBoard.getYellowStart());
        p2.getPawn(0).setCurrSquare(myBoard.getRedStart());
        p2.getPawn(1).setCurrSquare(myBoard.getRedStart());
        view game = new view();
    }

    public static void main(String[] args){
        controller Game = new controller();
    }
}
