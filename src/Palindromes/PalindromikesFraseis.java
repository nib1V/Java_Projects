package Palindromes;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Scanner;
import java.util.Vector;
import org.jfugue.Player;
import org.jfugue.Tempo;

public class PalindromikesFraseis {
    public static void main(String[] args)
    {
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
        try
        {
            long start = System.nanoTime();
            FileInputStream finput = new FileInputStream("C:/Users/XamZer0/Desktop/Java_Projects/src/Palindromes/Resources/gr.dic");
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

            //Printing General information on gr.dic
            System.out.println("There is a total of: " + count1 + " words in gr.dic");
            System.out.println("The average size of a word in gr.dic is: " + sum);
            System.out.println("There are: " + count2 + " Palindromes");
            System.out.println("These are:");
            for (String cur : arr)
                System.out.println(" - " + cur);

            //Printing the percentage of palindromes in gr.dic
            float percent = (float) count2/count1;
            System.out.println("That represents " + percent*100 + "% of the words in gr.dic");
            System.out.println();

            //Printing Palindromes in reverse order
            System.out.println("The Palindromes in reverse order:");
            for (int i = arr.size() - 1; i >= 0; i--)
                System.out.print(arr.get(i) + " ");
            System.out.println();

            //Assigning each letter of the Greek alphabet to a number
            char[] alphabet = new char[25]; //24 Letters and 1 extra for the final s
            for(int i = 0; i < 24; i++)
            {
                int tmp = 'α' + i;
                alphabet[i] = (char)tmp;
            }

            //Creating a MusicScore in order to assign each letter
            //Of the alphabet its own score, to be later played as music
            MusicScore Letters = new MusicScore(alphabet);
            for(int i = 0; i < alphabet.length; i++)
                Letters.SymbolScore(alphabet[i], i + 60);

            for(String cur : arr)
            {
                Player p = new Player();
                cur = cur.toLowerCase();
                char[] temp = cur.toCharArray();

                String MusicString = "T[200] ";         //Giving a Fast tempo because otherwise it's too slow
                for(char c : temp)
                    MusicString += "[" + Letters.GetScore(c) + "]i "; //Creating the MusicString

                System.out.println("Now Playing Word: " + cur);     //Printing the word you are currently
                System.out.println();                               //Listening to
                p.play(MusicString);
            }

            //Printing the time it took to run the process
            long end = System.nanoTime();
            long time = end - start;                //Printing the total time it took to do everything
            System.out.println();
            System.out.println("This operation took: " + (double)time/1000000000 + " seconds.");

            reader.close();             //Closing the FileStream to prevent data leaks
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}

/**
 * Class Used to Store an Alphabet and then uses that
 * In order to input a number in the form of a score to
 * each character of that given alphabet
 * if no score is given the default is (=0).
 */
class MusicScore {
    //The Class is not in the final Stage Many changes to be made to it many bugs to be fixed
    static char[] symbols = null;
    static int[] scores = null;

    static int GetScore(char symbol)
    {
        int index = 0;
        for(int i = 0; i < symbols.length; i++)
        {
            if (symbols[i] == symbol)
            {
                index = i;
                break;
            }
        }
        return scores[index];
    }

    static void SymbolScore(char symbol, int score)
    {
        for(int i = 0; i < symbols.length; i++)
        {
            if(symbol == symbols[i])
            {
                scores[i] = score;
                break;
            }
        }
    }

    MusicScore(char[] letters) {         //The main Constructor of MusicScore
        symbols = letters;
        scores = new int[symbols.length];
    }

    MusicScore() {               //Constructor (No arguments)
        this(null);
    }
}