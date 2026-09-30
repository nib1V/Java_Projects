import java.util.Scanner;

public class PalindromikesFraseis {
    public static void main(String[] args)
    {
        long time = System.nanoTime();
        System.out.print("Give me a String: ");

        Scanner in = new Scanner(System.in);
        String nextLine = in.nextLine();

        boolean answer = isPalindromikiFrash(nextLine);    
        if (answer)
        {
            System.out.println("The String you gave was a Palindrome!\n" +
                                "This comparison took: " + time/1000000000 + " seconds.");
        }
        else
        {
            System.out.println("The String you gave was not a Palindrome!\n" +
                                "This comparison took: " + time/1000000000 + " seconds.");
        }
        in.close();
    }

    static boolean isPalindromikiFrash(String s)
    {
        //int length = s.length();
        //char[] PalArray;
        //for(int i = 0; i < length; i++)
        //{   
        //    PalArray[i] = s.charAt(i);
        //}
        return true;//false/true
    }

}
