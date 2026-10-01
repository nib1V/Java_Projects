package Palindromes;

import java.util.Scanner;

public class PalindromikesFraseis {
    public static void main(String[] args)
    {
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
        long totaltime = (time2 - time1)/1000000000;

        if (answer)
        {
            System.out.println("The String you gave was a Palindrome!\n" +
                                "This comparison took: " + totaltime + " seconds.");
        }
        else
        {
            System.out.println("The String you gave was not a Palindrome!\n" +
                                "This comparison took: " + totaltime + " seconds.");
        }
        //Closing the input in order to prevent data leaks 
        in.close();
    }

    static boolean isPalindromikiFrash(String s)        //Method that takes a String and determines if it is a palindrome
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
