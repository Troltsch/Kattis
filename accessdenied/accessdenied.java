package Kattis.accessdenied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class accessdenied {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    

    public static void main(String args[]) throws IOException 
    {
      int time;
      String currentPassword = "a";
      while(true)
      {        
        System.out.println(currentPassword);
        String s = br.readLine(); // ACCESS DENIED (5 ms)
        time = parseTime(s);
        
        if(time == 5) // Not long enough
        {
          currentPassword += "a";
          continue;
        }

        //GetPositionToFlip:
        int pos = (time-5) / 9;

        char[] arr = currentPassword.toCharArray();
        if(arr[pos-1] == 'z') arr[pos-1] = 'A';
        else if(arr[pos-1] == 'Z') arr[pos-1] = '0';
        else arr[pos-1]++;

        currentPassword = new String(arr);
      }
    }

    public static int parseTime(String arg)
    {
      if(arg.equals("ACCESS GRANTED")) System.exit(0); // Done        
      
      // ACCESS DENIED (68 ms)
      arg = arg.substring(15);
      arg = arg.substring(0, arg.length() - 4);
      
      return Integer.parseInt(arg);
    }
}