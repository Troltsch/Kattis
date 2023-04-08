

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

class fiftyshades {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	String letters = br.readLine();
    	HashSet<Character> set = new HashSet<Character>();
    	for(int i=0;i<letters.length();++i)
    	{
    		set.add(letters.charAt(i));
    	}
    	char centerLetter = letters.charAt(0);
    	int n = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<n;++i)
    	{
    		String s = br.readLine();
    		boolean isOk = true;
    		boolean hasCenterLetter = false;
    		for(int j=0;j<s.length();++j)
    		{
    			char c = s.charAt(j);
    			if(c == centerLetter) hasCenterLetter = true;
    			if(!set.contains(c)) {
    				isOk = false;
    				break;
    			}
    		}
    		if(s.length() >= 4 && isOk && hasCenterLetter) System.out.println(s);
    	}
    	
    }

}
