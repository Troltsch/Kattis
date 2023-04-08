package astrologicalsign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class astrologicalsign {
    //public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = sc.nextInt();
        
        for(int i=0;i<t;++i)
        {
            int day = sc.nextInt();
            String month = sc.next();
            String sign = toSign(day, month);
            System.out.println(sign);
        }
    }

    public static String toSign(int day, String month)
    {
        switch(month)
        {
            case "Jan":
            {
                if(day <= 20) return "Capricorn";
                return "Aquarius";
            }
            case "Feb":
            {
                if(day <= 19) return "Aquarius";
                return "Pisces";
            }
            case "Mar":
            {
                if(day <= 20) return "Pisces";
                return "Aries";
            }
            case "Apr":
            {
                if(day <= 20) return "Aries";
                return "Taurus";
            }
            case "May":
            {
                if(day <= 20) return "Taurus";
                return "Gemini";                
            }
            case "Jun":
            {
                if(day <= 21) return "Gemini";
                return "Cancer";
            }
            case "Jul":
            {
                if(day <= 22) return "Cancer";
                return "Leo";
            }
            case "Aug":
            {
                if(day <= 22) return "Leo";
                return "Virgo";
            }
            case "Sep":
            {
                if(day <= 21) return "Virgo";
                return "Libra";
            }
            case "Oct":
            {
                if(day <= 22) return "Libra";
                return "Scorpio";
            }
            case "Nov":
            {
                if(day <= 22) return "Scorpio";
                return "Sagittarius";
            }
            case "Dec":
            {
                if(day <= 21) return "Sagittarius";
                return "Capricorn";
            }
        }
        
        return "";
    }
}
