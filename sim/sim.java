package Kattis.sim;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sim {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Node {
        Character data;
        Node previous;
        Node next;

        public Node(Character data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    public static class LinkedList {
        private Node head;
        private Node tail;
        private int size;

        public LinkedList() {
            this.clear();
        }

        public Node getHead() {
            return this.head;
        }

        public int size() {
            return this.size;
        }

        public void clear() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public void removeLast() {
            if (this.tail == null) {
                // List is empty, nothing to remove
                return;
            } else if (this.head == this.tail) {
                // Only one node in the list
                this.head = null;
                this.tail = null;
            } else {
                Node previous = this.tail.previous;
                previous.next = null;
                this.tail = previous;
            }
            this.size--;
        }

        public void append(Character data) {
            Node newNode = new Node(data);
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                newNode.previous = this.tail;
                this.tail.next = newNode;
                this.tail = newNode;
            }
            this.size++;
        }

        public void append(LinkedList list) {
            if (list.head != null) {
                if (this.head == null) {
                    this.head = list.head;
                    this.tail = list.tail;
                } else {
                    this.tail.next = list.head;
                    list.head.previous = this.tail;
                    this.tail = list.tail;
                }
                this.size += list.size;
            }
        }

        // Other methods omitted for brevity
    }

    public static void main(String args[]) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            String input = br.readLine();
            var leftList = new LinkedList();
            var rightList = new LinkedList();

            for (int i = 0; i < input.length(); ++i) {
                char c = input.charAt(i);
                switch (c) {
                    case '[':
                        leftList.append(rightList);
                        var tmp = rightList;
                        rightList = leftList;
                        leftList = tmp;
                        leftList.clear();
                        break;
                    case ']':
                        leftList.append(rightList);
                        rightList.clear();
                        break;
                    case '<':
                        if (leftList.size() > 0)
                            leftList.removeLast();
                        break;
                    default:
                        leftList.append(c);
                        break;
                }
            }

            leftList.append(rightList);
            Node n = leftList.getHead();

            while (n != null) {
                bw.write(n.data);
                n = n.next;
            }

            bw.write('\n');
        }
        bw.flush();
    }
}
