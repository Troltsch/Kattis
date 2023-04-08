import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;

public class espresso {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	String[] strings = br.readLine().split(" ");
    	int n = Integer.parseInt(strings[0]);
    	int s = Integer.parseInt(strings[1]);
    	
    	int refills = 0;
    	int waterLeft = s;
    	for(int i=0;i<n;++i)
    	{
    		String coffee = br.readLine();
    		int water = 0;
    		if(coffee.length() == 2) water += 1;
    		water += Integer.parseInt(coffee.charAt(0)+"");
    		
    		if(waterLeft < water)
    		{
    			refills += 1;
    			waterLeft = s;
    		}
    		
    		waterLeft -= water;
    	}
    	System.out.println(refills);
    	
    }
}