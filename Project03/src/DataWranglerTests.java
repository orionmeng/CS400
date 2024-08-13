import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.io.File;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Scanner;

class DataWranglerTests {

  /*
   * Test case for BuildingData.
   * @author Orion Meng (Data Wrangler)
   */
  @Test
  public void DataWrangler_testBuildingData() {
    BuildingData building1 = new BuildingData("location1");
    BuildingData building2 = new BuildingData("location2");
    assertEquals(true, building1.getRoadsLeaving().isEmpty());
    assertEquals(true, building1.getLocation().equals("location1"));
    assertEquals(true, building2.getLocation().equals("location2"));
  }

  /*
   * Test case for RoadData.
   * @author Orion Meng (Data Wrangler)
   */
  @Test
  public void DataWrangler_testRoadData() {
    BuildingData building1 = new BuildingData("location1");
    BuildingData building2 = new BuildingData("location2");
    RoadData onlyRoad = new RoadData(building1, building2, 7);
    assertEquals(true, onlyRoad.getSource() == building1);
    assertEquals(true, onlyRoad.getDestination() == building2);
    assertEquals(true, onlyRoad.getWeight() == 7);
  }

  /*
   * Test case for BuildingLoader.
   * @author Orion Meng (Data Wrangler)
   */
  @Test
  public void DataWrangler_testBuildingLoader() {
    try {
      BuildingLoader buildingLoader = new BuildingLoader();
      List<BuildingDataInterface> buildingList = buildingLoader.loadFile("./data/madison_building.csv");
      String[] startsWith = new String[] {"Science Hall", "Education Building", "North Hall"};
      for (int i = 0; i < 3; i++) {
        assertEquals(buildingList.get(i).getLocation(), startsWith[i]);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      fail("DataWrangler_testBuildingLoader(): filenotfoundexception.");
    }
  }

  /*
   * Test case for RoadLoader.
   * @author Orion Meng (Data Wrangler)
   */
  @Test
  public void DataWrangler_testRoadLoader() {
    try {
      RoadLoader roadLoader = new RoadLoader();
      List<RoadDataInterface> roadList = roadLoader.loadFile("./data/madison_road.csv");
      /*
       * Science Hall,          Education Building, 351
       * Education Building,    Science Hall,       351
       * Science Hall,          Music Hall,         473
       */
      String[] startsWith1 = new String[] {"Science Hall", "Education Building", "Science Hall"};
      String[] startsWith2 = new String[] {"Education Building", "Science Hall", "Music Hall"};
      int[] startsWith3 = new int[] {351, 351, 473};
      for (int i = 0; i < 3; i++) {
        System.out.println("L");
        assertEquals(roadList.get(i).getSource(), startsWith1[i]);
        assertEquals(roadList.get(i).getDestination(), startsWith2[i]);
        assertEquals(roadList.get(i).getWeight(), startsWith3[i]);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      fail("DataWrangler_testRoadLoader(): filenotfoundexception.");
    }
  }

  /*
   * Runs all test methods.
   */
  public static void main(String[] args) {
  }
}
