

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class funhouse {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //public static Scanner sc = new Scanner(System.in);
    
    public enum Direction
    {
    	Up,
    	Right,
    	Down,
    	Left
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException 
    {	
    	int currentHouse = 0;
    	while(true)
    	{
    		currentHouse += 1;
	    	String[] input = br.readLine().split(" ");
	    	int W = Integer.parseInt(input[0]);
	    	int L = Integer.parseInt(input[1]);
	    	
	    	if(W == 0 && L==0) break;
	    	
	    	Point currentP = new Point(0,0);
	    	char[][] arr = new char[W][L];
	    	for(int i=0;i<L;++i)
	    	{
	    		String s = br.readLine();
	    		for(int j=0;j<W;++j) 
	    		{
	    			char c = s.charAt(j);
	    			arr[j][i] = c;
	    			if(c == '*') 
	    			{
	    				currentP.x = j;
	    				currentP.y = i;
	    			}
	    		}
	    	}
	    	
	    	
	    	//System.out.println("CurrentP: " + currentP.x + " - " + currentP.y);
	    	char currentChar = arr[currentP.x][currentP.y];
	    	Direction currentDirection;
	    	
	    	// Get start direction
	    	if(currentP.x == 0) currentDirection = Direction.Right;
	    	else if(currentP.x == W-1) currentDirection = Direction.Left;
	    	else if(currentP.y == 0) currentDirection = Direction.Down;
	    	else currentDirection = Direction.Up;
	    	
	    	while(true)
	    	{
	    		// get nextPosition
	    		switch(currentDirection)
	    		{
	    		case Up:
	    			currentP.y -= 1;
	    			break;
	    		case Right:
	    			currentP.x += 1;
	    			break;
	    		case Down:
	    			currentP.y += 1;
	    			break;
	    		case Left:
	    			currentP.x -= 1;
	    			break;
	    		}
	    		
	    		char nextChar = arr[currentP.x][currentP.y];
	    		if(nextChar == 'x') // Final
	    		{
	    			arr[currentP.x][currentP.y] = '&';
	    			break;
	    		}
	    		else if(nextChar == '.') continue;
	    		else if(nextChar == '/')
	    		{
	    			switch(currentDirection)
	        		{
	        		case Up:
	        			currentDirection = Direction.Right;
	        			break;
	        		case Right:
	        			currentDirection = Direction.Up;
	        			break;
	        		case Down:
	        			currentDirection = Direction.Left;
	        			break;
	        		case Left:
	        			currentDirection = Direction.Down;
	        			break;
	        		}
	    		}
	    		else if(nextChar == '\\')
	    		{
	    			switch(currentDirection)
	        		{
	        		case Up:
	        			currentDirection = Direction.Left;
	        			break;
	        		case Right:
	        			currentDirection = Direction.Down;
	        			break;
	        		case Down:
	        			currentDirection = Direction.Right;
	        			break;
	        		case Left:
	        			currentDirection = Direction.Up;
	        			break;
	        		}
	    		}
	    	}
	    	
	    	System.out.println("HOUSE " + currentHouse);
	    	
	    	for(int i=0;i<L;++i)
	    	{
	    		for(int j=0;j<W;++j) 
	    		{
	    			System.out.print(arr[j][i]);
	    		}
	    		System.out.println();
	    	}
    	}
    }
}
