package travellingcaterpillar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Scanner;

class travellingcaterpillar {
    //public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(System.in);
    
    static HashSet<Node> targetNodesSet = new HashSet<Node>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<Node> nodes = new ArrayList<Node>();
        for(int i=0;i<N;++i) nodes.add(new Node(i));

        ArrayList<Edge> edges = new ArrayList<Edge>();
        for(int i=0;i<N-1;++i)
        {
            Node from = nodes.get(sc.nextInt());
            Node to = nodes.get(sc.nextInt());
            int cost = sc.nextInt();

            Edge e = new Edge(from, to, cost);
            from.connectedEdges.add(e);
            edges.add(e);
        }

        
        for(int i=0;i<K;++i)
        {
            targetNodesSet.add(nodes.get(sc.nextInt()));
        }

        
        Node currentNode = nodes.get(0);
        recCall(currentNode);

        int total = 0;
        for(Edge e : edges)
        {
            if(e.addCost)
            {
                total += e.cost;
                //System.out.println("Added cost ("+ e.cost +") for edge: " + e.from.id + "-" + e.to.id);
            } 
            
        }
        System.out.println(total*2);
    } 

    public static boolean recCall(Node currentNode)
    {
        if(currentNode.visited) return false;
        currentNode.visited = true;

        if(targetNodesSet.contains(currentNode))
        {
           //System.out.println("Got node: " + currentNode.id);
            return true;
        } 

        boolean atLeastOne= false;
        for(Edge e : currentNode.connectedEdges)
        {
            Node targetNode = e.to;
            if(targetNode.visited) continue;
            if(recCall(targetNode))
            {
                e.addCost = true;
                atLeastOne = true;
            } 
        }

        return atLeastOne;
    }

    public static class Edge
    {
        Edge(Node from, Node to, int cost)
        {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        Node from;
        Node to;
        int cost;

        boolean addCost = false;
    }

    public static class Node
    {
        Node(int id)
        {
            this.id = id;
        }
        int id;
        ArrayList<Edge> connectedEdges = new ArrayList<Edge>();

        boolean visited = false;
    }
}
