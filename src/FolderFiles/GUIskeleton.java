package FolderFiles;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        }
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object so = e.getSource();
        if (so instanceof JButton) {
            JButton sj = (JButton) so;
            String sjt = sj.getText();
            System.out.println(sjt);
        }
    }
}
