/*
 * Interface for MapData.
 * @author Orion Meng
 */
interface MapDataInterface {
  public String[] getNeighbors();
  public String getLocation();
  public boolean isVisited();
}

/*
 * Object which stores data of each location.
 * @author Orion Meng
 */
public class MapData implements MapDataInterface {
  String location;
  boolean visited;
  /*
   * Constructor for MapData.
   */
  public MapData(String location) {
    this.location = location;
    this.visited = false;
  }
  /*
   * Returns an array of all neighboring locations.
   * @return an array of all neighboring locations.
   */
  @Override
  public String[] getNeighbors() {
    // TODO Auto-generated method stub
    return null;
  }
  /*
   * Returns location name.
   * @return location name.
   */
  @Override
  public String getLocation() {
    // TODO Auto-generated method stub
    return null;
  }
  /*
   * Returns if location has been visited.
   * @return if location has been visited.
   */
  @Override
  public boolean isVisited() {
    // TODO Auto-generated method stub
    return false;
  }
}