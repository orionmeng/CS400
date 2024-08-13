import java.util.LinkedList;

/*
 * Interface for BuildingData.
 * @author Orion Meng
 */
interface BuildingDataInterface {
  public String getLocation();
  public LinkedList<RoadData> getRoadsLeaving();
}

/*
 * Object which stores data of each location.
 * @author Orion Meng
 */
public class BuildingData implements BuildingDataInterface {

  public String location;
  public LinkedList<RoadData> roadsLeaving;

  /*
   * Constructor for BuildingData.
   */
  public BuildingData(String location) {
    this.location = location;
    this.roadsLeaving = new LinkedList<>();
  }

  /*
   * Returns the name of the location.
   * @return the name of the location.
   */
  @Override
  public String getLocation() {
    return this.location;
  }

  /*
   * Returns a linked list of all roads leaving the location.
   * @return a linked list of all roads leaving the location.
   */
  @Override
  public LinkedList<RoadData> getRoadsLeaving() {
    return this.roadsLeaving;
  }

}
