package Kattis.classpicture;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;
import java.util.Map.Entry;

public class classpicture {
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static ArrayList<Person> people;

    public static void main(String args[]) throws IOException 
    {
        String input;
        while((input = br.readLine()) != null)
        {
            int N = Integer.parseInt(input);
            people = new ArrayList<Person>(N);
            HashMap<String, Person> peopleMap = new HashMap<String, Person>();
            for(int i=0;i<N;++i)
            {
                Person p = new Person(br.readLine());
                people.add(p);
                peopleMap.put(p.name, p);
            }
            Collections.sort(people, new Person());
            
            for(Person personA : people)
            {
                for(Person personB : people)
                {
                    if(personA.equals(personB)) continue;
                    personA.likes.add(personB);
                }
            }

            int M = Integer.parseInt(br.readLine());
            for(int i=0;i<M;++i)
            {
                String[] namePair = br.readLine().split(" ");
                String nameA = namePair[0];
                String nameB = namePair[1];
                
                Person personA  = peopleMap.get(nameA);
                Person personB  = peopleMap.get(nameB);

                personA.likes.remove(personB);
                personB.likes.remove(personA);
            }

            
            boolean foundSolution = false;
            for(Person first : people)
            {
                ArrayList<Person> tmpPeople = new ArrayList<Person>();
                tmpPeople.add(first);
                foundSolution = rec(tmpPeople);
                if(foundSolution) break;
            }
            
            if(!foundSolution) System.out.println("You all need therapy.");
        }
    }

    private static boolean rec(ArrayList<Person> tmpPeople) 
    {
        if(tmpPeople.size() == people.size())
        {
            for(Person p : tmpPeople)
            {
                System.out.println(p.name);
            }
            return true;
        }

        Person lastPerson = tmpPeople.get(tmpPeople.size()-1);
        for(Person nextPerson : lastPerson.likes)
        {
            if(tmpPeople.contains(nextPerson)) continue;
            tmpPeople.add(nextPerson);
            boolean solution = rec(tmpPeople);
            if(solution) return true;
            tmpPeople.remove(nextPerson);
        }

        return false;
    }

    static class Person implements Comparator<Person>
    {
        Person(){}

        Person(String name)
        {
            this.name = name;
        }
        String name;
        ArrayList<Person> likes = new ArrayList<>();

        @Override
        public int compare(Person o1, Person o2) {
            return o1.name.compareTo(o2.name);
        }
    }
}