

public class Graph<E> {
    private boolean [][] edges;
    private E[] labels;

    public Graph (int n) {
        edges = new boolean[n][n];
        labels = (E[]) new Object[n];
    }

    public E getLabel (int vertex) {
        return labels[vertex];
    }

    public boolean isEdge(int source, int target) {
        return edges[source][target];
    }

    public void addEdge(int source, int target) {
        edges[source][target] = true;
    }

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
}