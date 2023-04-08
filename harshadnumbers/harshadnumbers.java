package Kattis.harshadnumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class harshadnumbers {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        long N = Long.parseLong(br.readLine());
        while(true)
        {
            boolean isHarshad = checkHarshad(N);
            if(isHarshad)
            {
                System.out.println(N);
                break;
            }
            ++N;
        }
    }

    private static boolean checkHarshad(long n) 
    {
        String asString = new String(n+"");
        long sum = 0;
        for(int i=0;i<asString.length();++i)
        {
            sum += Long.parseLong(asString.charAt(i)+"");
        }

        return (n%sum == 0);
    }
}
