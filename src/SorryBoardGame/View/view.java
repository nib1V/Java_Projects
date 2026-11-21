package SorryBoardGame.View;

import javax.swing.*;
import java.awt.*;

public class view extends JFrame {

    public view(){
        setTitle("Sorry! Board Game");
        setBounds(200, 100, 800, 600);
        setLayout(new BorderLayout());
        setIconImage(new ImageIcon("src/SorryBoardGame/Assets/sorryImage.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
