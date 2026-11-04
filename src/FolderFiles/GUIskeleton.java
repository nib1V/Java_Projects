package FolderFiles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

class GUIskeleton extends JFrame implements ActionListener {

    GUIskeleton(ArrayList<String> images) {
        setTitle("252-2026: A24");
        setBounds(200, 100, 800, 600); // x, y, width, height
        setLayout(new GridLayout(0, 4)); // rows, columns
        for (String s : images) {
            JButton btext = new JButton(s);
            btext.addActionListener(this);
            add(btext);
            add(new JLabel(new ImageIcon(s)));
        }
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object so = e.getSource();
        if (so instanceof JButton) {
            JButton sj = (JButton) so;
            String sjt = sj.getText();
            Desktop dt = Desktop.getDesktop();
            try{
                dt.open(new File(sjt));
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
