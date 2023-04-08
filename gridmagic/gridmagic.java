package Kattis.gridmagic;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;
import java.util.Map.Entry;

public class gridmagic {
    static Scanner sc = new Scanner(System.in);
    //static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static ArrayList<Integer> results = new ArrayList<Integer>();

    public static void main(String args[]) throws IOException 
    {
        int N = sc.nextInt();
        int M = sc.nextInt();

        recPrime(0, N); // Fills ArrayList

        int sum = 0;
        for(int i=1;i<=M;++i)
        {
            sum = recAnalyze(new ArrayList<Integer>(), i);
            if(sum == 0) break;
        }
         
        System.out.println(sum);
    }

    static int digit(int val, int num) 
    {
        return val / (int)Math.pow(10, num) % 10;
    }

    static int validate(ArrayList<Integer> list)
    {
        int columns = list.get(0).toString().length();
        int rows = list.size();
        
        for(int i=0;i<columns;++i)
        {
            int sum = 0;
            for(int j=0;j<rows;++j)
            {
                sum *= 10;
                //sum += Integer.parseInt(new String(list.get(j).toString().charAt(i) + ""));
                sum += digit(list.get(j), i);
                
                if(!isPrime(sum)) return 0;
            }
        }
        
        return 1;
    }

    static int recAnalyze(ArrayList<Integer> list, int max)
    {
        if(list.size() == max) return validate(list);

        int sum = 0;
        for(Integer val : results)
        {
            ArrayList<Integer> newList = new ArrayList<Integer>(list);
            newList.add(val);
            sum += recAnalyze(newList, max);
        }
        return sum;
    }

    
    static void recPrime(int num, int iter)
    {
        for(int i=0;i<10;++i)
        {
            int val = num*10 + i;
            if(isPrime(val))
            {
                if(iter == 1) results.add(val);
                else recPrime(val, iter-1);
            }
        }
    }

    static boolean isPrime(int num)
    {
        if(num == 0 || num == 1) return false;
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
              return false;
            }
          }
          return true;
    }

    static boolean[] primes;
    static void generatePrimes(int val)
    {
        primes = new boolean[val];
        for(int i=0;i<val;++i) primes[i] = true;
        primes[0] = false;
        primes[1] = false;
        for (int i=2;i<Math.sqrt(val);++i)
        {
            for(int j=i*i;j<val;j+=i)
            {
                primes[j] = false;
            }
        }
    }
}