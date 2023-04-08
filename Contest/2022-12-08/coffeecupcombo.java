import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class coffeecupcombo {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	int n = Integer.parseInt(br.readLine());
    	String s = br.readLine();
    	
    	int cups = 0;
    	int sum = 0;
    	for(int i=0;i<n;++i)
    	{
    		char c = s.charAt(i);
    		if(c == '0') // No machine
    		{
    			if(cups > 0)
    			{
    				cups -= 1;
    				sum += 1;
    			}
    		}
    		else 
    		{
    			sum += 1;
    			cups = 2;
    		}
    	}
    	System.out.println(sum);
    }
}
