package SorryBoardGame.View;

import SorryBoardGame.Model.Board;

import javax.swing.*;
import java.awt.*;

public class view extends JFrame {

    public view(Board board){
        setTitle("Sorry! Board Game");
        setBounds(200, 100, 800, 600);
        setLayout(new BorderLayout());
        setIconImage(new ImageIcon("src/SorryBoardGame/Assets/sorryImage.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //Make a BorderLayout for a JPanel and only fill the East and Center
        //Also make the background the green backdrop.
        //For the center create another JPanel that also has a BorderLayout
        //With all the coordinates (East, West, North, South) for the Border around the
        //Game area and fill the inside with the Sorry icon
    }
}
