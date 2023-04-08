

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

class santaklas {
    //public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	int height = sc.nextInt();
    	int degree = sc.nextInt();
    	
    	if(degree >= 0 && degree <= 180) System.out.println("safe");
    	else	System.out.println((int)Math.abs(height / Math.sin(Math.toRadians(degree))));
    	    	    	    	
    }

}
