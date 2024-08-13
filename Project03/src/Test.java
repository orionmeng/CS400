import java.util.NoSuchElementException;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class Test {

    //private CS400Graph<String> graph;
    
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    public void createGraph() {
        CS400Graph<String> graph = new CS400Graph<>();
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
    public static boolean testPathCostAtoF() {
      CS400Graph<String> graph = new CS400Graph<>();
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
      if (graph.getPathCost("A", "F") != 3) {
        return false;
      }
      return true;
    }

    /**
     * Checks the distance/total weight cost from the vertex A to E.
     */
    public static boolean testPathCostAtoE() {
      CS400Graph<String> graph = new CS400Graph<>();
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
      if (graph.getPathCost("A", "E") != 6) {
        return false;
      }
      return true;
    }

    /**
     * Checks the distance/total weight cost from the vertex A to E.
     */
    public static boolean testPathCostBtoF() {
      CS400Graph<String> graph = new CS400Graph<>();
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
      if (graph.getPathCost("B", "F") != 3) {
        return false;
      }
      return true;
    }

    /**
     * Checks the distance/total weight cost from the vertex A to D.
     */
    public static boolean testPathCostAtoD() {
      CS400Graph<String> graph = new CS400Graph<>();
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
      if (graph.getPathCost("A", "D") != 4) {
        return false;
      }
      return true;
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to D.
     */
    public static boolean testPathAtoD() {
      CS400Graph<String> graph = new CS400Graph<>();
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
      if (!graph.shortestPath("A", "D").toString().equals("[A, C, F, D]")) {
        return false;
      }
      return true;
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to F.
     */
    public static boolean testPathAtoF() {
      CS400Graph<String> graph = new CS400Graph<>();
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
      if (!graph.shortestPath("A", "F").toString().equals("[A, C, F]")) {
        return false;
      }
      return true;
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to E.
     */
    public static boolean testPathAtoE() {
      CS400Graph<String> graph = new CS400Graph<>();
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
      if (!graph.shortestPath("A", "E").toString().equals("[A, C, B, E]")) {
        return false;
      }
      return true;
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * C to E.
     */
    public static boolean testPathCtoE() {
      CS400Graph<String> graph = new CS400Graph<>();
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
      if (!graph.shortestPath("C", "E").toString().equals("[C, B, E]")) {
        return false;
      }
      return true;
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * F to D.
     */
    public static boolean testPathFtoD() {
      CS400Graph<String> graph = new CS400Graph<>();
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
      if (!graph.shortestPath("F", "D").toString().equals("[F, D]")) {
        return false;
      }
      return true;
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to X.
     */
    public static boolean testPathAtoX() {
      CS400Graph<String> graph = new CS400Graph<>();
      // insert vertices ABXY
      graph.insertVertex("A");
      graph.insertVertex("B");
      graph.insertVertex("X");
      graph.insertVertex("Y");
      // insert edges from Week 11. Shortest Path Activity
      graph.insertEdge("A","B",1);
      graph.insertEdge("X","Y",1);
      try {
        graph.shortestPath("A", "X");
      } catch (NoSuchElementException e) {
        return true;
      }
      return false;
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * 2 to 1.
     */
    public static boolean testPath2to1() {
      CS400Graph<String> graph = new CS400Graph<>();
      // insert vertices A-F
      graph.insertVertex("0");
      graph.insertVertex("1");
      graph.insertVertex("2");
      // insert edges from Week 11. Shortest Path Activity
      graph.insertEdge("0","1",9);
      graph.insertEdge("0","0",1);
      graph.insertEdge("0","1",4);
      graph.insertEdge("0","2",5);
      graph.insertEdge("2","0",2);
      graph.insertEdge("2","0",3);
      graph.insertEdge("0","2",4);
      if (!graph.shortestPath("2", "1").toString().equals("[2, 0, 1]")) {
        return false;
      }
      return true;
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * 6 to 11.
     */
    public static boolean testPath6to11() {
      CS400Graph<String> graph = new CS400Graph<>();
      // insert vertices A-F
      graph.insertVertex("1");
      graph.insertVertex("6");
      graph.insertVertex("11");
      // insert edges from Week 11. Shortest Path Activity
      graph.insertEdge("11","1",3);
      graph.insertEdge("6","11",3);
      graph.insertEdge("1","11",5);
      graph.insertEdge("6","6",1);
      graph.insertEdge("1","6",4);
      graph.insertEdge("6","1",6);
      graph.insertEdge("6","11",7);
      if (!graph.shortestPath("6", "11").toString().equals("[6, 11]")) {
        return false;
      }
      return true;
    }

    public static void main(String[] args) {
      System.out.println("testPathCostAtoF(): "+testPathCostAtoF());
      System.out.println("testPathCostAtoE(): "+testPathCostAtoE());
      System.out.println("testPathCostBtoF(): "+testPathCostBtoF());
      System.out.println("testPathCostAtoD(): "+testPathCostAtoD());
      System.out.println("testPathAtoD(): "+testPathAtoD());
      System.out.println("testPathAtoF(): "+testPathAtoF());
      System.out.println("testPathAtoE(): "+testPathAtoE());
      System.out.println("testPathCtoE(): "+testPathCtoE());
      System.out.println("testPathFtoD(): "+testPathFtoD());
      System.out.println("testPathAtoX(): "+testPathAtoX());
      System.out.println("testPath2to1(): "+testPath2to1());
      System.out.println("testPath6to11(): "+testPath6to11());
    }

}
