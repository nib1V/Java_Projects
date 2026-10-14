package Palindromes;

import java.text.Normalizer;
import java.util.Scanner;

public class PalindromikesFraseis {

    public static void main(String[] args) {
        System.out.print("Give me a String: ");
        //Taking Input from the User
        Scanner in = new Scanner(System.in);
        String nextLine = in.nextLine();
        //Starting counter
        long time1 = System.nanoTime();
        //Calling method isPalindromikiFrash to find out if nextLine is a palindrome
        boolean answer = isPalindromikiFrash(nextLine);
        //Stopping counter and calculating total time
        long time2 = System.nanoTime();
        long totaltime = (time2 - time1);

        if (answer)
        {
            System.out.println("The String you gave was a Palindrome!\n" +
                    "This comparison took: " + (double)totaltime/1000000000 + " seconds.");
        }
        else
        {
            System.out.println("The String you gave was not a Palindrome!\n" +
                    "This comparison took: " + (double)totaltime/1000000000 + " seconds.");
        }
        //Closing the input in order to prevent data leaks
        in.close();
    }

    public static boolean isPalindromikiFrash(String s) {
        s = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+","");
        s = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{Punct}", "");
        s = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\s+", "");
        s = s.toLowerCase();

        //Copying in Reverse Order
        String RevArray = new StringBuffer(s).reverse().toString();

        return s.equals(RevArray);
    }
}
