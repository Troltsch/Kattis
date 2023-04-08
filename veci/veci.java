package Kattis.veci;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;
import java.util.Map.Entry;

public class veci {
    static Scanner sc = new Scanner(System.in);
    //static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static ArrayList<Integer> digits = new ArrayList<Integer>();
    static int value;
    static String input;

    public static void main(String args[]) throws IOException 
    {
        input = sc.nextLine();
        value = Integer.parseInt(input);

        
        for(int i=0;i<input.length();++i)
        {
            digits.add(Integer.parseInt(input.charAt(i)+""));
        }

        Collections.sort(digits);

        ArrayList<Integer> availableDigits = new ArrayList<Integer>(digits);
        for(Integer digit : availableDigits)
        {
            ArrayList<Integer> tmpList = new ArrayList<Integer>();
            ArrayList<Integer> availableList = new ArrayList<Integer>(availableDigits);
            availableList.remove(digit);
            tmpList.add(digit);
            rec(availableList, tmpList);
        }

        System.out.println(0);
    }

    private static void rec(ArrayList<Integer> digits, ArrayList<Integer> currentTmpList) 
    {
        if(currentTmpList.size() == input.length())
        {
            int currentValue = 0;
            for(int i=0;i<currentTmpList.size();++i)
            {
                currentValue += Math.pow(10,currentTmpList.size()-i-1) * currentTmpList.get(i);
            }
            if(currentValue > value)
            {
                System.out.println(currentValue);
                System.exit(0);
            }
            return;
        }

        ArrayList<Integer> availableDigits = new ArrayList<Integer>(digits);
        for(Integer digit : availableDigits)
        {
            ArrayList<Integer> tmpList = new ArrayList<Integer>(currentTmpList);
            ArrayList<Integer> availableList = new ArrayList<Integer>(availableDigits);
            availableList.remove(digit);
            tmpList.add(digit);
            rec(availableList, tmpList);
        }
    }
}