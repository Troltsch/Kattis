

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class estimatingtheareaofacircle {
    //public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
    	while(true)
    	{
    		double r = sc.nextDouble();
        	double m = sc.nextDouble();
        	double c = sc.nextDouble();
        	if(r == 0 && m == 0 && c == 0) return;
        	
        	double area = Math.PI * r * r;
        	double estimation = 2*r*2*r * (c/m);
        	System.out.println(area + " " + estimation);	
    	}
    	
    	
    }

}
