package Kattis.klockan2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


class klockan2 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException 
    {
        Long degree = sc.nextLong();

        for(int hour = 0;hour < 12;++hour)
        {
            for(int minute = 0;minute < 60;++minute)
            {
                long result = timeToDegree(hour, minute);
                if(result == degree)
                {
                    System.out.printf("%02d:%02d\n",hour,minute);
                    System.exit(0);
                }
            }
        }
    }

    
    static double DEGREES_PER_MINUTE = 360/60;
    static double DEGREES_PER_HOUR = 360/12;
    static double ADDITIONAL_HOUR_DEGREES_PER_MINUTE = DEGREES_PER_HOUR/60;

    private static long timeToDegree(double hour, double minute) 
    {
        double minuteDegreeDouble = minute*DEGREES_PER_MINUTE;
        double hourDegreeDouble = (hour*DEGREES_PER_HOUR) + (minute*ADDITIONAL_HOUR_DEGREES_PER_MINUTE);


        double total = (minuteDegreeDouble > hourDegreeDouble) ? (minuteDegreeDouble-hourDegreeDouble) : (360. - (hourDegreeDouble-minuteDegreeDouble));
        
        return (long)(total*10);
    }
}
