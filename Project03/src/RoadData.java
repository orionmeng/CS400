/*
 * Interface for RoadData.
 * @author Orion Meng
 */
interface RoadDataInterface {
  BuildingData getSource();
  BuildingData getDestination();
  int getWeight();
}

/*
 * Object which stores data of each road.
 * @author Orion Meng
 */
public class RoadData implements RoadDataInterface {

  BuildingData source;
  BuildingData destination;
  int weight;

  /*
   * Constructor for RoadData.
   * @param destination
   * @param weight
   */
  public RoadData(BuildingData source, BuildingData destination, int weight) {
    this.source = source;
    this.destination = destination;
    this.weight = weight;
  }

  /*
   * Returns the source location.
   * @return the source location.
   */
  @Override
  public BuildingData getSource() {
    return this.source;
  }

  /*
   * Returns the destination.
   * @return the destination.
   */
  @Override
  public BuildingData getDestination() {
    return this.destination;
  }

  /*
   * Returns the weight of the road.
   * @return the weight of the road.
   */
  @Override
  public int getWeight() {
    return this.weight;
  }

}
