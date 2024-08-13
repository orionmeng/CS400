import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * 
 * Interface
 * @author Xuyang Liu
 *
 */
interface CampusBackEndInterface {
        public void insertVertex(BuildingDataInterface data) throws IllegalArgumentException, NullPointerException;
        public void insertEdge(RoadDataInterface data) throws IllegalArgumentException, NullPointerException;
        public List<BuildingDataInterface> getShortestPath(BuildingDataInterface start, BuildingDataInterface end);
        public String printMap();
}

/**
 * placeholder
 * @author Xuyang Liu
 *
 */
class CampusBackEndPlaceholder implements CampusBackEndInterface {
        BuildingData shortest_start = new BuildingData("start");
        BuildingData shortest_end = new BuildingData("end");
        BuildingData onlyBuilding = new BuildingData("building");
        RoadData onlyRoad = new RoadData(shortest_start, shortest_end, 10);
        @Override
        public void insertVertex(BuildingDataInterface data) throws IllegalArgumentException, NullPointerException {
                this.onlyBuilding = (BuildingData) data;
        }
        @Override
        public void insertEdge(RoadDataInterface data) throws IllegalArgumentException, NullPointerException {
                this.onlyRoad = (RoadData) data;
        }
        @Override
        public List<BuildingDataInterface> getShortestPath(BuildingDataInterface start, BuildingDataInterface end) {
                List<BuildingDataInterface> list = new LinkedList<>();
                list.add(start);
                list.add(end);
                return list;
        }
        @Override
        public String printMap() {
                return "start --- end";
        }
}
