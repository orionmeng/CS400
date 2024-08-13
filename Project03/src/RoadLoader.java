import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Interface for MapLoader.
 * @author Orion Meng
 */
interface RoadLoaderInterface {
  public List<RoadDataInterface> loadFile(String path) throws FileNotFoundException;
  public List<RoadDataInterface> loadDirectoryFiles(String path) throws FileNotFoundException;
}

/*
 * Loads map information from CSV file.
 * @author Orion Meng
 */
public class RoadLoader implements RoadLoaderInterface {

  /*
   * Loads a CSV file of BuildingData objects.
   * @param filePath path of CSV file
   * @return buildings list representation of CSV file
   * @throws FileNotFoundException if CSV file not found
   */
  @Override
  public List<RoadDataInterface> loadFile(String filePath) throws FileNotFoundException {
    File file = new File(filePath); // load file
    Scanner scnr = new Scanner(file); // scan file
    List<RoadDataInterface> roads = new LinkedList<>(); // file contents
    scnr.nextLine(); // skip header
    
    while(scnr.hasNextLine()) {
      String[] eachRoad = scnr.nextLine().split(",");
      if (eachRoad.length != 3) {
        continue;
      }
      roads.add(new RoadData(new BuildingData(eachRoad[0]), 
                new BuildingData(eachRoad[1]), 
                Integer.parseInt(eachRoad[2])));
    }
    scnr.close();
    return roads;
  }

  /*
   * Loads multiple CSV files from a directory.
   * @param directoryPath path of directory
   * @return buildings list representation of directory CSV file(s)
   * @throws FileNotFoundException if no CSV files are found
   */
  @Override
  public List<RoadDataInterface> loadDirectoryFiles(String directoryPath)
      throws FileNotFoundException {
    File folder = new File(directoryPath);
    List<RoadDataInterface> roads = new LinkedList<>();
    File[] files = new File(directoryPath).listFiles();
    for (int i = 0; i < files.length; i++) {
      roads.addAll(loadFile(files[i].getAbsolutePath()));
    }
    return roads;
  }

}
