import javax.swing.JOptionPane;

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

                break;
            case "g":

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
                Array += "*";
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
                Array += "*";
            }
        }
        System.out.print(Array);
        System.exit(0);
        return Array;
    }
}
