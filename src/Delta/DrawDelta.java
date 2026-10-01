package Delta;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawDelta {

    public static void main(String[] args) {
        //Variables used to store the arguments given from the console
        String M = args[0];
        boolean flag = true;
        boolean con = true;
        int L = Integer.parseInt(args[1]);
        if (L < 3 || L > 20)
        {
            System.out.println("Error: Out of Range!");
            System.exit(0);
        }
        //Opening System.in to take the input from the console later on
        //This is done here since the input is going to be used during the while loop
        Scanner input = new Scanner(System.in);
        while(con)
        {
            switch(M){
                case "c":
                    DrawConsole(L);
                    break;
                case "w":
                    DrawWindow(L);
                    break;
                case "f":
                    MakeDFile(L);
                    break;
                case "g":
                    con = false;        //Calling outside because otherwise, if inside loop it infinitely loads new windows and causes crash to happen
                    continue;
                default:
                    System.out.println("Incorrect argument given!");
                    System.exit(0);
            }
            args[1] = "" + (L-1);       //Updating L in order to call main recursively or ask for a new L
            if (L - 1  < 3)
            {
                flag = false;
            }

            if (flag)
                main(args);             //Calling Main

            if(M.equals("c") || M.equals("f"))          //If the Mode is for the console or a file
            {                                                              //Initiate the process of taking a new value for L
                try {
                    System.out.print("Give a new value for L: ");
                    L = input.nextInt();
                    if (L < 3 || L > 20)                                   //Range checking
                    {
                        System.out.println("Error: Out of Range!");
                        System.exit(0);
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Error: Wrong Input!");
                    System.exit(0);
                }
            }
            else                                                           //if the Mode is for the window
            {                                                              //Give a dialog box to the user instead of the console output
                L = Integer.parseInt(JOptionPane.showInputDialog(
                    "Give me a number ",3));
                if (L < 3 || L > 20)                                            //Range Checking with Error Popup if out of range
                {
                    JOptionPane.showMessageDialog(null,
                            "Error: Out of Range",
                            "Error Message",
                            JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }
        }
        input.close();                                                     //Closing the input in order to prevent data leaks
        drawDgraphics(L);                                                  //Calling drawDgraphics if the Mode is for the graphical environment
    }

    public static void DrawConsole(int size){                               //Method that Draws the Letter Delta in the console
        int temp = size;
        for(int i = 1; i <= size; i++)
        {
            if (i == size)                  //The Base
            {
                for(int k = 1; k <= size * 2 - 1; k++)
                    System.out.print("*");
                System.out.print("\n");
                break;
            }

            int j = 1;
            for(; j <= temp - 1; j++)
            {
                System.out.print(" ");
            }
            temp--;
            if (i == 1)
            {
                System.out.println("*");
                continue;
            }
            else
            {
                System.out.print("*");
            }
            int revspace = size - j;                                    //Used to calculate the space needed to reach the other star (ReverseSpace)
            if (i >= 2)
            {
                j = 1;
                for (; j < revspace * 2; j++)
                    System.out.print(" ");
                System.out.println("*");
            }
        }
    }

    public static void DrawWindow(int size){                            //Method that Draws a Window with the Letter Delta
        String Triangle = "";
        Triangle = FillTriangle(size, Triangle);
        UIManager.put("OptionPane.messageFont", new Font("Monospaced", Font.BOLD, 24));         //Changed the font to make the output look more like a delta
        JOptionPane.showMessageDialog(null,
                Triangle,
                "Output Window",
                JOptionPane.INFORMATION_MESSAGE);
        
    }

    public static String FillTriangle(int size, String Array){          //Method used to Fill a string with the correct characters so that the output
        int temp = size;                                                //Used by the DrawWindow method is going to be displayed as the content of the window
        for(int i = 1; i <= size; i++)
        {
            if (i == size)                  //The Base
            {
                for(int k = 1; k <= size * 2 - 1; k++)
                    Array += "*";
                Array += "\n";
                break;
            }

            int j = 1;
            for(; j <= temp - 1; j++)
            {
                Array += " ";
            }
            temp--;
            if (i == 1)
            {
                Array += "*\n";
                continue;
            }
            else
            {
                Array += "*";
            }
            int revspace = size - j;
            if (i >= 2)
            {
                j = 1;
                for (; j < revspace * 2; j++)
                    Array += " ";
                Array += "*\n";
            }
        }
        return Array;
    }

    public static void MakeDFile(int size){                           //Method that makes an HTML file containing the Greek Letter Delta in UTF-8 encoding
        PrintWriter writer;
        try {
            writer = new PrintWriter("C:\\Users\\User\\D.html", "UTF-8");
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\"/>");
            writer.println("</head>");
            writer.println("<body><font size=" + size + ">Δ with font size = " + size + "</font></body>");
            writer.println("</html>");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: "+e);
            System.exit(0);
        }

    }

    static void drawDgraphics(int size) {                           //Method that makes a Frame and Draws 3 Lines on it in order to display a Delta
        int base = (size*2 - 1)/2;
        Frame f = new Frame("Drawing Delta") {
            public void paint (Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.draw(new Line2D.Double(320 - base*10, 210 + size*5, 320 + base*10, 210 + size*5));
                g2.draw(new Line2D.Double(320 - base*10, 210 + size*5, 320, 210 - size*5));
                g2.draw(new Line2D.Double(320, 210 - size*5, 320 + base*10, 210 + size*5));
            }
        };

        f.addWindowListener(new WindowAdapter() {                   //The windowlistener here is used in order to be able to close the frame
            public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
        });

        f.setSize(640,420);
        f.setVisible(true);
    }
}
