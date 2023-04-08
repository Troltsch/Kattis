package Kattis.asciifigurerotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class asciifigurerotation {
  // static Scanner sc = new Scanner(System.in);
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String args[]) throws IOException 
  {
    boolean first = true;
    while(true)
    {
      String input = br.readLine();
      int height = Integer.parseInt(input);
      if(height == 0) break;

      if(first) first = false;
      else bw.write("\n");

      String[] inputs = new String[height];
      int maxWidth = 0;
      for(int i=0;i<height;++i)
      {
        inputs[i] = br.readLine();
        maxWidth = Math.max(maxWidth, inputs[i].length());
      }

      char[][] arr2D = new char[height][maxWidth];
      for(int i=0;i<height;++i)
      {
        String inputLine = inputs[i];
        for(int j=0;j<inputLine.length();++j)
        {
          arr2D[i][j] = inputLine.charAt(j);
        }
        for(int j=inputLine.length();j<maxWidth;++j)
        {
          arr2D[i][j] = ' ';
        }
      }

      for(int j=0;j<maxWidth;++j)
      {
        int max = height -1;
        for(int i=0;i<height;++i)
        {
          Character c = arr2D[i][j];
          if(c == ' ') continue;
          max = i;
          break;
        }

        for(int i=height-1;i>=max;--i)
        {
          Character c = arr2D[i][j];
          if(c == 0) bw.write(' ');

          if(c == '-') bw.write('|');
          else if(c == '|') bw.write('-');
          else bw.write(c);
        }
        bw.write("\n");
      }
    }
    bw.flush();
  }
}