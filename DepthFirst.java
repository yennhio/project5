import java.io.*;
import java.util.*;

public class DepthFirst {
   private int vertices; // No. of vertices

   // Adjacency List Representation
   private LinkedList<Integer> adj[];

   /** Constructor */
   @SuppressWarnings("unchecked") DepthFirst(int verts)
    {
        vertices = verts;
        adj = new LinkedList[verts];
        for (int i = 0; i < verts; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int verts, int end)
    {
        adj[verts].add(end);
    }
}