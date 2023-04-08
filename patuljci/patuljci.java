package Kattis.patuljci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class patuljci {
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void rec(ArrayList<Integer> tmpList)
    {
      if(tmpList.size() == 7) eval(tmpList);

      for(Integer i=tmpList.size();i<dwarves.size();++i)
      {
        if(tmpList.contains(i)) continue;
        
        tmpList.add(i);
        rec(tmpList);
        tmpList.remove(i);
      }
    }

    private static void eval(ArrayList<Integer> tmpList) 
    {
      int sum = 0;
      ArrayList<Integer> selected = new ArrayList<Integer>();
      for(int i=0;i<tmpList.size();++i)
      {
        selected.add(dwarves.get(tmpList.get(i)));
        sum +=dwarves.get(tmpList.get(i));
      }
      
      if(sum == 100)
      {
        for(Integer dwarf : dwarves)
        {
          if(selected.contains(dwarf))
          {
            System.out.println(dwarf);
          }
        }
        System.exit(0);
      }
    }

    static ArrayList<Integer> dwarves = new ArrayList<Integer>();
    public static void main(String args[]) throws IOException 
    {
      
      for(int i=0;i<9;++i)
      {
        dwarves.add(Integer.parseInt(br.readLine()));
      }

      rec(new ArrayList<Integer>());

    }
}