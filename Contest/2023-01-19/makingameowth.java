package makingameowth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class makingameowth {
    //public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = sc.nextInt();
        int P = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        
        int meTimes = 0;
        int himTimes = 0;

        int current = 1;
        boolean start = true;
        while(true)
        {
            if(!start && (current % N) == 0) himTimes += 1;
            else
            {
                start = false;
                meTimes += 1; 
            } 

            current += 1;
            if(P == meTimes)
            {
                if((current % N) == 0)himTimes += 1;
                break;
            }
            
        }   

        
        System.out.println(meTimes*X + himTimes*Y);
    }
}
