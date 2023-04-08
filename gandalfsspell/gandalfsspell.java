package Kattis.gandalfsspell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class gandalfsspell {
  // static Scanner sc = new Scanner(System.in);
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String args[]) throws IOException 
    {
      HashMap<Character, String> map = new HashMap<Character, String>();
      HashSet<String> set = new HashSet<String>();

      String input = br.readLine();
      String[] inputSplit = br.readLine().split(" ");

      if(input.length() != inputSplit.length)
      {
        System.out.println("False");
        return;
      }

      for(int i=0;i<input.length();++i)
      {
        Character currentChar = input.charAt(i);
        String currentString = inputSplit[i];        

        if(!map.containsKey(currentChar))
        {
          if(set.contains(currentString))
          {
            System.out.println("False");
            return;
          }
          set.add(currentString);
          map.put(currentChar, currentString);
        }
        else
        {
          String compareString = map.get(currentChar);
          if(!currentString.equals(compareString))
          {
            System.out.println("False");
            return;  
          }
        }
      }

      System.out.println("True");
    }
}