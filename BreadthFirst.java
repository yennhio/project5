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
    public void addEdge(int verts,int end)
    {
        adj[verts].add(end);
    }

    void BFS(int start)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[vertices];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[start]=true;
        queue.add(start);
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            start = queue.poll();
            if (start == 0)
                System.out.print("A ");
            else if (start == 1)
                System.out.print("B ");
            else if (start == 2)
                System.out.print("C ");
            else if (start == 3)
                System.out.print("D ");
            else if (start == 4)
                System.out.print("E ");
            else if (start == 5)
                System.out.print("F ");
            else if (start == 6)
                System.out.print("G ");
            else if (start == 7)
                System.out.print("H ");
            else if (start == 8)
                System.out.print("I ");
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> iter = adj[start].listIterator();
            while (iter.hasNext())
            {
                int next = iter.next();
                if (!visited[next])
                {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}