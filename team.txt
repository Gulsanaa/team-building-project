package com.company;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Digraph {
    private final int numberOfVertices;           // number of vertices in this digraph
    private int numberOfEdges;                 // number of edges in this digraph
    private LinkedList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] degrees;        // indegree[v] = indegree of vertex v

    public Digraph(Scanner in) {
        if (in == null) throw new IllegalArgumentException("argument is null");
        try {
            this.numberOfVertices = in.nextInt();
            if (numberOfVertices < 0)
                throw new IllegalArgumentException("number of vertices in a Digraph must be non-negative");
            degrees = new int[numberOfVertices];
            adj = (LinkedList<Integer>[]) new LinkedList[numberOfVertices];
            for (int v = 0; v < numberOfVertices; v++) {
                adj[v] = new LinkedList<Integer>();
            }
            int numberOfEdges = in.nextInt();
            if (numberOfEdges < 0)
                throw new IllegalArgumentException("number of edges in a Digraph must be non-negative");
            for (int i = 0; i < numberOfEdges; i++) {
                int v = in.nextInt();
                int w = in.nextInt();
                addEdge(v, w);
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Digraph constructor", e);
        }
    }


    public int V() {
        return numberOfVertices;
    }


    public int E() {
        return numberOfEdges;
    }


    private void validateVertex(int v) {
        if (v < 0 || v >= numberOfVertices)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (numberOfVertices - 1));
    }


    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        degrees[w]++;
        numberOfEdges++;
    }


    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public int indegree(int v) {
        validateVertex(v);
        return degrees[v];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(numberOfVertices + " vertices, " + numberOfEdges + " edges " + "\n");
        for (int v = 0; v < numberOfVertices; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new Scanner(System.in));
        System.out.println(G);
    }

}

/* Example for INPUT:
13
22
 4  2
 2  3
 3  2
 6  0
 0  1
 2  0
11 12
12  9
 9 10
 9 11
 7  9
10 12
11  4
 4  3
 3  5
 6  8
 8  6
 5  4
 0  5
 6  4
 6  9
 7  6
 */