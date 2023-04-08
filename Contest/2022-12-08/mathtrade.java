

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class mathtrade {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //public static Scanner sc = new Scanner(System.in);
    
    public static ArrayList<Person> persons = new ArrayList<Person>();
    public static void main(String[] args) throws NumberFormatException, IOException {
    	int n = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<n;++i)
    	{
    		String[] arr = br.readLine().split(" ");
    		Person p = new Person();
    		p.name = arr[0];
    		p.from = arr[1];
    		p.to = arr[2];
    		persons.add(p);
    	}
    	
    	int max = 0;
    	for(Person p1 : persons)
    	{
    		int current =	findCircle(p1);
    		if(current > max) max = current;
    	}
    	
    	if(max > 0)
    	System.out.println(max);
    	else System.out.println("No trades possible");
    	
    }
    
    public static Person getNextPerson(String from)
    {
    	for(Person p : persons)
    	{
    		if(p.from.equals(from)) return p;
    	}
    	return null;
    }


	private static int findCircle(Person goalP) {
		
		int counter = 0;
		Person currentP = goalP;
		while(true)
		{
			Person foundP = getNextPerson(currentP.to);
			if(foundP == null) return 0;
			counter+=1;
			currentP = foundP;
			
			if(currentP == goalP) return counter;
		}
	}




	public static class Person
    {
    	String name;
    	
    	String from;
    	String to;
    }

}
