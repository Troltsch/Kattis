package Kattis.eligibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Map.Entry;

public class eligibility {
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws IOException 
    {
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0;i<N;++i)
        {
            //EligibleContestant 2013/09/01 1995/03/12 10
            String[] input = br.readLine().split(" ");
            String name = input[0];
            String beginDate = input[1];
            String birthDate = input[2];
            int courses = Integer.parseInt(input[3]);

            System.out.print(name + " ");
            int beginYear = Integer.parseInt(beginDate.split("/")[0]);
            int bornYear = Integer.parseInt(birthDate.split("/")[0]);
            if(beginYear >= 2010) System.out.println("eligible");
            else if(bornYear >= 1991) System.out.println("eligible");
            else if(courses >= 41) System.out.println("ineligible");
            else
            {
                System.out.println("coach petitions");
            }

            // if beginDate >= 2010 -> eligable
            // if born >= 1991 -> eligable
            // if courses >= 41 -> ineligible
            // else coach petitions
        }
    }
}