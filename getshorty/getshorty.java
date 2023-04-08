package Kattis.getshorty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class getshorty {
    //public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(true)
        {
            int n = sc.nextInt(); // intersections
            int m = sc.nextInt(); // corridors
            if(m == 0 && n == 0) break;

            ArrayList<Node> nodes = new ArrayList<Node>();
            
            for(int i=0;i<n;++i)
            {
                nodes.add(new Node(i));
            }

            for(int i=0;i<m;++i)
            {
                int from = sc.nextInt();
                int to = sc.nextInt();
                double f = sc.nextDouble();

                Node fromNode = nodes.get(from);
                Node toNode = nodes.get(to);

                Edge edge = new Edge(fromNode, toNode, f);

                fromNode.edges.add(edge);
                toNode.edges.add(edge);
            }
            
            {
                Node startNode = nodes.get(0);
                startNode.size = 1.0;
                Node finalNode = nodes.get(n-1);

                PriorityQueue<Node> queue = new PriorityQueue<Node>(n, new Node(-1));
                queue.add(startNode);

                while(true)
                {
                    Node currentNode = queue.poll();
                    //System.out.println("CurrentNode: " + currentNode.id);

                    if(currentNode == finalNode)
                    {
                        System.out.println(String.format("%.4f", finalNode.size));
                        break;
                    }

                    for(Edge edge : currentNode.edges)
                    {
                        Node toNode = null;
                        if(edge.from.id == currentNode.id) toNode = edge.to;
                        else toNode = edge.from;
                        
                        double newSize = currentNode.size * edge.f;
                        if(newSize > toNode.size) toNode.size = newSize;

                        if(!toNode.visited)
                        {
                            toNode.visited = true;
                            queue.add(toNode);
                        }
                    }
                }
            }
        }
    }

    public static class Node implements Comparator<Node>
    {
        public Node(int id) {
            this.id = id;
            this.edges = new ArrayList<Edge>();
        }

        public boolean visited = false;
        public int id;
        public ArrayList<Edge> edges;
        public double size = 0;

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.size < o2.size) return 1;
            else if (o1.size > o2.size) return -1;
            return 0;
        }
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
0 1 0.9
1 2 0.9
0 2 0.8
2 1
1 0 1
0 0


*/