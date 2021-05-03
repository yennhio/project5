public class Client {
    public static void main(String args[])
    {
        BreadthFirst g = new BreadthFirst(9);
 
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(1, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 7);
        g.addEdge(3, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        g.addEdge(8, 5);
        g.addEdge(5, 2);
        g.addEdge(5, 7);
        g.addEdge(2, 1);
 
        System.out.println("Breadth First Traversal "+
                           "starting from vertex A: ");
 
        g.BFS(0);

        DepthFirst f = new DepthFirst(9);
 
        f.addEdge(0, 1);
        f.addEdge(0, 3);
        f.addEdge(0, 4);
        f.addEdge(1, 4);
        f.addEdge(4, 5);
        f.addEdge(4, 7);
        f.addEdge(3, 6);
        f.addEdge(6, 7);
        f.addEdge(7, 8);
        f.addEdge(8, 5);
        f.addEdge(5, 2);
        f.addEdge(5, 7);
        f.addEdge(2, 1);

        System.out.println(
            "Depth First Traversal "
            + "starting from vertex A: ");
 
        f.DFS(0);
    }
}

