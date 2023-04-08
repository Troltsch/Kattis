

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


class sacredtexts {
 
    public static int runeToNumber(String s)
    {
    	int number = 0;
    	
    	for(int i=0;i<s.length();++i)
    	{
    		char c = s.charAt(i);    		
    		int numb = ((int)c) - 32;
    		number += numb;
    	}
    	
    	return number;
    }
    
    public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
    	String rune1 = sc.next();    	
    	int runeOffset = runeToNumber(rune1);
    	char startLetter = sc.next().charAt(0);
    	
    	char[] charArr = new char[26];    		
    	
    	int counter = 0;
    	for(char c = startLetter; c <= 'z';++c)
    	{
    		//System.out.println(c + " " + (runeOffset + counter) );
    		charArr[(runeOffset + counter)%26] = c;
    		++counter;
    	}
    	for(char c = 'a'; c < startLetter;++c)
    	{
    		//System.out.println(c + " " + (runeOffset + counter) );
    		charArr[(runeOffset + counter)%26] = c;
    		++counter;
    	}
    	
    	sc.nextLine();
		while(sc.hasNext())
		{
			String line = sc.nextLine();
			String[] runes = line.split(" ");
			
			for(String rune : runes)
			{
				
				if(rune.contains("0")) System.out.print(" ");
				else if(rune.contains("<")) System.out.print(",");
				else if(rune.contains(">")) System.out.print(".");
				else 
				{
					int runeNumber = runeToNumber(rune);
					//System.out.println(runeNumber + " " + (runeOffset + counter) );
					char c = charArr[runeNumber % 26];
					System.out.print(c);	
				}
			}
			System.out.println();
		}    	
    }

}
