package Kattis.electionparadox;
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

public class electionparadox {
    static Scanner sc = new Scanner(System.in);
    //static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws IOException 
    {
        //3
        //11 3 3
        int N = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<N;++i)
        {
            list.add(sc.nextInt());
        }
        Collections.sort(list, Comparator.reverseOrder());

        int votes = 0;
        for(int i=0;i<N/2;++i)
        {
            votes += list.get(i);
        }
        for(int i=N/2;i<N;++i)
        {
            votes += (list.get(i)-1)/2;
        }
        System.out.println(votes);
    }
}