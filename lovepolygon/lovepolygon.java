package Kattis.lovepolygon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


class lovepolygon {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Node> people = new ArrayList<Node>();
    public static HashMap<String, Node> hashMap = new HashMap<String, Node>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());   
        
        for(int i=0;i<n;++i)
        {
            String[] s = br.readLine().split(" ");
            String name = s[0];
            String other = s[1];
            Node node = new Node(name, other);
            people.add(node);
            hashMap.put(name, node);
        }

        for(Node node : people)
        {
            Node otherNode = hashMap.get(node.other);
            otherNode.lovedBy.add(node);
        }

        if(n%2 == 1)
        {
            System.out.println("-1");
            return;
        }

        // Remove all matches from list
        ArrayList<Node> removeAfter = new ArrayList<Node>();
        for(Node node : people)
        {
            Node otherNode = hashMap.get(node.other);
            if(node.name.equals(otherNode.other))
            {
                removeAfter.add(node);
            }
        }
        for(Node node : removeAfter) people.remove(node);


        //
        System.out.println(people.size()/2);

        //
        /* 
        int counter = 0;
        for(Node node : people)
        {
            if(node.lovedBy.size() == 0)
            {
                // Steal
                Node other = hashMap.get(node.other);
                hashMap.get(other.other).lovedBy.remove(other);

                other.other = node.name;
                node.lovedBy.add(other);
                
                ++counter;
            }
        }
        */
    }

    public static Node getNode(String name)
    {
        return hashMap.get(name);
    }

    public static void connectNodes(String nodeName1, String nodeName2)
    {
        Node node1 = getNode(nodeName1);
        Node node2 = getNode(nodeName2);

        if(node1.other.equals(node2.name))

        node2.other = node1.name;
        node.lovedBy.add(other);

        hashMap.get(other.other).lovedBy.remove(other);
    }

    public static class Node
    {
        public Node(String name, String other) 
        {
            this.name = name;
            this.other = other;
            lovedBy = new ArrayList<Node>();
        }
        public String name;
        public String other;
        public ArrayList<Node> lovedBy;
    }
    public static class Edge
    {
        public Edge(Node from, Node to, double f) {
            this.from = from;
            this.to = to;
            this.f = f;
        }
        public Node from;
        public Node to;
        public double f;
    }
}

/*
3 3
0 1 0,9
1 2 0,9
0 2 0,8
2 1
1 0 1
0 0


*/