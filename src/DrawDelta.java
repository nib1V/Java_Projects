import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.io.PrintWriter;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;

public class DrawDelta {

    public static void main(String[] args) {
        //Variables used to store the arguments given from the console
        String M = args[0];
        int L = Integer.parseInt(args[1]);
        if (L < 3 || L > 20)
        {
            System.out.println("Error: Out of Range!");
            System.exit(0);
        }
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
                drawDgraphics(L);
                break;
            default:
                System.out.println("Incorrect argument given!");
                System.exit(0);
        }
    }

    public static void DrawConsole(int size){
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
            int revspace = size - j;
            if (i >= 2)
            {
                j = 1;
                for (; j < revspace * 2; j++)
                    System.out.print(" ");
                System.out.println("*");
            }
        }
    }

    public static void DrawWindow(int size){
        String Triangle = "";
        Triangle = FillTriangle(size, Triangle);
        UIManager.put("OptionPane.messageFont", new Font("Monospaced", Font.BOLD, 24));
        JOptionPane.showMessageDialog(null,
                Triangle,
                "Παράθυρο Εξόδου",
                JOptionPane.INFORMATION_MESSAGE);

    }

    public static String FillTriangle(int size, String Array){
        int temp = size;
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

    public static void MakeDFile(int size){
        PrintWriter writer;
        try {
            writer = new PrintWriter("C:\\Users\\User\\Desktop\\D.html", "UTF-8");
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\"/>");
            writer.println("</head>");
            writer.println("<body><font size=" + size + ">Δ with font size = " + size + "</font></body>");
            writer.println("</html>");
            writer.close();
        } catch (Exception e) {
            System.out.println("Πρόβλημα: "+e);
        }

    }

    static void drawDgraphics(int size) {
        Frame f = new Frame("Drawing Delta") {
            public void paint (Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.draw(new Line2D.Double(50, 300, 200, 50));

            }
        };
        f.setSize(400,400);
        f.setVisible(true);
    }
}
