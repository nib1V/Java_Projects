package FolderFiles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

class GUIskeleton extends JFrame implements ActionListener {

    GUIskeleton(ArrayList<String> images) {
        setTitle("252-2026: A24");
        setBounds(200, 100, 800, 600);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(0, 4));
        JScrollPane pane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar bar = pane.getVerticalScrollBar();
        for (String s : images) {
            JButton btext = new JButton(s);
            btext.addActionListener(this);
            panel.add(btext);
            panel.add(new JLabel(new ImageIcon(s)));
        }
        JMenuBar menuBar = new JMenuBar();
        JMenuItem menu = new JMenuItem("Select a new Folder");
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        this.getContentPane().add(panel);
        this.getContentPane().add(bar, BorderLayout.EAST);
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
