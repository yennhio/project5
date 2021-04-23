

public class Graph<E> {
    private boolean [][] edges;
    private E[] labels;

    public Graph (int n) {
        edges = new boolean[n][n];
        labels = (E[]) new Object[n];
    }

    /** Gets the label of a vertex */
    public E getLabel (int vertex) {
        return labels[vertex];
    }

    /** Tests whether an edge exists */
    public boolean isEdge(int source, int target) {
        return edges[source][target];
    }

    /** Adds an edge */
    public void addEdge(int source, int target) {
        edges[source][target] = true;
    }

    /** Obtains a list of neighbors of a specified vertex */
    public int[] neighbors (int vertex) {
        int i;
        int count = 0;
        int[] answer;

        for (i=0;i<labels.length;i++) {
            if (edges[vertex][i])
                count++;
        }

        answer = new int[count];
        count = 0;
        for (i=0;i<labels.length;i++) {
            if (edges[vertex][i])
                answer[count++] = i;
        }
        return answer;
    }

    /** Removes an edge */
    public void removeEdge(int source, int target) {
        edges[source][target] = false;
    }

    /** Changes the label of a vertex in the graph. */
    public void setLabel(int vertex, E newLabel) {
        labels[vertex] = newLabel;
    }

    /** Determines the number of vertices in the graph. */
    public int size(){
        return labels.length;
    }

    public QueueInterface<T> getBreadthFirstTraversal(T origin) {
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<T>();
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<VertexInterface<T>>();
        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin);
        vertexQueue.enqueue(originVertex);

        while (!vertexQueue.isEmpty()) {
            VertexInterface<T> frontVertex = vertexQueue.dequeue();
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();

            while (neighbors.hasNext()) {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (!nextNeighbor.isVisisted()) {
                    nextNeighbor.visit();
                    traversalOrder.enqueue(nextNeighbor.getLabel());
                    vertexQueue.enqueue(nextNeighbor);
                }
            }
        }
        return traversalOrder;
    }
   
    public QueueInterface<T> getDepthFirstTraversal(T origin) {
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<T>();
        StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<>();

        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin);
        vertexStack.push(originVertex);

        while (!vertexStack.isEmpty()) {
            VertexInterface<T> topVertex = vertexStack.peek();
            VertexInterface<T> nextNeighbor = topVertex.getUnvisitedNeighbor();

            if (nextNeighbor != null) {
                nextNeighbor.visit();
                traversalOrder.enqueue(nextNeighbor.getLabel());
                vertexStack.push(nextNeighbor);
            }
            else
                vertexStack.pop();
        }
        return traversalOrder;
    }
}