package Kattis.amsterdamdistance;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class amsterdamdistance {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String args[]) throws IOException 
    {
        // 6 5 2.0
        // 1 3 4 2
        int M = sc.nextInt();
        int N = sc.nextInt();
        double R = sc.nextDouble();

        int ax = sc.nextInt();
        int ay = sc.nextInt();
        int bx = sc.nextInt();
        int by = sc.nextInt();

        int xDiff = Math.abs(ax - bx); // Radial
        int yDiff = Math.abs(ay - by); // Linear

        double sum = 0;
        double linear = R/N * yDiff; // Linear

        double ratio = new Double(Math.min(ay, by))/N;
        double halfCircle = Math.PI*R;
        double radial = halfCircle/M * xDiff * ratio; // Radial

        sum = radial + linear;

        double direct = (ay+by)*R/N;
        System.out.println(Math.min(direct, sum));        
    }
}