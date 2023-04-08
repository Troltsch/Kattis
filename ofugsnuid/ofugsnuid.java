package Kattis.ofugsnuid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Map.Entry;

public class ofugsnuid {
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws IOException 
    {
       ArrayList<Integer> list = new ArrayList<Integer>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i)
        {
            list.add(Integer.parseInt(br.readLine()));
        }
        
        for(int i=N-1;i>=0;--i)
        {
            System.out.println(list.get(i));
        }
    }
}