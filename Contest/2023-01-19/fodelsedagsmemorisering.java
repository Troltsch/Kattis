package fodelsedagsmemorisering;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Map.Entry;

class fodelsedagsmemorisering {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException {
        HashMap<String, Person> map = new HashMap<String, Person>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i)
        {
            String vals[] = br.readLine().split(" ");
            
            Person p = new Person(vals[0], Integer.parseInt(vals[1]), vals[2]);

            Person otherP = map.get(p.date);
            if(otherP == null)
            {
                map.put(p.date, p);
            }
            else
            {
                if(otherP.likeValue < p.likeValue)
                {
                    map.put(p.date, p);
                }
            }
        }

        System.out.println(map.entrySet().size());

        ArrayList<String> people = new ArrayList<>();
        for(Entry<String, Person> entry : map.entrySet() )
        {
            people.add(entry.getValue().name);
        }

        Collections.sort(people);
        for(String name : people)
        {
            System.out.println(name);
        }
    }

    public static class Person
    {
        Person(String name, int likeValue, String date)
        {
            this.name = name;
            this.likeValue = likeValue;
            this.date = date;
        }

        String name;
        int likeValue;
        String date;

    }
}
