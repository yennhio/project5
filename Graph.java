

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
}