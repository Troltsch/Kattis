package Kattis.lindenmayorsystem;
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

public class lindenmayorsystem {
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static ArrayList<Integer> results = new ArrayList<Integer>();

    public static void main(String args[]) throws IOException 
    {
        /*
        2 4
        A -> AB
        B -> A
        A
        */
        String[] input = br.readLine().split(" ");
        int rules = Integer.parseInt(input[0]);
        int iterations = Integer.parseInt(input[1]);
        
        HashMap<Character, String> ruleMap = new HashMap<Character, String>();
        for(int i=0;i<rules;++i)
        {
            String[] ruleArr = br.readLine().split(" ");
            ruleMap.put(ruleArr[0].charAt(0), ruleArr[2]);
            //System.out.println(ruleArr[0] + " to " + ruleArr[2]);
        }

        String sequence = br.readLine();
        for(int i=0;i<iterations;++i)
        {
            String manipulatedSequence = new String();
            for(int j=0;j<sequence.length();++j)
            {
                Character c = sequence.charAt(j);
                if(ruleMap.containsKey(c)) manipulatedSequence += ruleMap.get(c);
                else manipulatedSequence += c;
            }
            sequence = manipulatedSequence;
        }
        System.out.println(sequence);
    }
}