import java.io.*;
import java.util.*; 

public class BreadthFirst {

    private int vertices;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    /** Constructor */
    public BreadthFirst(int verts)
    {
        vertices = verts;
        adj = new LinkedList[verts];
        for (int i=0; i<verts; ++i)
            adj[i] = new LinkedList();
    }

    /** Adds an edge to the graph */
    public void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
}