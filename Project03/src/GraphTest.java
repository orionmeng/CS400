// --== CS400 File Header Information ==--
// Name: Orion Meng
// Email: dmeng8@wisc.edu
// Team: CC
// TA: Abhinav (agarwal72@cs.wisc.edu)
// Lecturer: Florian Heimerl
// Notes to Grader: testPathCtoE() tests predecessor of E

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.platform.console.ConsoleLauncher;
import java.lang.invoke.MethodHandles;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<String> graph;
    
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    @BeforeEach
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert vertices A-F
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        // insert edges from Week 11. Shortest Path Activity
        graph.insertEdge("A","B",6);
        graph.insertEdge("A","C",2);
        graph.insertEdge("A","D",5);
        graph.insertEdge("B","E",1);
        graph.insertEdge("B","C",2);
        graph.insertEdge("C","B",3);
        graph.insertEdge("C","F",1);
        graph.insertEdge("D","E",3);
        graph.insertEdge("E","A",4);
        graph.insertEdge("F","A",1);
        graph.insertEdge("F","D",1);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to F.
     */
    @Test
    public void testPathCostAtoF() {
        assertTrue(graph.getPathCost("A", "F") == 3);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to D.
     */
    @Test
    public void testPathCostAtoD() {
        assertTrue(graph.getPathCost("A", "D") == 4);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex A to D.
     */
    @Test
    public void testPathAtoD() {
        assertTrue(graph.shortestPath("A", "D").toString().equals(
            "[A, C, F, D]"
        ));
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex A to F.
     */
    @Test
    public void testPathAtoF() {
        assertTrue(graph.shortestPath("A", "F").toString().equals(
            "[A, C, F]"
        ));
    }

    /**
     * Checks the distance/total weight cost from the vertex A to E.
     */
    @Test
    public void testPathCostAtoE() {
        assertTrue(graph.getPathCost("A", "E") == 6);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex A to E.
     */
    @Test
    public void testPathAtoE() {
        assertTrue(graph.shortestPath("A", "E").toString().equals(
            "[A, C, B, E]"
        ));
    }

    /**
     * Checks the distance/total weight cost from the vertex B to F.
     */
    @Test
    public void testPathCostBtoF() {
        assertTrue(graph.getPathCost("B", "F") == 3);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex C to E.
     */
    @Test
    public void testPathCtoE() {
        assertTrue(graph.shortestPath("C", "E").toString().equals(
            "[C, B, E]"
        ));
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex F to D.
     */
    @Test
    public void testPathFtoD() {
        assertTrue(graph.shortestPath("F", "D").toString().equals(
            "[F, D]"
        ));
    }

    public static void main(String[] args) {
        String className = MethodHandles.lookup().lookupClass().getName();
        String classPath = System.getProperty("java.class.path").replace(" ", "\\ ");
        String[] arguments = new String[] {
          "-cp",
          classPath,
          "--include-classname=.*",
          "--select-class=" + className };
        ConsoleLauncher.main(arguments);
      }

}
