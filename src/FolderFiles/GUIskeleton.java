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
        for (String s : images) {
            JButton btext = new JButton(s);
            btext.addActionListener(this);
            panel.add(btext);
            panel.add(new JLabel(new ImageIcon(s)));
        }
        JMenuBar menuBar = new JMenuBar();
        Button menu = new Button("Select a new Folder");
        menu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                FileStats.filesVisited = 0;
                FileStats.directoriesVisited = 0;
                FileStats.imagePathNames = new ArrayList<>();
                FileStats.main(null);
            }
        });
        menuBar.setLayout(new BorderLayout());
        menuBar.add(menu, BorderLayout.WEST);
        this.setJMenuBar(menuBar);
        this.getContentPane().add(panel);
        //ScrollBar still isn't working!
        this.getContentPane().add(pane, BorderLayout.EAST);
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
