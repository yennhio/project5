import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class TraversalUnitTests {
    
    BreadthFirst test = new BreadthFirst(9);

    @Test
    public void testAddEdge() {
        test.addEdge(0, 1);
    }
}
