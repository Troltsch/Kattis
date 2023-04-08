package Kattis.bottledup;
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

public class bottledup {
    static Scanner sc = new Scanner(System.in);
    //static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws IOException 
    {
        double total = sc.nextDouble();  
        double big = sc.nextDouble();  
        double small = sc.nextDouble();

        for(int i=0;;++i)
        {
            double val = -(((small*i-total)/big));
            if(val == Math.round(val))
            {
                System.out.println((long)val + " " + (long)i);
                break;
            }
            if(val < 0)
            {
                System.out.println("Impossible");
                break;    
            }
            //1000 = x*9 + y*7
            //x:=108 
            //y:=4
            //x=-(((7*y-1000)/9))
            //if(x==Math.round(x))
        }
    }
}