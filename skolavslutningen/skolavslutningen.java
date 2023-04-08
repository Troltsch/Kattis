package Kattis.skolavslutningen;
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

public class skolavslutningen {
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    

    public static void main(String args[]) throws IOException 
    {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        HashSet<Character> set = new HashSet<Character>();
        char[][] arr = new char[N][M];
        for(int i=0;i<N;++i)
        {
            String in = br.readLine();
            for(int j=0;j<M;++j)
            {
                arr[i][j] = in.charAt(j);
                set.add(arr[i][j]);
            }
        }

        int counter = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(Character setEntry : set)
        {
            for(int j=0;j<M;++j)
            {
                boolean charIsInRow = false;
                ArrayList<Character> rowList = new ArrayList<Character>();
                for(int i=0;i<N;++i)
                {
                    Character c = arr[i][j];
                    rowList.add(c);
                    if(c == setEntry) charIsInRow = true;
                }

                if(!charIsInRow) continue;

                if(!map.containsKey(setEntry)) 
                {
                    counter++;
                    map.put(setEntry, counter);
                }
                Integer val = map.get(setEntry);

                for(Character c : rowList)
                {
                    map.put(c, val);
                }
            }
        }
        System.out.println(counter);
        
    }
/*
3 5 5
ABECE
BCDAE
CADBD
*/
}