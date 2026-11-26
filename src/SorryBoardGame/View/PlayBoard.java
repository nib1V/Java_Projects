package SorryBoardGame.View;

import SorryBoardGame.Controller.controller;
import SorryBoardGame.Model.Board;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayBoard extends JFrame implements ActionListener {
    private controller controller;

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
