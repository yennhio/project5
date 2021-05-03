
import org.junit.Test;

public class BreadthUnitTests {
    
    BreadthFirst test = new BreadthFirst(6);

    @Test
    public void testAddEdge() {
        test.addEdge(0, 1);
    }

    @Test
    public void testBFS() {
        test.addEdge(0, 1);
        test.addEdge(1, 2);
        test.addEdge(1, 3);
        test.addEdge(2, 3);
        test.addEdge(3, 4);
        test.addEdge(2, 5);

        test.BFS(0);
    }
}
