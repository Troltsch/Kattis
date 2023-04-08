package canadianseh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class canadianseh {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException {
        String s = br.readLine();
        
        if(s.substring(s.length()-3,s.length()).equals("eh?"))
        {
            System.out.println("Canadian!");
        }
        else
        {
            System.out.println("Imposter!");
        }
    }
}
