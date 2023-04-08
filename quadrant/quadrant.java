package Kattis.quadrant;
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

public class quadrant {
    static Scanner sc = new Scanner(System.in);
    //static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws IOException 
    {
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        if(x > 0 && y > 0) System.out.println(1);
        if(x < 0 && y > 0) System.out.println(2);
        if(x < 0 && y < 0) System.out.println(3);
        if(x > 0 && y < 0) System.out.println(4);
    }
}