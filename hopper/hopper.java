package Kattis.hopper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;
import java.util.Map.Entry;

public class hopper {
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    

    public static void main(String args[]) throws IOException 
    {
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        long n = Long.parseLong(input1[0]);
        long D = Long.parseLong(input1[1]);
        long M = Long.parseLong(input1[2]);

        ArrayList<Node> nodes = new ArrayList<Node>((int)n);
        for(String value : input2)
        {
            long nodeValue = Long.parseLong(value);
            Node node = new Node(nodeValue);
            nodes.add(node);
        }

        for(int i=0;i<nodes.size()-1;++i)
        {
            Node currentNode = nodes.get(i);
            long stopNodeId = Math.min(i+D+1,nodes.size());
            for(int j=i+1; j<stopNodeId; ++j)
            {
                Node nextNode = nodes.get(j);
                long diff = Math.abs(currentNode.value - nextNode.value);
                if(diff <= M)
                {
                    currentNode.neighbors.add(nextNode);
                    nextNode.neighbors.add(currentNode);
                }
            }
        }

        long longestPath = 1;
        for(Node node : nodes)
        {
            long pathLength = DFS(node);
            longestPath = Math.max(pathLength, longestPath);
            resetNodes(nodes);
        }
        
        System.out.println(longestPath);
    }

    static void resetNodes(ArrayList<Node> nodes)
    {
        for(Node node : nodes) node.visited = false;
    }

    static long DFS(Node currentNode)
    {
        currentNode.visited = true;
        
        long longestPath = 1;
        for(Node node : currentNode.neighbors)
        {
            if(node.visited) continue;
            longestPath = Math.max(longestPath, DFS(node)+1);
        }

        return longestPath;
    }

    static class Node
    {
        Node(long value)
        {
            this.value = value;
        }

        long value;
        ArrayList<Node> neighbors = new ArrayList<Node>();
        boolean visited = false;
    }
}