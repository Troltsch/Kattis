package Kattis.dobra;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;
import java.util.Map.Entry;

public class dobra {
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static char[] codes = {'V','B','L'};

    public static void main(String args[]) throws IOException 
    {
       String input = br.readLine();
       String simplified = simplify(input);
       
       long sum = newRec(simplified);
       System.out.println(sum);
    }


    private static long newRec(String simplified) 
    {
        int usedChar = getNextChar(simplified);
        if(usedChar == -1)
        {
            return newEval(simplified);
        }
        
        long sum = 0;
        for(char c : codes)
        {
            StringBuilder word = new StringBuilder(simplified);
            word.setCharAt(usedChar, c);
            sum += newRec(word.toString());
        }


        return sum;
    }

    private static boolean letterCheck(String word) 
    {
        boolean hasLetterL = false;
        int vowelStreak = 0;
        int consonantStreak = 0;
        
        for(int i=0;i<word.length();++i)
        {
            char code = word.charAt(i);
            switch(code)
            {
                case 'A':
                case 'V':
                ++vowelStreak;
                consonantStreak = 0;
                break;

                case 'B':
                case 'C':
                ++consonantStreak;
                vowelStreak = 0;
                break;

                case 'L':
                ++consonantStreak;
                vowelStreak = 0;
                hasLetterL = true;
                break;    
            }
            
            if(vowelStreak == 3 || consonantStreak == 3) return false;
        } 
        
        return hasLetterL;
    }


    private static long newEval(String word) {
        if(!letterCheck(word)) return 0;        
        
        long combinations = 1;
        for(int i=0;i<word.length();++i)
        {
            char code = word.charAt(i);
            switch(code)
            {
                case 'V':
                combinations *= 5;
                break;

                case 'B':
                combinations *= 20;
                break;
            }
        }
        //System.out.println(word + ": " + combinations);
        return combinations;
    }


    static int getNextChar(String input)
    {
        for(int i=0;i<input.length();++i)
        {
            char code = input.charAt(i);
            if(code == '_') return i;
        }
        return -1;
    }


    static String simplify(String input)
    {
        String newString = "";
        for(int i=0;i<input.length();++i)
        {
            char code = input.charAt(i);
            if(isVowel(code)) newString += 'A';
            else if(code == 'L') newString += 'L';
            else if(code == '_') newString += '_';
            else newString += 'C';
        }
        return newString;
    }


    static boolean isVowel(char c)
    {
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }


}
