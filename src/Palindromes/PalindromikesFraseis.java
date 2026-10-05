package Palindromes;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Scanner;
import java.util.Vector;
import org.jfugue.Player;

public class PalindromikesFraseis {
    public static void main(String[] args)
    {
        //Testing Notes
        Player p = new Player();
        p.play("F");
        System.exit(0);

        //To test the method
        PalindromikesLexikou();
        System.exit(0);

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

    static boolean isPalindromikiFrash(String s)        //Method that takes a String and determines if it is a palindrome
    {
        s = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+","");
        s = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{Punct}", "");
        s = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\s+", "");
        s = s.toLowerCase();

        //Copying in Reverse Order
        String RevArray = new StringBuffer(s).reverse().toString();

        return s.equals(RevArray);
    }

    static void PalindromikesLexikou()
    {
        try {
            long start = System.nanoTime();
            FileInputStream finput = new FileInputStream("C:/Users/User/Desktop/Java_Projects/src/Palindromes/Resources/gr.dic");
            Scanner reader = new Scanner(finput);

            Vector<String> arr = new Vector<>();
            int count1 = 0, count2 = 0, sum = 0;
            while(reader.hasNextLine())
            {
                //Finding average word size
                String word = reader.nextLine();
                sum += word.length();

                //Finding the amount of palindromes in gr.dic
                boolean answer = isPalindromikiFrash(word);
                if (answer)
                {
                    count2++;
                    arr.add(word);
                }
                //Finding the total amount of words in gr.dic
                count1++;
            }
            sum /= count1;
            System.out.println("There is a total of: " + count1 + " words in gr.dic");
            System.out.println("The average size of a word in gr.dic is: " + sum);
            System.out.println("There are: " + count2 + " Palindromes");
            System.out.println("These are:");

            for (String cur : arr)
                System.out.println(" - " + cur);

            float percent = (float) count2/count1;
            System.out.println("That represents " + percent*100 + "% of the words in gr.dic");
            System.out.println();

            System.out.println("The Palindromes in reverse order:");
            for (int i = arr.size() - 1; i >= 0; i--)
                System.out.print(arr.get(i) + " ");
            System.out.println();

            long end = System.nanoTime();
            long time = end - start;
            System.out.println();
            System.out.println("This operation took: " + (double)time/1000000000 + " seconds.");

            reader.close();
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
