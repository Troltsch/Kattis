import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;

public class peasoup {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	int n = Integer.parseInt(br.readLine());
    	
    	boolean everywhere = true;
    	String firstRestaurant = "";
    	for(int i=0;i<n;++i)
    	{
    		int k = Integer.parseInt(br.readLine());
    		Restaurant restaurant = new Restaurant();
    		restaurant.restaurantName = br.readLine();
    	
    		for(int j=0;j<k;++j)
    		{
    			String menu = br.readLine();
    			
    			if(menu.equals("pancakes"))
    			{
    				restaurant.hasPancakes = true;
    			}
    			else if(menu.equals("pea soup")) 
    			{
    				restaurant.hasPeaSoup = true;
    			}
    			
    		}
    		
    		
    		if(restaurant.hasPancakes && restaurant.hasPeaSoup )
    			{
    			System.out.println(restaurant.restaurantName);
    			return;
    			}
    		
    	}
    	
    		System.out.println("Anywhere is fine I guess");  	
    	
    }
    
    static class Restaurant
    {
    	boolean hasPancakes = false;
		boolean hasPeaSoup = false;
		String restaurantName;
    }
}
