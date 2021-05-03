import org.junit.Test;

public class DepthUnitTests {
    
    DepthFirst test = new DepthFirst(6);

    @Test
    public void testAddEdge() {
        test.addEdge(0,2);
    }

    @Test
    public void testDFS() {
        test.addEdge(0, 1);
        test.addEdge(0, 2);
        test.addEdge(0, 3);
        test.addEdge(2, 3);
        test.addEdge(3, 4);
        test.addEdge(2, 5);

        test.DFS(0);
    }
}
