package magicalrunes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class magicalrunes {
    //public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException {
        String rune = sc.next();
        int D = sc.nextInt();
        int maxLength = rune.length();

        int val = runeToInt(rune);
        val += D;
        String newRune = intToRune(val, maxLength);
        System.out.println(newRune);
    }

    public static int runeToInt(String rune)
    {
        int val = 0;
        for(int i =0 ;i<rune.length();++i)
        {
            if(rune.charAt(i) == 'B') // A
            {
                val += Math.pow(2,i);
            }
        }
        return val;
    }

    public static String intToRune(int val, int maxLength)
    {
        String rune = "";
        int mask = 0x01;
        for(int i=0;i<maxLength;++i)
        {
            if((val&mask) >= 1) rune += "B";
            else rune += "A";
            mask = mask << 1;
        }
        return rune;
    }
}
