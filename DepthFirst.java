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

    void DFSUtil(int verts, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[verts] = true;
        if (verts == 0)
                System.out.print("A ");
            else if (verts == 1)
                System.out.print("B ");
            else if (verts == 2)
                System.out.print("C ");
            else if (verts == 3)
                System.out.print("D ");
            else if (verts == 4)
                System.out.print("E ");
            else if (verts == 5)
                System.out.print("F ");
            else if (verts == 6)
                System.out.print("G ");
            else if (verts == 7)
                System.out.print("H ");
            else if (verts == 8)
                System.out.print("I ");
 
        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> iter = adj[verts].listIterator();
        while (iter.hasNext())
        {
            int next = iter.next();
            if (!visited[next])
                DFSUtil(next, visited);
        }
    }

    public void DFS(int verts)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[vertices];
 
        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(verts, visited);
    }
}