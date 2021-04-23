import java.util.Iterator;
import java.util.NoSuchElementException;
import ADTPackage.*;

public class Vertex<T> implements VertexInterface<T> {
    
    private T label;
    private ListWithIteratorInterface<Edge> edgeList; // Edges to neighbors
    private boolean visited;                          // True if visited
    private VertexInterface<T> previousVertex;        // On path to this vertex
    private double cost;                              // Of path to this vertex
    
    public Vertex(T vertexLabel)
    {
       label = vertexLabel;
       edgeList = new LinkedListWithIterator<>();
       visited = false;
       previousVertex = null;
       cost = 0;
    }


public boolean connect(VertexInterface<T> endVertex, double edgeWeight)
{
   boolean result = false;

   if (!this.equals(endVertex))
   {  // Vertices are distinct
      Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
      boolean duplicateEdge = false;

      while (!duplicateEdge && neighbors.hasNext())
      {
         VertexInterface<T> nextNeighbor = neighbors.next();
         if (endVertex.equals(nextNeighbor))
            duplicateEdge = true;
      } // end while

      if (!duplicateEdge)
      {
         edgeList.add(new Edge(endVertex, edgeWeight));
         result = true;
      } // end if
   } // end if

   return result;
} // end connect

public boolean connect(VertexInterface<T> endVertex)
{
   return connect(endVertex, 0);
} // end connect



protected class Edge
{
   private VertexInterface<T> vertex; // Vertex at end of edge
   private double weight;
   

   protected Edge(VertexInterface<T> endVertex, double edgeWeight)
   {
      vertex = endVertex;
      weight = edgeWeight;
   } // end constructor

   protected Edge(VertexInterface<T> endVertex)
   {
      vertex = endVertex;
      weight = 0;
   } // end constructor
   
   protected VertexInterface<T> getEndVertex()
   {
      return vertex; 
   } // end getEndVertex

   protected double getWeight() 
   {
      return weight; 
   } // end getWeight
} // end Edge


}
