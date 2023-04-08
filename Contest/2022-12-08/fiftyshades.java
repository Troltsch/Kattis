

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class fiftyshades {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	int n = Integer.parseInt(br.readLine());
    	int sum = 0;
    	for(int i=0;i<n;++i)
    	{
    		String s = br.readLine();
    		s = s.toLowerCase();
    		if(s.contains("pink")) sum += 1;
    		else if(s.contains("rose")) sum += 1;
    	}
    	
    	if(sum == 0) System.out.println("I must watch Star Wars with my daughter");
    	else System.out.println(sum);
    }

}
