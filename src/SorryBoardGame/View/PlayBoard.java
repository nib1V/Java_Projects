package SorryBoardGame.View;

import SorryBoardGame.Controller.controller;
import SorryBoardGame.Model.Board;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayBoard extends JFrame implements ActionListener {
    private controller controller;

    /**
     * Constructor of {@code PlayBoard} Class.<br>
     * <b>Pre-Condition:</b> The given controller is initialized as the game should be.<br>
     * <b>Post-Condition:</b> Initializes the PlayBoard of the game
     * @class PlayBoard
     * @param controller the controller of the game.
     */
    public PlayBoard(controller controller){
        this.controller = controller;
    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
